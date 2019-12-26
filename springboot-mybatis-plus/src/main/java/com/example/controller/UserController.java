package com.example.controller;

import com.example.service.IUserService;
import com.example.model.User;
import com.example.query.UserQuery;
import com.example.query.BatchDeleteCondition;
import com.example.common.ResponseMessage;
import com.example.common.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author heycm
 * @since 2019-12-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public IUserService userService;

    /**
     * 保存、修改 【区分id即可】
     * @param user  传递的实体
     * @return ResponseMessage
     */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseMessage save(@RequestBody User user){
        try {
            if(user==null){
                return Result.error("1000","参数为NUll");
            }
            userService.saveOrUpdate(user);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("保存对象失败！"+e.getMessage());
        }
    }

    //删除对象信息
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseMessage delete(@PathVariable("id") Long id){
        try {
            if(id==null){
                return Result.error("1000","参数为NUll");
            }
            userService.removeById(id);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("删除对象失败！"+e.getMessage());
        }
    }

    //批量删除
    @RequestMapping(value="/batchDelete",method=RequestMethod.POST)
    public ResponseMessage delete(@RequestBody BatchDeleteCondition condition){
        try {
            if(condition==null){
                return Result.error("1000","参数为NUll");
            }
            userService.removeByIds(condition.getIds());
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("批量删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseMessage get(@PathVariable("id")Long id) {
        try {
            if(id==null){
                return Result.error("1000","参数为NUll");
            }
            User entity = userService.getById(id);
            return Result.success(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取对象失败！"+e.getMessage());
        }
    }


    //查看所有的信息
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseMessage list(){
        try {
            List<User> entityList = userService.list();
            return Result.success(entityList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取对象列表失败！"+e.getMessage());
        }
    }


    /**
    * 分页查询数据：
    * @param query 查询对象
    * @return  ResponseMessage
    */
    @RequestMapping(value = "/pageList",method = RequestMethod.POST)
    public ResponseMessage pageList(@RequestBody UserQuery query) {
        try {
            if(query==null){
                return Result.error("1000","参数为NUll");
            }
            Page<User> page = new Page<User>(query.getPage(),query.getRows());
            IPage iPage= userService.page(page,null);
            return Result.success(iPage);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取分页对象列表失败！"+e.getMessage());
        }
    }
}
