package top.letsgogo.entity;

public enum WordType {
    TIME("时间"),
    PLACE("地点"),
    WEATHER_TYPE("天气类型"),
    QUESTION("疑问词"),
    DENY("否定词"),
    OTHER("其他");

    public String value;

    WordType(String in_value) {
        this.value = in_value;
    }

    @Override
    public String toString() {
        return value;
    }
}