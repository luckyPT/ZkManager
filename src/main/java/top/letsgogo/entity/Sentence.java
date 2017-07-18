package top.letsgogo.entity;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-10.
 */
public class Sentence {
    @Id
    private String _id;         //此处与mongo默认的ID对应

    private String text;
    private List<String> keyWords;

    private SentenceType sentenceType;

    private String responce;

    public Sentence() {
    }

    public Sentence(String text, List<String> keyWords) {
        this.text = text;
        this.keyWords = keyWords;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public String getResponce() {
        return responce;
    }

    public void setResponce(String responce) {
        this.responce = responce;
    }

    public SentenceType getSentenceType() {
        return sentenceType;
    }

    public void setSentenceType(SentenceType sentenceType) {
        this.sentenceType = sentenceType;
    }
}
