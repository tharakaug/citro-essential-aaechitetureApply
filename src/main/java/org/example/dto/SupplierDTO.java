package org.example.dto;

import java.io.Serializable;

public class SupplierDTO implements Serializable {
    private String id;
    private String name;
    private String tel;

    public SupplierDTO(String id, String name,String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
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

    public void setTel(String tel) {
        this.tel = tel;
    }
    @Override
    public String toString() {
        return "SupplierDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
