package top.letsgogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.letsgogo.data.SentenceRepository;
import top.letsgogo.data.WordRepository;
import top.letsgogo.entity.Sentence;
import top.letsgogo.entity.SentenceType;
import top.letsgogo.entity.Word;
import top.letsgogo.entity.WordType;

import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-10.
 */
@Service
public class SentenceService {
    @Autowired
    SentenceRepository sentenceRepository;
    @Autowired
    WordRepository wordRepository;

    /**
     * 判断是不是疑问句？
     *
     * @param sentence
     * @return
     */
    public boolean isQuestion(Sentence sentence) {
        String str = sentence.getText();
        //带有？ ?的认为是疑问句
        if (str.indexOf("?") > -1 || str.indexOf("？") > -1) {
            sentence.setSentenceType(SentenceType.QUESTION);
            return true;
        }
        //有疑问词的，判断为疑问句
        List<String> keyWords = sentence.getKeyWords();
        for (String wordstr : keyWords) {
            Word word = wordRepository.findByText(wordstr);
            if (word != null && word.getTypes().contains(WordType.QUESTION)) {
                sentence.setSentenceType(SentenceType.QUESTION);
                return true;
            }
        }
        //判断是不是否定词疑问句 A不A 或者 A没A;动词+否定词结尾认为是疑问句
        if (str.indexOf("不") > -1 || str.indexOf("没") > -1) {

        }
        return false;
    }
}
