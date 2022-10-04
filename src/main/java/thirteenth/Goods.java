package thirteenth;

import java.io.Serializable;

public class Goods implements Serializable {

    private String name;
    private int quantity;
    private int price;
    private int code;

    public Goods(int code, String name, int quantity, int price) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getGoodsName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getCode() {
        return this.code;
    }

    public int getPrice() {
        return this.price;
    }

    public void setGoodsName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
