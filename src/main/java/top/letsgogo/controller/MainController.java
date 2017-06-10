package top.letsgogo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.letsgogo.util.ZkManager;

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
    @RequestMapping("")
    @ResponseBody
    public String hello() {
        return "Welcome to, LETS GOGO";
    }

    @RequestMapping("index")
    public String index(Map<String, Object> map) {
        ZkManager.getAllNodesAndVlue("/", map);
        map.put("nodes", map);
        return "index";
    }

    public static void main(String[] arges) {
        SpringApplication.run(MainController.class, arges);
    }
}
