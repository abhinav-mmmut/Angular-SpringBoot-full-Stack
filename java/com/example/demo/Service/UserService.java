package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void saveMyUser(User user) {
		userRepository.save(user);
	}

	public Iterable<User> showAllUsers() {
		return userRepository.findAll();
	}

	public Iterable<User> deleteUserByUsername(String username) {
		userRepository.deleteByUsername(username);
		return userRepository.findAll();
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
