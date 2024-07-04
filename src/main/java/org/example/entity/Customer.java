package org.example.entity;


public class Customer { // this model class represent real world customer entity
    private String id;
    private String name;
    private String tel;
    private String address;

    public Customer(String id, String name,String tel, String address) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.address = address;
    }


}
