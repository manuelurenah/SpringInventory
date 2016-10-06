package com.cookiebutter.Controllers;

import com.cookiebutter.Models.Constants;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by luis on 04/10/16.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("template_name", "admin/index.ftl");
        return Constants.BASE_LAYOUT;
    }
    @RequestMapping("/user/create")
    public String addUserForm() {
        return "Add me now :)";
    }
}
