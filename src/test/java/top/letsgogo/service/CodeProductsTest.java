package top.letsgogo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.letsgogo.controller.MainController;
import top.letsgogo.entity.CodeProducts;

import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainController.class)
public class CodeProductsTest {
    @Autowired
    CodeProductsService codeProductsService;

    @Test
    public void testAdd() {
        CodeProducts codeProducts = new CodeProducts("A0000001", "网站源码", "本站源码", "20", 20, 20);
        codeProductsService.addCodeProducts(codeProducts);
    }

    @Test
    public void testFindAll() {
        List<CodeProducts> codeProductses = codeProductsService.findAll();
        System.out.println(codeProductses.get(0).getProductName());
    }
}
