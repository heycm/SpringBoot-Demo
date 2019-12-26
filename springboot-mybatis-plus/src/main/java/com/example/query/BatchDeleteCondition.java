package com.example.query;

import lombok.Data;

import java.util.List;

/**
 * 基础查询对象
 */
@Data
public class BatchDeleteCondition {
    public List<Long> ids;
}

