package com.example.common;


import lombok.Data;

@Data
public class ResponseMessage {
    //返回码
    private String respCode = "0";
    //返回消息
    private String message;
    //返回数据
    private Object data;
    //是否成功状态
    private boolean isSuccess = true;

    public ResponseMessage(){}

    public ResponseMessage(Object d){
        data = d;
    }

    public ResponseMessage(String respCode,String message,boolean isSuccess){
        this.respCode = respCode;
        this.message = message;
        this.isSuccess = isSuccess;
    }

}
