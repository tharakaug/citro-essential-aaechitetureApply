package org.example.entity;

public class Order {
    private String id;
    private String date;
    private String cusId;

    public Order(String id, String date,String cusId) {
        this.id = id;
        this.date = date;
        this.cusId = cusId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", cusId='" + cusId + '\'' +
                '}';
    }
}
