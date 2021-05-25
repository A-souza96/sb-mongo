package com.sb.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.mongo.domain.User;
import com.sb.mongo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private	UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
