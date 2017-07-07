package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Role;

public interface IRoleDao extends IStorage<Role>{
	List<Role> findByRoleType(String roleType);
}
