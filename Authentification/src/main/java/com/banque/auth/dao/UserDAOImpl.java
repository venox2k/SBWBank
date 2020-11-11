package com.banque.auth.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.banque.auth.entities.User;
import com.banque.auth.exception.BadRequestException;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	MongoTemplate mongoTemplate;
	
	private static final String COLLECTION_NAME="users";

	public User login(String email, String password) throws BadRequestException {
		try {
			Query query=new Query(Criteria.where("email").is(email));
			User user=mongoTemplate.findOne(query, User.class,COLLECTION_NAME);
			if(user !=null) {
				BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
				if(bCryptPasswordEncoder.matches(password, user.getPassword()))
					return user;
			}
			return null;
			
		} catch (Exception e) {
			throw new BadRequestException("internal server");
		}
	}

	public void createProfile(User user) {
		try {
			mongoTemplate.insert(user,COLLECTION_NAME);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<User> getUsers() {
		List<User> users=mongoTemplate.findAll(User.class,COLLECTION_NAME);
		return users;
	}

}
