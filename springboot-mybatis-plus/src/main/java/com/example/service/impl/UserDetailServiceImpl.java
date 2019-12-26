package com.example.service.impl;

import com.example.model.UserDetail;
import com.example.mapper.UserDetailMapper;
import com.example.service.IUserDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author heycm
 * @since 2019-12-26
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements IUserDetailService {

}
