package top.letsgogo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.letsgogo.util.ZkManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panteng
 * @description
 * @date 17-6-9.
 */
@SpringBootApplication
@Controller
@RequestMapping("/")
@ComponentScan("top.letsgogo.*")
public class MainController {
    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "WELCOME TO LETSGOGO";
    }

    @RequestMapping("nodes")
    public String getZkNodes(Map<String, Object> map) {
        Map<String, Object> nodesMap = new HashMap<>();
        ZkManager.getAllNodesAndVlue("/", nodesMap);

        Map<String, String> webData = new HashMap<String, String>();
        for (Map.Entry entry : nodesMap.entrySet()) {
            webData.put(entry.getKey().toString(), entry.getValue().toString());
        }

        map.put("data", webData);
        return "nodes";
    }

    @RequestMapping("")
    public String defaultIndex(Map<String, Object> map) {
        return "index";
    }

    @RequestMapping("index")
    public String index(Map<String, Object> map) {
        return "index";
    }

    @RequestMapping("welfare")
    public static String welfarePage() {
        return "welfare";
    }

    @RequestMapping("ftl/{ftlname}")
    public static String getFtlPage(Map<String, Object> map, @PathVariable String ftlname) {
        return ftlname;
    }

    public static void main(String[] arges) {
        SpringApplication.run(MainController.class, arges);
    }
}
