package com.xoste.leon.controller;

import com.xoste.leon.pojo.Users;
import com.xoste.leon.service.UsersService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Leon
 */
@Controller
public class RegisterController {
    @Resource
    private UsersService usersServiceImpl;
    @RequestMapping("/register")
    public String registerUser(Users users, MultipartFile file, HttpServletRequest req) {
        try {
            String uuid = UUID.randomUUID().toString();
            String originalFilename = file.getOriginalFilename();
            String filename = uuid + originalFilename.substring(originalFilename.lastIndexOf("."));
            String realPath = req.getServletContext().getRealPath("images") + "/" + filename;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath));
            users.setImages(filename);
            int index = usersServiceImpl.registerUsers(users);
            if (index > 0) {
                req.getSession().setAttribute("users", users);
                return "redirect:/show";
            } else {
                return "redirect:/index.jsp";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
