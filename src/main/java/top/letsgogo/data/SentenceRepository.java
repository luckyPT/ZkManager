package top.letsgogo.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import top.letsgogo.entity.Sentence;

/**
 * @author panteng
 * @description
 * @date 17-7-10.
 */
@Component
public interface SentenceRepository extends MongoRepository<Sentence, String> {

}
