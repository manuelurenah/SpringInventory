package com.cookiebutter.Controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import com.cookiebutter.Models.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MEUrena on 10/4/16.
 * All rights reserved.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("template_name", "index.ftl");
        return Constants.BASE_LAYOUT;
    }

    @RequestMapping("/unauthorized")
    public String requiresAdmin() {
        return "403";
    }

    @RequestMapping("/some")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String some(Model model) {
        model.addAttribute("template_name", "index.ftl");
        return BASE_LAYOUT;
    }

}
