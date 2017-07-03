package top.letsgogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import top.letsgogo.data.CodeProductsRepository;
import top.letsgogo.entity.CodeProducts;

import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-3.
 */
@Component
@EnableMongoRepositories(basePackages = "top.letsgogo.data")
public class CodeProductsService {
    @Autowired
    CodeProductsRepository codeProductsRepository;

    public boolean addCodeProducts(CodeProducts codeProducts) {
        try {
            codeProductsRepository.save(codeProducts);
            return true;
        } catch (Exception e) {
            System.out.println("增加商品错误：" + e.getMessage());
        }
        return false;
    }

    public List<CodeProducts> findAll() {
        return codeProductsRepository.findAll();
    }
}
