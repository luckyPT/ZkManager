package top.letsgogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.letsgogo.config.ConstantConfig;
import top.letsgogo.entity.Article;
import top.letsgogo.service.ArticleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-6-17.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    private final ResourceLoader resourceLoader;

    @Autowired
    public ArticleController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping("")
    @ResponseBody
    public List<Article> getArticles() {
        return articleService.findTop10ByPublishTimeDesc();
    }

    @RequestMapping(value = "image", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            java.nio.file.Files.copy(file.getInputStream(), Paths.get(ConstantConfig.IMAGE_PATH, file.getOriginalFilename()));
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return request.getRequestURL() + "/" + file.getOriginalFilename();
    }

    @RequestMapping(value = "image/{imageName}.{type}", method = RequestMethod.GET, produces = "image/*")
    public ResponseEntity<?> getFile(@PathVariable String imageName, @PathVariable String type, HttpServletResponse response) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ConstantConfig.IMAGE_PATH, imageName + "." + type).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("add")
    public void addArticle(String author, String keyWordsStr, Article article, HttpServletResponse response) {
        try {
            if (!"panteng".equals(author)) {
                response.getWriter().println("非法请求");
            }
            Long currentTime = System.currentTimeMillis();
            article.setId(currentTime + "");
            article.setKeyWords(keyWordsStr.split(","));
            String summary = article.getContent().replaceAll("<[^>]*>", "");
            summary = summary.substring(0, summary.length() > 60 ? 60 : summary.length());
            article.setSummary(summary);
            article.setAuthor(author);
            article.setPublishTime(currentTime + "");
            articleService.addArticle(article);
            response.getWriter().println("OK");
        } catch (Exception e) {
            System.out.println("添加文章失败，author=" + author + "  " + e.getMessage());
            try {
                response.getWriter().println("FAIL");
            } catch (Exception e1) {

            }
        }
    }
}
