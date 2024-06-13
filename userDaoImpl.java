package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.User;

@Component
public class userDaoImpl {
	@Autowired
	userRepository UserRepository;

	public userDaoImpl() {
	}
  
	public void addUser(User user ) {
		System.out.println(UserRepository.save(user));
	}
	
	 @Override
	    public Optional<User> getById(int id) {
	        return userList.stream()
	                .filter(user -> user.getId() == id)
	                .findFirst();
	    }

	    @Override
	    public List<User> getAll() {
	        return new ArrayList<>(userList);
	    }

	    @Override
	    public void update(User user) {
	        Optional<User> existingUser = getById(user.getId());
	        existingUser.ifPresent(u -> {
	            u.setName(user.getName());
	        });
	    }

	    @Override
	    public void delete(int id) {
	        userList.removeIf(user -> user.getId() == id);
	    }
	}

}

