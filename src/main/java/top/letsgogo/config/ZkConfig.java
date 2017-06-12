package top.letsgogo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import top.letsgogo.util.ZkManager;

import java.util.Properties;

/**
 * @author panteng
 * @description
 * @date 17-6-12.
 */
@Component
public class ZkConfig implements CommandLineRunner {
    private static String configPath = "/service/configration";
    protected static Properties prop = new Properties();

    @Override
    public void run(String... strings) throws Exception {
        prop = ZkManager.getData(configPath);
        System.out.println("读取ZK配置... ...\n config=" + prop);
        //监听配置变化
        ZkManager.subscribeDataChanges(configPath, new ConfigDataListener());
    }

    public static String getConfigPath() {
        return configPath;
    }

}
