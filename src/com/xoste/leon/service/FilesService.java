package com.xoste.leon.service;

import com.xoste.leon.pojo.Files;
import com.xoste.leon.pojo.Users;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leon
 */
@Service
public interface FilesService {
    /**
     * 显示所有的文件
     * @return List<Files></Files>
     */
    List<Files> showFiles();

    /**
     * 根据id修改下载次数
     * @param id int
     * @param users Users
     * @param name String
     * @return int
     */
    int updateCount(int id, Users users, String name);
}
