package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.IStorable;

public interface IStorage<T extends IStorable> {
	public T findById(int id);
	public T create(T t);
	public T update(T t);
	public boolean delete(T t); 
	public List<T> findAll();

}

