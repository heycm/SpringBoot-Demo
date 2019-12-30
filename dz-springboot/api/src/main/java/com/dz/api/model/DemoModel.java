package com.dz.api.model;

import java.io.Serializable;

public class DemoModel implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
