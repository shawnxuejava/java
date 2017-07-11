package com.fdmgroup.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Role;

public class RoleJpaDao implements IRoleDao {
	
	@Resource(name = "dbConnection")
	private DbConnection conn;

	@Override
	public Role findById(int id) {
		EntityManager em = conn.getEntityManager();

		TypedQuery<Role> query = em.createNamedQuery("role.findById", Role.class);
		query.setParameter("rid", id);

		List<Role> roles = query.getResultList();
		if (roles.size() == 1) {
			return roles.get(0);
		} else
			return null;

	}

	@Override
	public Role create(Role r) {
		
		EntityManager em = conn.getEntityManager();

		//user.setPassword(pe.encrypt(user.getPassword()));
		
		// if(findByUsername(user.getUsername())!=null){
		// return null;
		// }
		
		if (!em.getTransaction().isActive())
			em.getTransaction().begin();
		
		em.persist(r);
		
		em.getTransaction().commit();

		return r;
		
	
	}

	@Override
	public Role update(Role t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Role t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Role> findAll() {
		
		EntityManager em = conn.getEntityManager();

		TypedQuery<Role> query = em.createNamedQuery("role.findAll", Role.class);
		List<Role> roles = query.getResultList();

		return roles;

	}

	@Override
	public Role findByRoleType(String roleType) {
		
		
		return null;
	}

}
