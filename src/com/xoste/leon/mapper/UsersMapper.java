package com.xoste.leon.mapper;

import com.xoste.leon.pojo.Users;
import org.apache.ibatis.annotations.Insert;

/**
 * @author Leon
 */
public interface UsersMapper {
    /**
     * 增添用户
     * @param users Users to
     * @return int
     */
    @Insert("insert into users values(default, #{username}, #{password}, #{images})")
    int insertUsers(Users users);
}
