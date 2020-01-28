package com.example.vdue.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/register")
	@CrossOrigin(origins = "*")
	public String register(String name, HttpServletRequest request) {
		ServletContext application = request.getServletContext();
		@SuppressWarnings("unchecked")
		List<String> users = (List<String>) application.getAttribute("users");
		if (users == null || users.size() <= 0) {
			users = new ArrayList<>();
		}
		users.add(name);
		
		//模拟一个bug，让FindBugs找到bug
		String s1 = "abc";
		String s2 = "def";
		if (s1 == s2) {
			System.out.print(users.get(0));
		}
		
		application.setAttribute("users", users);

		return name + " Registered.";
	}

	@RequestMapping("/getUsers")
	@CrossOrigin(origins = "*")
	public List<String> getUsers(HttpServletRequest request) {
		ServletContext application = request.getServletContext();
		@SuppressWarnings("unchecked")
		List<String> users = (List<String>) application.getAttribute("users");
		if (users == null || users.size() <= 0) {
			users = new ArrayList<>();
		}

		return users;
	}

}
