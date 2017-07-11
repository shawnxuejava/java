package com.fdmgroup.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Chat;
import com.fdmgroup.model.User;

public class ChatJpaDao implements IChatDao {

	@Resource(name = "dbConnection")
	private DbConnection conn;
	
	@Override
	public Chat findById(int id) {
		EntityManager em = conn.getEntityManager();

		TypedQuery<Chat> query = em.createNamedQuery("chat.findById", Chat.class);
		query.setParameter("cid", id);

		List<Chat> chats = query.getResultList();
		if (chats.size() == 1) {
			return chats.get(0);
		} else
			return null;
	}

	@Override
	public Chat create(Chat chat) {
		

		EntityManager em = conn.getEntityManager();

		if (!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.persist(chat);
		em.getTransaction().commit();

		return chat;
	}

	@Override
	public Chat update(Chat t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Chat t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Chat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
