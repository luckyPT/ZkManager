package top.letsgogo.auto;

import com.google.common.base.Strings;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import top.letsgogo.util.ZkManager;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;

/**
 * @author panteng
 * @description
 * @date 17-6-9.
 */
@Component
public class ServiceRegisterDiscover implements CommandLineRunner {
    @Value("${server.port}")
    private String serverPort;

    private final static String serviceNamePrefix = "service-api-";
    private final static String path = "/service/pool/" + serviceNamePrefix;
    /**
     * 被调用的服务名
     */
    private final static String[] nextServiceName = new String[]{"dao-api-"};
    /**
     * 被调用的服务所在根路径，应该与nextServiceName中的一一对应
     */
    private final static String[] nextServiceRootPath = new String[]{"/dao/pool"};

    private static Map<String, List<String>> nextServiceInfo = new HashMap<String, List<String>>();

    @Override
    public void run(String... strings) throws Exception {
        try {
            //首先注册向管理中心注册自己的服务
            String getPath = ZkManager.addNode(path + getIpAddress() + ":" + serverPort, "config", CreateMode.EPHEMERAL);
            if (!Strings.isNullOrEmpty(getPath)) {
                System.out.println(getPath + "服务注册成功");
            }
            discoverNextServiceInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发现服务，并监听变化
     */
    public static void discoverNextServiceInfo() {
        //去管理中心发现需要调用的服务
        Map<String, Object> map = new HashMap<>();
        ZkManager.getAllNodesAndVlue("/", map);
        for (Map.Entry entry : map.entrySet()) {//遍历所有服务
            for (int i = 0; i < nextServiceName.length; i++) {
                String servicePath = entry.getKey().toString();
                if (servicePath.indexOf(nextServiceName[i]) > -1) {
                    List<String> serviceList = nextServiceInfo.get(nextServiceName[i]);
                    if (serviceList == null) {
                        serviceList = new ArrayList<String>();
                    }
                    serviceList.add(servicePath);
                    nextServiceInfo.put(nextServiceName[i], serviceList);
                }
            }
        }
        printNextServiceInfo();
        //监听节点变化
        for (int i = 0; i < nextServiceRootPath.length; i++) {
            ZkManager.subscribeChildChanges(nextServiceRootPath[i], new ServiceListener(nextServiceName[i]));
        }
    }

    public static void printNextServiceInfo() {
        for (Map.Entry entry : nextServiceInfo.entrySet()) {
            System.out.print("发现服务名称：" + entry.getKey() + "  服务实例：");
            for (String str : (List<String>) entry.getValue()) {
                System.out.print(str + ",  ");
            }
            System.out.println();
        }
    }

    /**
     * 获取本机IP
     *
     * @return
     */
    public static String getIpAddress() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Map<String, List<String>> getNextServiceInfo() {
        return nextServiceInfo;
    }

    public static void setNextServiceInfo(Map<String, List<String>> nextServiceInfo) {
        ServiceRegisterDiscover.nextServiceInfo = nextServiceInfo;
    }
}
