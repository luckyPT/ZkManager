package top.letsgogo.config;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.Properties;

/**
 * @author panteng
 * @description
 * @date 17-6-12.
 */
public class ConfigDataListener extends ZkConfig implements IZkDataListener {

    @Override
    public void handleDataChange(String s, Object o) throws Exception {
        if (ZkConfig.getConfigPath().equals(s)) {
            System.out.println(s + "  " + o);
            ZkConfig.prop = (Properties) o;
            System.out.println("配置发生变化...\n config=" + ZkConfig.prop);
        }
    }

    @Override
    public void handleDataDeleted(String s) throws Exception {

    }
}
