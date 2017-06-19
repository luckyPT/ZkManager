package top.letsgogo.entity;

import org.springframework.data.annotation.Id;

/**
 * @author panteng
 * @description
 * @date 17-6-15.
 */
public class Article {
    @Id
    private String _id;//此处与mongo默认的ID对应

    private String id;//自定义ID
    private String title;
    private String summary;
    private String[] keyWords;
    private String content;

    private String author;
    private String publishTime;

    public Article() {
    }

    public Article(String id, String title, String[] keyWords, String summary, String content) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.keyWords = keyWords;
        this.content = content;
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String[] keyWords) {
        this.keyWords = keyWords;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "_id=" + _id + "&title=" + title + "&keyWords=" + keyWords + "&summary=" + summary;
    }
}
