package com.thadb.springmvctest.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thadb.springmvctest.dao.User;


@Service
public class UserService {

	public UserService(){
	}
	
	@Autowired
	ChampionService champService;
	
	public User getNewUser(){		
		User user = new User();
		return user;
	}
	
}
