package org.example.model;

import java.io.Serializable;

public class MachineDTO implements Serializable {
    private String id;
    private String name;
    private String desc;
    private String proId;

    public MachineDTO(String id, String name, String desc, String proId) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.proId = proId;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }
    @Override
    public String toString() {
        return "MachineDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", proId='" + proId + '\'' +
                '}';
    }
}
