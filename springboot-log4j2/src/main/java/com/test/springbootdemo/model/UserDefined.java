package com.test.springbootdemo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * .yml中自定义属性的使用
 */
@Data
@Component
@PropertySource("classpath:application.yml") // 读哪个文件
// @PropertySource(value = {"other.properties", "other.yml"})
@ConfigurationProperties(prefix = "user-defined") // 前缀
public class UserDefined {
    // 同名可以
    private Integer one;
    // 也可以注入
    @Value("${two}")
    private Integer propTwo;
    @Value("${three}")
    private String propThree;
    @Value("${any-other}")
    private String other;
    @Value("${isFour}")
    private boolean isFour;
    @Value("${isFive}")
    private boolean isFive;
}
