package com.spring.boot.board.springbootboard.controller;

import com.spring.boot.board.springbootboard.dto.UserDto;
import com.spring.boot.board.springbootboard.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

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
    public String signup(UserDto userDto) {
        return "user/signup";
    }

    @PostMapping("/auth/signup")
    public String execSignup(@Valid UserDto userDto, Errors errors, Model model) {
        if(errors.hasErrors()){
            // 회원가입 실패시, 입력 데이터를 유지
            model.addAttribute("userDto", userDto);

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for(String key : validatorResult.keySet()){
                model.addAttribute(key, validatorResult.get(key));
            }
            return "user/signup";
        }
        userService.checkUsernameDuplication(userDto);
        userService.checkNicknameDuplication(userDto);
        userService.checkEmailDuplication(userDto);

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
