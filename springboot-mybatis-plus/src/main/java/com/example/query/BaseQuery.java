package com.example.query;

import lombok.Data;

/**
 * 基础查询对象
 */
@Data
public class BaseQuery {
    //有公共属性-分页
    private Integer page ; //当前页
    private Integer rows ; //每页显示多少条


}

