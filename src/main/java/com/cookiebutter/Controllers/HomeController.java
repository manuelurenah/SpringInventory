package com.cookiebutter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MEUrena on 10/4/16.
 * All rights reserved.
 */
@Controller
public class HomeController {

    public static final String BASE_LAYOUT = "header_footer";

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("template_name", "index.ftl");
        return BASE_LAYOUT;
    }

}
