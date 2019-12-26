package com.example.common;

public class Result {
    /**
     * 成功
     * @return ResponseMessage
     */
    public static ResponseMessage success(){
        return new ResponseMessage();
    }

    /**
     *
     * @param data 查询到的数据
     * @return ResponseMessage
     */
    public static ResponseMessage success(Object data){
        return new ResponseMessage(data);
    }

    /**
     * 失败
     * @param code 错误码
     * @param message 错误提示信息
     * @return ResponseMessage
     */
    public static ResponseMessage error(String code,String message){
        return new ResponseMessage(code,message,false);
    }

    /**
     * 无错误码可调用此方法
     * @param message 错误信息
     * @return ResponseMessage
     */
    public static ResponseMessage error(String message){
        return new ResponseMessage("1",message,false);
    }
}
