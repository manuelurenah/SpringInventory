package com.cookiebutter.Controllers;

import com.cookiebutter.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by MEUrena on 10/3/16.
 * All rights reserved.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    public static final String BASE_LAYOUT = "header_footer";

    @RequestMapping("/login")
    public String login(@RequestParam Optional<String> error,
                        @RequestParam Optional<String> logout,
                        Model model) {
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        model.addAttribute("template_name", "user/login.ftl");
        return BASE_LAYOUT;
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("template_name", "user/register.ftl");
        return BASE_LAYOUT;
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute User user,
                         BindingResult bindingResult,
                         Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("template_name", "user/register.ftl");
            return BASE_LAYOUT;
        }
        return "";
    }

}
