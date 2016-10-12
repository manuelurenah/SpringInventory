package com.cookiebutter.Controllers;

import com.cookiebutter.Models.Constants;
import com.cookiebutter.Models.CustomUserDetails;
import com.cookiebutter.Models.User;
import com.cookiebutter.Models.UserRoles;
import com.cookiebutter.Repositories.UserRepository;
import com.cookiebutter.Services.UserRolesService;
import com.cookiebutter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

/**
 * Created by MEUrena on 10/3/16.
 * All rights reserved.
 */

@Controller
@RequestMapping("/user")
@SessionAttributes("currentUser")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    UserRolesService userRolesService;

    @RequestMapping("/login")
    public String login(@RequestParam Optional<String> error,
                        @RequestParam Optional<String> logout,
                        Principal principal,
                        Model model) {
        if(principal != null) {
            if(!model.containsAttribute("currentUser")) {
                User user = userService.findByUsername(principal.getName());
                model.addAttribute("currentUser", user);
            }
            return "redirect:/";
        }
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        model.addAttribute("template_name", "user/login.ftl");
        return Constants.BASE_LAYOUT;
    }

    @GetMapping("/create")
    @Secured({"ROLE_ANONYMOUS"})
    public String createForm(@ModelAttribute(name = "newUser") User user, Model model) {
        model.addAttribute("template_name", "user/register.ftl");
        return Constants.BASE_LAYOUT;
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute(name = "newUser") User user,
                         @Valid BindingResult bindingResult,
                         @RequestParam("profile_pic") MultipartFile pic,
                         Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("template_name", "user/register.ftl");
            return Constants.BASE_LAYOUT;
        }
        else {
            if(!userService.exists(user.getUsername())) {
                UserRoles userRole = new UserRoles();
                userRole.setRole("ROLE_USER");
                userRole.setUser(user);
                user.getRoles().add(userRole);
                try {
                    user.setPicture(pic.getBytes());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                userService.create(user);
                userRolesService.create(userRole);
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(new CustomUserDetails(user), null);
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                return "redirect:/";
            }
            else {
                model.addAttribute("errors", "Username already exists.");
                model.addAttribute("template_name", "user/register.ftl");
                return Constants.BASE_LAYOUT;
            }
        }
    }

    @GetMapping("/view/{username}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String view(@PathVariable String username,
                       Model model) {
        User user = userService.findByUsername(username);
        model.addAttribute("user",user);
        model.addAttribute("template_name", "user/view.ftl");
        return Constants.BASE_LAYOUT;
    }

}
