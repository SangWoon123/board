package org.tukorea.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.board.domain.User;
import org.tukorea.board.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login") // 로그인 폼
	public String loginForm() {
		return "login/login";
	}
	
	@PostMapping("/login") // 로그인 검증
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) throws Exception {
        if (userService.authenticateUser(username, password)) {
            session.setAttribute("username", username);
            return "redirect:/board";
        } else {
            return "login/login";
        }
    }
	
	@GetMapping("/register") // 아이디 등록 폼
	public String registerForm() {
		return "login/register";
	}
		
	
	@PostMapping("/register") // 아이디 등록
	public String create(@ModelAttribute("user") User user) throws Exception{
		userService.userValidator(user);
		userService.createUser(user);
		return "redirect:/login";	
	}
	
	 @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/login";
	    }
	
}
