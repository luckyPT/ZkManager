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
public class WordServiceTest {
    @Autowired
    WordService wordService;

    @Test
    public void testAddWord() {
        List<WordType> wordTypes = new ArrayList<>();
        wordTypes.add(WordType.TIME);

        Word word1 = new Word("今天", wordTypes, "今日", true);
        Word word2 = new Word("今日", wordTypes, "今日", true);
        Word word3 = new Word("这日", wordTypes, "今日", true);
        Word word4 = new Word("本日", wordTypes, "今日", true);
        Word word5 = new Word("此日", wordTypes, "今日", true);
        Word word6 = new Word("明天", wordTypes, "1天后", true);
        Word word7 = new Word("明日", wordTypes, "1天后", true);
        Word word8 = new Word("来日", wordTypes, "1天后", true);
        Word word9 = new Word("翌日", wordTypes, "1天后", true);
        Word word10 = new Word("晧日", wordTypes, "1天后", true);
        Word word11 = new Word("次日", wordTypes, "1天后", true);

        Word word12 = new Word("现在", wordTypes, "现在", true);
        Word word13 = new Word("当前", wordTypes, "现在", true);
        Word word14 = new Word("目前", wordTypes, "现在", true);
        Word word15 = new Word("此刻", wordTypes, "现在", true);
        Word word16 = new Word("此时", wordTypes, "现在", true);
        List<Word> words = new ArrayList<Word>();
        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        words.add(word5);
        words.add(word6);
        words.add(word7);
        words.add(word8);
        words.add(word9);
        words.add(word10);
        words.add(word11);
        words.add(word12);
        words.add(word13);
        words.add(word14);
        words.add(word15);
        words.add(word16);
        wordService.addWord(words);
    }

    @Test
    public void addWeatherTye() {
        List<WordType> wordTypes = new ArrayList<>();
        wordTypes.add(WordType.WEATHER_TYPE);

        Word word1 = new Word("阴", wordTypes, "阴", true);
        Word word2 = new Word("晴", wordTypes, "晴", true);
        Word word3 = new Word("雨", wordTypes, "雨", true);
        Word word4 = new Word("雪", wordTypes, "雪", true);
        Word word5 = new Word("多云", wordTypes, "多云", true);
        Word word6 = new Word("冰雹", wordTypes, "冰雹", true);
        Word word7 = new Word("霾", wordTypes, "霾", true);
        Word word8 = new Word("雾", wordTypes, "雾", true);
        Word word9 = new Word("风", wordTypes, "风", true);
        List<Word> words = new ArrayList<Word>();
        Word word10 = new Word("下雨", wordTypes, "雨", true);
        Word word11 = new Word("降雨", wordTypes, "雨", true);
        Word word12 = new Word("阵雨", wordTypes, "雨", true);
        Word word13 = new Word("雷阵雨", wordTypes, "雨", true);
        words.add(word10);
        words.add(word11);
        words.add(word12);
        words.add(word13);
        wordService.addWord(words);
    }

    @Test
    public void addQuestionWord() {
        List<WordType> wordTypes = new ArrayList<>();
        wordTypes.add(WordType.DENY);
        Word word1 = new Word("不", wordTypes, "否定", true);
        Word word2 = new Word("没", wordTypes, "否定", true);
        List<Word> words = new ArrayList<Word>();
        words.add(word1);
        words.add(word2);
        wordService.addWord(words);
    }

    @Test
    public void addOneWord() {
        List<WordType> wordTypes = new ArrayList<>();
        wordTypes.add(WordType.WEATHER_TYPE);
        Word word1 = new Word("下雨", wordTypes, "雨", true);
        Word word2 = new Word("大雨", wordTypes, "雨", true);
        Word word3 = new Word("小雨", wordTypes, "雨", true);
        Word word4 = new Word("中雨", wordTypes, "雨", true);
        Word word5 = new Word("降雨", wordTypes, "雨", true);
        Word word6 = new Word("暴雨", wordTypes, "雨", true);
        List<Word> words = new ArrayList<Word>();
        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        words.add(word5);
        words.add(word6);
        wordService.addWord(word1);
        wordService.addWord(word2);
        wordService.addWord(word3);
        wordService.addWord(word4);
        wordService.addWord(word5);
        wordService.addWord(word6);


    }
}
