package top.letsgogo.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import top.letsgogo.entity.CodeProducts;

import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-3.
 */
@Component
public interface CodeProductsRepository extends MongoRepository<CodeProducts, String> {

    public List<CodeProducts> findAll();
}
