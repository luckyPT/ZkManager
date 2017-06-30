package top.letsgogo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.letsgogo.controller.MainController;
import top.letsgogo.entity.Article;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author panteng
 * @description
 * @date 17-6-15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainController.class)
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void testSave() {
        System.out.println("-------test Start-------");
        Article article = new Article("13", "头条", new String[]{"abc", "java", "c++"}, "编程语言汇总", "一共有23中编程语言，分别如下：");
        article.setAuthor("潘腾");
        article.setPublishTime("2014080808");
        articleService.addArticle(article);
        System.out.println(articleService.findByTitle("时尚感爆棚的款式"));
    }

    @Test
    public void testRegex() {
        List<Article> articles = articleService.findByTitleRegex(Pattern.compile("^.{0,50}(女人)"));
        System.out.println(articles.get(10).toString());
    }

    @Test
    public void findByKeyWords() {
        List<Article> articles = articleService.findByKeyWords(Pattern.compile("^.*衣.*"));
        System.out.println("java = " + articles.get(0).toString());
    }

    @Test
    public void findTop10ByPublishTimeDesc() {
        List<Article> articles = articleService.findTop10ByPublishTimeDesc();
        System.out.println("find by publish time desc:" + articles.get(1).getPublishTime());
    }

    @Test
    public void findPage() {
        List<Article> articles = articleService.findAllByPage(0, 11);
        System.out.println(articles.get(10));
        articles = articleService.findAllByPage(1, 10);
        System.out.println(articles.get(0));
    }
}
