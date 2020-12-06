package com.xoste.leon.mapper;

import com.xoste.leon.pojo.Files;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Leon
 */
public interface FilesMapper {
    /**
     * 查询所有的文件
     * @return List<Files></Files>
     */
    @Select("select * from files")
    List<Files> selectFiles();

    /**
     * 根据id更新下载次数
     * @param id int
     * @return int
     */
    @Update("update files set count=count+1 where id=#{0}")
    int updateCount(int id);
}
