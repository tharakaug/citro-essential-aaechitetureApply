package org.example.entity;

public class OrderDetail {
    private String id;
    private String itemId;
    private int qty;

    public OrderDetail(String id, String itemId,int qty) {
        this.id = id;
        this.itemId = itemId;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id='" + id + '\'' +
                ", ItemId='" + itemId + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
