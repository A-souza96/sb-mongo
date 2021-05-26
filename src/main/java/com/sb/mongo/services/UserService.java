package com.sb.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.mongo.domain.User;
import com.sb.mongo.dto.UserDTO;
import com.sb.mongo.repositories.UserRepository;
import com.sb.mongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private	UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Obj nao encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
		
	}
	
	private User updateData(User newObj, User obj) {
		return new User(newObj.getId(),newObj.getName(),newObj.getEmail());
		
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
	}
	
	
	
	
}
