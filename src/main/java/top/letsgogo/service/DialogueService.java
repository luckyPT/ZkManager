package top.letsgogo.service;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.letsgogo.data.WordRepository;
import top.letsgogo.entity.Sentence;
import top.letsgogo.entity.Word;
import top.letsgogo.entity.WordType;
import top.letsgogo.rpc.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-8.
 */
@Service
public class DialogueService {
    @Autowired
    WordRepository wordRepository;
    @Autowired
    SentenceService sentenceService;

    public void msgHandler(String msg) {
        try {
            //首先分词
            List<String> keyWords = Client.client.splitSentence(msg);
            Sentence sentence = new Sentence(msg, keyWords);
            System.out.println("对话关键词：" + keyWords);
            List<Word> words = new ArrayList<>();
            //得到每个单词的信息
            for (String word : keyWords) {
                if (!Strings.isNullOrEmpty(word)) {
                    Word word1 = wordRepository.findByText(word);
                    if (word1 != null) {
                        words.add(word1);
                    }
                }
            }
            System.out.println();
            //判断是不是疑问句
            boolean isQuestion = sentenceService.isQuestion(sentence);
            String place = "", time = "", weather = "";
            if (true) {//是疑问句，提取时间，地点，天气类型
                //查找地点
                for (Word word : words) {
                    if (word.getTypes().contains(WordType.PLACE)) {
                        place = word.getText();
                        System.out.print(word.getText());
                    }
                }
                //查找时间
                for (Word word : words) {
                    if (word.getTypes().contains(WordType.TIME)) {
                        time = word.getText();
                        System.out.print(word.getText());
                    }
                }
                //查找天气类型
                for (Word word : words) {
                    if (word.getTypes().contains(WordType.WEATHER_TYPE)) {
                        System.out.print(word.getText());
                        //根据天气类型，生成回复！
                        weather = "《关于" + word.getText() + "情况介绍》";
                    }
                }
                System.out.println();
                System.out.println("答复：" + place + time + weather);
            }

        } catch (Exception e) {
            System.out.println("出现未知异常：" + e.getMessage());
        }
    }
}
