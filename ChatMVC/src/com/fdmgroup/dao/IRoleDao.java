package com.fdmgroup.dao;

import com.fdmgroup.model.Role;

public interface IRoleDao extends IStorage<Role> {
	
	Role findByRoleType(String roleType);

}
