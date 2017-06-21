package top.letsgogo.data;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import top.letsgogo.entity.Article;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author panteng
 * @description 更多细节，请阅读：http://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#repository-query-keywords
 * @date 17-6-15.
 */
@Component
public interface ArticleRepository extends MongoRepository<Article, String> {
    Article findByTitle(String title);

    Article findById(String id);

    /**
     * 正则表达式查询
     *
     * @param pattern
     * @return
     */
    List<Article> findByTitleRegex(Pattern pattern);

    List<Article> findBykeyWords(String keyWords);

    /**
     * 排序，限制返回个数
     *
     * @return
     */
    List<Article> findTop10ByOrderByPublishTimeDesc();

    Page<Article> findAll(org.springframework.data.domain.Pageable pageable);
}
