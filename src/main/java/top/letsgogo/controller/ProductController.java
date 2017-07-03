package top.letsgogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.letsgogo.entity.CodeProducts;
import top.letsgogo.service.CodeProductsService;

import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-3.
 */
@Controller
@RequestMapping("/code")
public class ProductController {
    @Autowired
    CodeProductsService codeProductsService;

    @RequestMapping("all")
    @ResponseBody
    public List<CodeProducts> getAllCode() {
        return codeProductsService.findAll();
    }
}
