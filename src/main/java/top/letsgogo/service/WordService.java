package top.letsgogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.letsgogo.data.WordRepository;
import top.letsgogo.entity.Word;

import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-10.
 */
@Service
public class WordService {
    @Autowired
    WordRepository wordRepository;

    public boolean addWord(Word word) {
        try {
            wordRepository.save(word);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public boolean addWord(List<Word> iterator) {
        try {
            wordRepository.save(iterator);
            return true;
        } catch (Exception e) {
            System.out.println("批量插入数据失败：" + e.getMessage());
        }
        return false;
    }

    public Word findByText(String text) {
        Word word = wordRepository.findByText(text);
        return word;
    }
}
