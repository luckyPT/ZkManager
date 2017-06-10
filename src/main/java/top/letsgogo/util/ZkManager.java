package top.letsgogo.util;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.CreateMode;

import java.util.List;
import java.util.Map;

/**
 * @author panteng
 * @description
 * @date 17-6-9.
 */
public class ZkManager {
    private static String ZKServers = "10.38.164.80:2181,10.38.164.80:2182,10.38.164.80:2183";
    private static ZkClient zkClient = new ZkClient(ZKServers, 10000, 10000, new SerializableSerializer());

    /**
     * 遍历所有节点
     *
     * @param currentPath
     * @param nodes
     */
    public static void getAllNodesAndVlue(String currentPath, Map<String, Object> nodes) {
        try {
            List<String> stringList = zkClient.getChildren(currentPath);
            for (String childPath : stringList) {
                if ("/".equals(currentPath)) {
                    childPath = currentPath + childPath;
                } else {
                    childPath = currentPath + "/" + childPath;
                }
                try {
                    if (childPath.indexOf("zookeeper") > -1) {
                        continue;
                    }
                    Object nodeVlue = zkClient.readData(childPath);
                    nodes.put(childPath, nodeVlue);
                } catch (Exception e) {
                    System.out.println("node路径：" + childPath);
                    e.printStackTrace();
                }
                getAllNodesAndVlue(childPath, nodes);
            }
        } catch (Exception e) {
            if (e.getMessage().indexOf("KeeperErrorCode = NoNode for") > -1) {
                return;
            }
        }
    }

    /**
     * 增加不存在的节点，如果节点已经存在，返回""
     *
     * @param path
     * @param value
     * @param mode
     * @return 返回"" 表示增加失败
     */
    public static String addNode(String path, Object value, CreateMode mode) {
        try {
            if (zkClient.exists(path)) {
                return "";
            }
            return zkClient.create(path, value, mode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void subscribeChildChanges(String nodePath, IZkChildListener listener) {
        if (zkClient.exists(nodePath)) {
            zkClient.subscribeChildChanges(nodePath, listener);
        }
    }

    public static void main2(String[] arges) {
        ZkManager.addNode("/dao", "data operation", CreateMode.PERSISTENT);
        ZkManager.addNode("/service", "service provider", CreateMode.PERSISTENT);
        ZkManager.addNode("/controller", "work control", CreateMode.PERSISTENT);
        ZkManager.addNode("/dao/pool", "machine list", CreateMode.PERSISTENT);
        ZkManager.addNode("/service/pool", "machine list", CreateMode.PERSISTENT);
        ZkManager.addNode("/controller/pool", "machine list", CreateMode.PERSISTENT);
        ZkManager.addNode("/dao/configration", "machine list", CreateMode.PERSISTENT);
        ZkManager.addNode("/service/configration", "machine list", CreateMode.PERSISTENT);
        ZkManager.addNode("/controller/configration", "machine list", CreateMode.PERSISTENT);
        /*ZkManager.addNode("/controller/api1", "api1", CreateMode.EPHEMERAL);
        Map<String, Object> map = new HashMap<>();
        ZkManager.getAllNodesAndVlue("/", map);
        for (Map.Entry entry : map.entrySet()) {
            System.out.println("path=" + entry.getKey() + "  value=" + entry.getValue());
        }
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
