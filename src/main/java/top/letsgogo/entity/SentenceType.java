package top.letsgogo.entity;

/**
 * @author panteng
 * @description
 * @date 17-7-10.
 */
public enum SentenceType {
    STATEMENT("陈述句"), QUESTION("疑问句"), OTHER("其他");
    
    private String value;

    SentenceType(String in_value) {
        this.value = in_value;
    }
}
