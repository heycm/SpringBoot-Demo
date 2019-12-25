package com.test.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.test.springbootdemo.model.Student;
import com.test.springbootdemo.model.UserDefined;
import com.test.springbootdemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserDefined userDefined;

    @RequestMapping("findName")
    public List<Student> findByName(String... name){
        log.error("[测试error]");
        log.warn("[测试warn]");
        log.debug("[测试debug]");
        log.trace("[测试trace]");
        log.info("[根据多个名称模糊查询学生信息][请求参数:{}][结束]", JSON.toJSONString(name));
        long start = System.currentTimeMillis();
        List<Student> students = studentService.findByName(name);
        log.info("[根据多个名称模糊查询学生信息][查询结果:{}][耗时:{}ms][结束]", JSON.toJSONString(students), (System.currentTimeMillis() - start));
        return students;
    }

    /**
     * 取配置文件中的值
     */
    @RequestMapping("getValue")
    public UserDefined getValue(){
        return userDefined;
    }



}
