package top.letsgogo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.letsgogo.controller.MainController;
import top.letsgogo.entity.Word;
import top.letsgogo.entity.WordType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainController.class)
public class MySqlServiceTest {
    @Autowired
    private MysqlDbService mysqlDbService;
    @Autowired
    private WordService wordService;

    @Test
    public void testGetAreaNames() {
        Long startTime = System.currentTimeMillis();
        List<String> areaNames = mysqlDbService.getAreasName();
        System.out.println("请求Mysql耗时：" + (System.currentTimeMillis() - startTime));
        System.out.println("区域数目：" + (areaNames == null ? "null" : areaNames.size()));

        for (String area : areaNames) {
            try {
                List<WordType> wordTypes = new ArrayList<>();
                wordTypes.add(WordType.PLACE);
                Word word = new Word(area, wordTypes, area, true);
                wordService.addWord(word);
            } catch (Exception e) {
                System.out.println("增加单词出现错误：" + e.getMessage());
            }

        }
    }
}
