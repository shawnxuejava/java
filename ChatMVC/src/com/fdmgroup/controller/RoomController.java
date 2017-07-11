package com.fdmgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.dao.IRoomDao;
import com.fdmgroup.model.Room;

@Controller
public class RoomController {
	
	@Autowired
	IRoomDao roomDao;
	
	@RequestMapping(value="/room/{id}", method= RequestMethod.GET)
	public String joinRoom(@PathVariable int id, Model model){
		
		
		Room foundRoom = roomDao.findById(id);
		model.addAttribute("room",foundRoom );
		
		
		return "room";
	}

}
