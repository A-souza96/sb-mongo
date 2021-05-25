package com.sb.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sb.mongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
