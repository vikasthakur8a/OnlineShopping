package com.wipro.gateway.controller;

import com.wipro.gateway.entity.AuthRequest;
import com.wipro.gateway.entity.User;
import com.wipro.gateway.exception.InvalidCredentialsException;
import com.wipro.gateway.repository.UserRepo;
import com.wipro.gateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/jwt")
public class ApiController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepo repo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("hello world", HttpStatus.OK);
    }

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/authenticate")
    public String loginSuccess(Model model, @ModelAttribute("user") User user) throws InvalidCredentialsException {
        AuthRequest request = new AuthRequest(user.getUsername(), user.getPassword());
        String generatedToken = generateToken(request);
        model.addAttribute("token", generatedToken);
        return "success";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/login")
    public String registerUser(@ModelAttribute("user") User user) {
        addUser(user);
        return "redirect:/api/jwt/login";
    }

    public ResponseEntity<?> addUser(User user) {
        repo.save(user);
        return new ResponseEntity<>("User added Successfully", HttpStatus.CREATED);
    }

    public String generateToken(AuthRequest request) throws InvalidCredentialsException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (Exception e) {
            throw new InvalidCredentialsException("<h1> Invalid Credentials Exception: Please provide valid Credentials </h1>");
        }
        return jwtUtil.generateToken(request.getUsername());
    }

}
