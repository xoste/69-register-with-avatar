package com.xoste.leon.controller;

import com.xoste.leon.service.FilesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Leon
 */
@Controller
public class ShowController {
    @Resource
    private FilesService filesServiceImpl;

    @RequestMapping("/show")
    public String showFile(Model model) {
        model.addAttribute("listFiles", filesServiceImpl.showFiles());
        return "/jsp/success.jsp";
    }
}
