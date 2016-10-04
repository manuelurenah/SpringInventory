package com.cookiebutter.Controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by luis on 04/10/16.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    public String index() {
        return "Hello there!";
    }
    @Secured({"ADMIN"})
    @RequestMapping("/user/create")
    public String addUserForm() {
        return "Add me now :)";
    }
}
