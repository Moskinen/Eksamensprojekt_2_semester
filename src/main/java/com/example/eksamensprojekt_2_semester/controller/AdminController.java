package com.example.eksamensprojekt_2_semester.controller;

import com.example.eksamensprojekt_2_semester.model.Admin;
import com.example.eksamensprojekt_2_semester.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/login")
    public String login(){
        return "home/login";
    }

    //Handles login form submission if it fails the user is sent back to login
    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username,
                              @RequestParam String pwd) {
        Admin admin = adminService.getAdmin();

        if (admin.getUsername().equals(username) && admin.getPassword().equals(pwd)) {
            return "redirect:/admin_index";
        } else {
            return "home/login";
        }
    }

    @GetMapping ("/admin_index")
    public String admin_index(){
        return null;
    }

}
