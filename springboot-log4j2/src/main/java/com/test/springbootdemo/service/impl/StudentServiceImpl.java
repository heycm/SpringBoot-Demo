package com.test.springbootdemo.service.impl;

import com.test.springbootdemo.mapper.StudentMapper;
import com.test.springbootdemo.model.Student;
import com.test.springbootdemo.model.StudentExample;
import com.test.springbootdemo.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;

    @Override
    public List<Student> findByName(String... name) {
        if (name == null || name.length < 1){
            return null;
        }
        StudentExample studentExample = new StudentExample();
        for (String s : name) {
            StudentExample.Criteria criteria = studentExample.createCriteria().andSnameLike("%" + s + "%");
            studentExample.or(criteria);
        }
        return  studentMapper.selectByExample(studentExample);
    }
}
