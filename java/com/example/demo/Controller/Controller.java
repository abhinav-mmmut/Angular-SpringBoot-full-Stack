package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;

@RestController
public class Controller {
	@Autowired
	private UserService userService;

	@PostMapping("/save-user")
	@CrossOrigin
	@Transactional
	public String registerUser(@RequestBody User user) {
		userService.saveMyUser(user);
		return "Hello "+user.getFirstname()+", your registration is successful!";
	}
	
	@GetMapping("/all-users")
	@CrossOrigin
	public Iterable<User> showAllUsers() {
		return userService.showAllUsers();
	}
	
	@GetMapping("/delete/{username}")
	@CrossOrigin
	@Transactional
	public Iterable<User> deleteUser(@PathVariable String username){
		return userService.deleteUserByUsername(username);
	}
	
	@GetMapping("/search/{username}")
	@CrossOrigin
	public User searchUser(@PathVariable String username) {
		return userService.findByUsername(username);
	}
}
