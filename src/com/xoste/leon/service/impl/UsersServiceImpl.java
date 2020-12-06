package com.xoste.leon.service.impl;

import com.xoste.leon.mapper.UsersMapper;
import com.xoste.leon.pojo.Users;
import com.xoste.leon.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Leon
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;
    /**
     * 添加用户
     * @param users Users
     * @return Users
     */
    @Override
    public int registerUsers(Users users) {
        return usersMapper.insertUsers(users);
    }
}
