package org.example.view.tdm;

public class EmployeeTM implements Comparable<EmployeeTM>{

    private String id;
    private String name;
    private String address;
    private String tel;
    private String mashId;

    public EmployeeTM(String id, String name,String address, String tel,String mashId) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.mashId = mashId;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel(){
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMashId(){
        return mashId;
    }

    @Override
    public String toString() {
        return "EmployeeTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", mashId='" + mashId + '\'' +
                '}';
    }
    @Override
    public int compareTo(EmployeeTM o) {
        return id.compareTo(o.getId());
    }
}
