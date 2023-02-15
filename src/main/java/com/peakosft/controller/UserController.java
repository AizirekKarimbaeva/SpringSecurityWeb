package com.peakosft.controller;

import com.peakosft.entity.Role;
import com.peakosft.entity.User;
import com.peakosft.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
//    @GetMapping
//    public String hello(){
//        return "hello";
//    }
    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("users",userService.getAll());
        return "users";
    }
    @GetMapping("/saveUser")
    public String save(Model model){
        model.addAttribute("user",new User());
        return "saveUser";
    }
    @PostMapping("/save")
    public String add(@ModelAttribute("user")User user){
        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping("/profile")
    public String profile(HttpServletRequest request, Model model){
        Principal principal = request.getUserPrincipal();
        model.addAttribute("user",userService.getUserByUsername(principal.getName()));
        return "profile";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
}

//@GetMapping("/roles/{id}")
//public String roles(@PathVariable("id")Long id, Model model){
//    Set<Role> roles = userService.getByRolesByUserId(id);
//            model.addAttribute("roles",roles);
//            return "roles";

}
