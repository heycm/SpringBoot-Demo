package com.example.demo.msg;

import java.io.Serializable;

public class MessageB<T> implements Serializable {
    private Integer id;
    private T content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageB{" +
                "id=" + id +
                ", content=" + content +
                '}';
    }
}
