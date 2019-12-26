package com.example.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 自动填充字段(createUser/createTime/modifyUser/modifyTime)
 */

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    // @Autowired
    // RedisTemplate<String,Object> redisTemplate;

    @Override
    public void insertFill(MetaObject metaObject) {
        //判断表里是否有createTime的方法,如果有可以再去加自动填充，因为我们几乎所有表都有，所以不加判断
        //boolean hasSetter = metaObject.hasSetter("createTime");
        boolean createUser = metaObject.hasSetter("createUser");
        boolean modifyUser = metaObject.hasSetter("modifyUser");
        setInsertFieldValByName("createTime", new Date(), metaObject);
        setInsertFieldValByName("modifyTime", new Date(), metaObject);
        setInsertFieldValByName("isDelete",0, metaObject);
        if(createUser){
            setInsertFieldValByName("createUser",getIdByToken(), metaObject);
        }
        if(modifyUser){
            setInsertFieldValByName("modifyUser",getIdByToken(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //加上判断你是否自己设置了修改时间，如果设置了这里不会填充
        Object modifyTime = getFieldValByName("modifyTime",metaObject);
        Object modifyUser = getFieldValByName("modifyUser",metaObject);
        if(modifyTime==null){
            setUpdateFieldValByName("modifyTime", new Date(), metaObject);
        }
        if(modifyUser==null){
            setUpdateFieldValByName("modifyUser",getIdByToken(), metaObject);
        }
    }
    private Integer getIdByToken(){
        // 没做redis缓存，暂时不用
        // HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // String token = request.getHeader("Authorization").substring(1, request.getHeader("Authorization").length() - 1);
        // return (Integer) redisTemplate.opsForValue().get(token);
        return 1;
    }
}
