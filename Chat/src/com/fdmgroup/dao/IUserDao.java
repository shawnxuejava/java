package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Role;
import com.fdmgroup.model.User;

public interface IUserDao extends IStorage<User>{
	
	List<User> findByFirstname(String firstname);
	List<User> findByLastname(String lastname);
	List<User> findByRole(Role role);
	
}
