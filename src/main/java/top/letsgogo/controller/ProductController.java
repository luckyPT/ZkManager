package top.letsgogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.letsgogo.entity.CodeProducts;
import top.letsgogo.service.CodeProductsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping("add")
    @ResponseBody
    public void addProducts(HttpServletRequest request, HttpServletResponse response, CodeProducts codeProducts) {
        String pwd = request.getParameter("verifyCode");
        if (!"ABCD4321".equals(pwd)) {
            try {
                response.getWriter().write("ERROR");
                return;
            } catch (Exception e) {

            }
        }
        codeProductsService.addCodeProducts(codeProducts);
        try {
            response.getWriter().write("OK");
        } catch (Exception e) {
            System.out.println("增加商品出现异常：" + e.getMessage());
        }
    }
}
