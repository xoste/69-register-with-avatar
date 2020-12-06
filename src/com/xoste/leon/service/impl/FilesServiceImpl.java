package com.xoste.leon.service.impl;

import com.xoste.leon.mapper.FilesMapper;
import com.xoste.leon.pojo.Files;
import com.xoste.leon.pojo.Users;
import com.xoste.leon.service.FilesService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Leon
 */
@Service
public class FilesServiceImpl implements FilesService {
    @Resource
    private FilesMapper filesMapper;
    /**
     * 显示所有的文件
     *
     * @return List<Files></Files>
     */
    @Override
    public List<Files> showFiles() {
        return filesMapper.selectFiles();
    }

    /**
     * 根据id修改下载次数
     *
     * @param id int
     * @return int
     */
    @Override
    public int updateCount(int id, Users users, String name) {
        Logger logger = Logger.getLogger(FilesServiceImpl.class);
        logger.info(users.getUsername() + "在" + new Date().toString() + "下载了" + name);
        return filesMapper.updateCount(id);
    }
}
