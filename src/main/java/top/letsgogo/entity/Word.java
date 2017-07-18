package top.letsgogo.entity;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-10.
 */

public class Word {
    @Id
    private String _id;         //此处与mongo默认的ID对应

    private String text;
    //词的分类{时间、地点、天气类型、疑问词、其他}
    private List<WordType> types;
    private String standardValue;   //标准含义
    private JSONObject data;
    private boolean knowed;         //是否是未知单词

    public Word() {
    }

    public Word(String text, List<WordType> types, String standardValue, boolean knowed) {
        this.text = text;
        this.types = types;
        this.standardValue = standardValue;
        this.knowed = knowed;
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

    public List<WordType> getTypes() {
        return types;
    }

    public void setTypes(List<WordType> types) {
        this.types = types;
    }

    public String getStandardValue() {
        return standardValue;
    }

    public void setStandardValue(String standardValue) {
        this.standardValue = standardValue;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public boolean isKnowed() {
        return knowed;
    }

    public void setKnowed(boolean knowed) {
        this.knowed = knowed;
    }

    @Override
    public String toString() {
        return "Word{" +
                "_id='" + _id + '\'' +
                ", text='" + text + '\'' +
                ", types=" + types +
                ", standardValue='" + standardValue + '\'' +
                ", data=" + data +
                ", knowed=" + knowed +
                '}';
    }
}
