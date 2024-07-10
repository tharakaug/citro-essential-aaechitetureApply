package org.example.view.tdm;


import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class CustomerTM implements Comparable<CustomerTM> {
    private String id;
    private String name;
    private String tel;
    private String address;

    public CustomerTM(String id, String name,String tel, String address) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.address = address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(CustomerTM o) {
        return id.compareTo(o.getId());
    }
}
