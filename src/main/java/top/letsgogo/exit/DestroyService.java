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
        ZkManager.deleteNode(ServiceRegisterDiscover.getPath());
        System.out.println("程序结束... ...");
    }
}
