package com.zjz.demo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zjz.demo.model.UserModel;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public String login(HttpServletRequest request, @RequestParam("username") String username, Model model) {
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		UserModel m = new UserModel();
		m.setUsername(username);
		m.setPassword(password);
		model.addAttribute("user", m);
		return "java.html";
	}

}
