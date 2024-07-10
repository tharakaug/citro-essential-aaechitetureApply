package org.example.view.tdm;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
