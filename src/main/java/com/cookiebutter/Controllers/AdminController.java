package com.cookiebutter.Controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by luis on 04/10/16.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/")
    @Secured({"ADMIN"})
    public String index() {
        return "Hello there!";
    }
    @RequestMapping("/user/create")
    public String addUserForm() {
        return "Add me now :)";
    }
}
