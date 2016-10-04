package com.cookiebutter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by luis on 04/10/16.
 */
@Controller
@RequestMapping(name = "/")
public class HomeController {
    @RequestMapping("/")
    public String index(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
