package com.example.demo.msg;

import java.io.Serializable;

public class MessageA implements Serializable {
    private Integer id;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageA{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
