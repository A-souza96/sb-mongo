package com.sb.mongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.mongo.domain.Post;
import com.sb.mongo.repositories.PostRepository;
import com.sb.mongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private	PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Obj nao encontrado"));
	}
	
}
