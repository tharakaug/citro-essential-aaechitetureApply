package org.example.model;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private String id;
    private String name;
    private String tel;
    private String address;

    public CustomerDTO(String id, String name,String tel, String address) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.address = address;
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

    public String getTel() {
        return tel;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
