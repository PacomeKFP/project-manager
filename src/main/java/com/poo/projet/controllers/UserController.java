package com.poo.projet.controllers;


import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poo.projet.models.User;
import com.poo.projet.models.require.UserRequire;
import com.poo.projet.services.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"", "/"})
    public void showUser(Model model){
        Iterable<User> users = userService.getUser();
        model.addAttribute("users", users);
    }

    @PostMapping("/createuser")
    public void createUser(@Valid @ModelAttribute UserRequire userRequire){
        userService.createUser(userRequire);
    }

    @PostMapping("/edituser")
    public void updateUser(Model model, @RequestParam UUID id, @Valid @ModelAttribute UserRequire userRequire){
        userService.updateUser(id, userRequire);
    }

    @GetMapping("/deleteuser")
    public void deleteUser(@RequestParam UUID id){
        userService.deleteUser(id);
    }

}
