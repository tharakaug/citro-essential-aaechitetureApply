package org.example.view.tdm;

public class OrderDetailTM implements Comparable<OrderDetailTM>{
    private String id;
    private String itemId;
    private int qty;

    public OrderDetailTM(String id, String itemId,int qty) {
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
        return "OrderDetailTM{" +
                "id='" + id + '\'' +
                ", ItemId='" + itemId + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
    @Override
    public int compareTo(OrderDetailTM o) {
        return id.compareTo(o.getId());
    }
}
