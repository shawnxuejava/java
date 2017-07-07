package com.fdmgroup.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Role;
import com.fdmgroup.model.User;

public class UserJpaDao implements IUserDao {

	@Resource(name = "dbConnection")
	private DbConnection conn;

//	@Resource(name = "passwordEncryption")
//	private PasswordEncryption pe;
	
	@Override
	public User findById(int id) {
		
		EntityManager em = conn.getEntityManager();

		TypedQuery<User> query = em.createNamedQuery("user.findById", User.class);
		query.setParameter("uid", id);

		List<User> users = query.getResultList();
		if (users.size() == 1) {
			return users.get(0);
		} else
			return null;
	}

	@Override
	public User create(User user) {

		EntityManager em = conn.getEntityManager();

		//user.setPassword(pe.encrypt(user.getPassword()));
		
		// if(findByUsername(user.getUsername())!=null){
		// return null;
		// }
		if (!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		return user;
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

}
