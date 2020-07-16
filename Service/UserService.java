package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.User;
import com.example.demo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	private List <User> users= new ArrayList<>(Arrays.asList(
			new User("1","Tendai","Mamini","tendaimamini@gmail.com","5467 nkwisi gardens"),
			new User("2","Loyce","Kufa","loycekufa@gmail.com","34 coronation avenue greendale"),
			new User("3","Nozipho","Ndlovu","nozzy@gmail.com","181 elizabeth windsor marlborough"),
			new User("4","Patrick","Ndlovu","robertndlovu@gmail.com","Chitungwiza")
			));
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
	return users;
		
	}
	
	public Optional<User> getUser(String id) {
		//return  users.stream().filter(u -> u.getId().equals(id)).findFirst().get();
		
		return userRepository.findById(id);
	  }
	
	public void addUser(User user) {
		userRepository.save(user);
		//users.add(user);
		
	}
	
	public void updateUser(String id, User user) {
		//loop through all the users and get the one with specific id then update
		/*
		for(int i=0; i<users.size(); i++) {
			User u = users.get(i);
			if(u.getId().equals(id)) {
				users.set(i,user);
				return;
			} 
		}
		
		*/
		userRepository.save(user);
		
	}
	
	public void deleteUser(String id) {
		//users.removeIf(u -> u.getId().equals(id)); // without crud
		
		userRepository.deleteById(id);
	}
}
