package com.cookiebutter.Controllers;

import com.cookiebutter.Models.Constants;
import com.cookiebutter.Models.User;
import com.cookiebutter.Repositories.UserRepository;
import com.cookiebutter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam Optional<String> error,
                        @RequestParam Optional<String> logout,
                        Model model) {
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        model.addAttribute("template_name", "user/login.ftl");
        return Constants.BASE_LAYOUT;
    }

    @GetMapping("/create")
    public String createForm(@ModelAttribute(name = "newUser") User user, Model model) {
        model.addAttribute("template_name", "user/register.ftl");
        return Constants.BASE_LAYOUT;
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute(name = "newUser") User user,
                         @Valid BindingResult bindingResult,
                         Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("template_name", "user/register.ftl");
            return Constants.BASE_LAYOUT;
        }
        else {
            if(!userService.exists(user.getUsername())) {
                userService.create(user);
                return "redirect:/";
            }
            else {
                model.addAttribute("errors", "Username already exists.");
                model.addAttribute("template_name", "user/register.ftl");
                return Constants.BASE_LAYOUT;
            }
        }
    }

}
