package com.fdmgroup.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Room;

public class RoomJpaDao implements IRoomDao{

	@Resource(name = "dbConnection")
	private DbConnection conn;
	
	
	@Override
	public Room findById(int id) {
		EntityManager em = conn.getEntityManager();

		TypedQuery<Room> query = em.createNamedQuery("room.findById", Room.class);
		query.setParameter("rid", id);

		List<Room> rooms = query.getResultList();
		if (rooms.size() == 1) {
			return rooms.get(0);
		} else
			return null;
	}

	@Override
	public Room create(Room room) {
		
		EntityManager em = conn.getEntityManager();
		
		if (!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.persist(room);
		em.getTransaction().commit();
		
		return room;
	}

	@Override
	public Room update(Room t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Room t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
