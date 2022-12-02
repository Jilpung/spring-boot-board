package com.spring.boot.board.springbootboard.controller;

import com.spring.boot.board.springbootboard.dto.UserDto;
import com.spring.boot.board.springbootboard.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/auth")
    public String index() {
        return "user/index.html";
    }

    @GetMapping("/auth/signup")
    public String singup(UserDto userDto) {
        return "user/signup";
    }

    @PostMapping("/auth/signup")
    public String execSignup(UserDto userDto) {
        userService.joinUser(userDto);

        return "redirect:/auth/login";
    }
    @GetMapping("/auth/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/auth/login/result")
    public String logoutResult() {
        return "redirect:/";
    }
    @GetMapping("/auth/logout/result")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/auth/denied")
    public String denied() {
        return "user/denied";
    }
    @GetMapping("/auth/info")
    public String userinfo() {
        return "user/userInfo";
    }

    @GetMapping("/admin")
    public String admin() {
        return "user/admin";
    }


}
