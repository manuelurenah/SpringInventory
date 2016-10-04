package com.cookiebutter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by MEUrena on 10/3/16.
 * All rights reserved.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    public static final String BASE_LAYOUT = "header_footer";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("template_name", "user/login.ftl");
        return BASE_LAYOUT;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("template_name", "user/register.ftl");
        return BASE_LAYOUT;
    }

}
