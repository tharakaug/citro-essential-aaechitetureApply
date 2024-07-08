package org.example.view.tdm;

public class ItemTM implements Comparable<ItemTM>{
    private String id;
    private String name;
    private double price;
    private int qty;

    public ItemTM(String id, String name,double price, int qty) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    @Override
    public String toString() {
        return "ItemTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
    @Override
    public int compareTo(ItemTM o) {
        return id.compareTo(o.getId());
    }
}
