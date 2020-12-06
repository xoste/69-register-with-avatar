package com.xoste.leon.controller;

import com.xoste.leon.pojo.Files;
import com.xoste.leon.pojo.Users;
import com.xoste.leon.service.FilesService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author Leon
 */
@Controller
public class DownloadController {
    @Resource
    private FilesService filesServiceImpl;
    @RequestMapping("/download")
    public void download(int id, String name, HttpServletResponse resp, HttpServletRequest req) {
        try {
            filesServiceImpl.updateCount(id, (Users)req.getSession().getAttribute("users"), name);
            resp.setHeader("Content-Disposition", "attachment;fileName=" + name);
            System.out.println("name..." + name);
            ServletOutputStream outputStream = resp.getOutputStream();
            String realPath = req.getServletContext().getRealPath("files");
            System.out.println("realPath..." + realPath);
            byte[] bytes = FileUtils.readFileToByteArray(new File(realPath, name));
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
