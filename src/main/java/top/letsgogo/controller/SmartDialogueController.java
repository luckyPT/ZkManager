package top.letsgogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author panteng
 * @description
 * @date 17-7-8.
 */
@Controller
@RequestMapping("/mier")
public class SmartDialogueController {
    @RequestMapping("")
    public String helloMier() {
        return "dialogue";
    }

    @RequestMapping("postmsg")
    public String listen(HttpServletRequest request, HttpServletResponse response) {

        return "";
    }
}
