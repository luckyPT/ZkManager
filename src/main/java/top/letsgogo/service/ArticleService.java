package top.letsgogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import top.letsgogo.data.ArticleRepository;
import top.letsgogo.entity.Article;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author panteng
 * @description
 * @date 17-6-15.
 */
@Component
@EnableMongoRepositories(basePackages = "top.letsgogo.data")
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public boolean addArticle(Article article) {
        articleRepository.save(article);
        return true;
    }

    public Article findByTitle(String title) {
        return articleRepository.findByTitle(title);
    }

    public List<Article> findByTitleRegex(Pattern pattern) {
        return articleRepository.findByTitleRegex(pattern);
    }

    public List<Article> findByKeyWords(String keyWords) {
        return articleRepository.findBykeyWords(keyWords);
    }

    public List<Article> findTop10ByPublishTimeDesc() {
        return articleRepository.findTop10ByOrderByPublishTimeDesc();
    }

    public List<Article> findAllByPage(int startIndex, int pageSize) {
        Page<Article> articles = articleRepository.findAll(new PageRequest(startIndex, pageSize));
        return articles.getContent();
    }
}
