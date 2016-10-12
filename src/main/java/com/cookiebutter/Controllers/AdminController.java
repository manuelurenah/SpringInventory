package com.cookiebutter.Controllers;

import com.cookiebutter.Models.Constants;
import com.cookiebutter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by luis on 04/10/16.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("users", new ArrayList<>());
        model.addAttribute("template_name", "admin/index.ftl");
        return Constants.BASE_LAYOUT;
    }
    @RequestMapping("/user/create")
    public String addUserForm() {
        return "Add me now :)";
    }

    @GetMapping("/reports")
    public String viewReports(Model model) {
        model.addAttribute("template_name", "admin/reports.ftl");

        return Constants.BASE_LAYOUT;
    }
}
