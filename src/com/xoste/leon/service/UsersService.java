package com.xoste.leon.service;

import com.xoste.leon.pojo.Users;
import org.springframework.stereotype.Service;

/**
 * @author Leon
 */
@Service
public interface UsersService {
    /**
     * 添加用户
     * @param users Users
     * @return int
     */
    int registerUsers(Users users);
}
