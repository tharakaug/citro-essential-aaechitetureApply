package org.example.view.tdm;

public class OrderTM implements Comparable<OrderTM>{
    private String id;
    private String date;
    private String cusId;

    public OrderTM(String id, String date,String cusId) {
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
        return "OrderTM{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", cusId='" + cusId + '\'' +
                '}';
    }
    @Override
    public int compareTo(OrderTM o) {
        return id.compareTo(o.getId());
    }
}
