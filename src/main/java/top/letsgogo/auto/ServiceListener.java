package top.letsgogo.auto;

import org.I0Itec.zkclient.IZkChildListener;

import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-6-10.
 */
public class ServiceListener implements IZkChildListener {
    String serviceName;

    public ServiceListener(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public void handleChildChange(String s, List<String> list) throws Exception {
        System.out.println("服务" + serviceName + "发生了变化");
        ServiceRegisterDiscover.getNextServiceInfo().put(serviceName, list);
        ServiceRegisterDiscover.printNextServiceInfo();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
