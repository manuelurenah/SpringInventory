package com.cookiebutter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by MEUrena on 10/3/16.
 * All rights reserved.
 */

@Controller
public class LoginController {

    @RequestMapping("/")
    public String login(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }

}
