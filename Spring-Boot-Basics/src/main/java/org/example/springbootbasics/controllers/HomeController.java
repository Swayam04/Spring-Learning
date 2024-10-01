package org.example.springbootbasics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "forward:pages/index.html";
    }

    @RequestMapping("/user")
    public String user(Model page) {
        page.addAttribute("username", "Swayam");
        page.addAttribute("color", "blue");
        return "pages/user";
    }

}
