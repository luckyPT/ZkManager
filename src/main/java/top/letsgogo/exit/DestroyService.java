package top.letsgogo.exit;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;
import top.letsgogo.auto.ServiceRegisterDiscover;
import top.letsgogo.util.ZkManager;

/**
 * @author panteng
 * @description
 * @date 17-6-12.
 */
@Component
public class DestroyService implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        try {
            ZkManager.deleteNode(ServiceRegisterDiscover.getPath());
        } catch (Exception e) {
            System.out.println("ZK服务注销异常" + e.getMessage());
        }
        System.out.println("程序结束... ...");
    }
}
