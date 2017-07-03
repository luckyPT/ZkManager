package top.letsgogo.entity;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-3.
 */
public class CodeProducts {
    @Id
    private String _id;         //此处与mongo默认的ID对应

    private String id;          //自定义ID
    private String productName; //商品名称
    private String productDesc; //商品描述
    private String price;       //价格
    private int reserveCount;   //库存
    private int sellCount;      //售出数量
    private List<String> comments;//评论

    public CodeProducts() {
    }

    public CodeProducts(String id, String productName, String productDesc, String price, int reserveCount, int sellCount) {
        this.id = id;
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
        this.reserveCount = reserveCount;
        this.sellCount = sellCount;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getReserveCount() {
        return reserveCount;
    }

    public void setReserveCount(int reserveCount) {
        this.reserveCount = reserveCount;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
