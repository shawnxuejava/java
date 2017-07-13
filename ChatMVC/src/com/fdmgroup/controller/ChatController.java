package com.fdmgroup.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdmgroup.dao.IChatDao;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.model.Chat;
import com.fdmgroup.model.Message;
import com.fdmgroup.model.User;

@Controller
//@EnableWebSocketMessageBroker
public class ChatController {
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	IChatDao chatDao;
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	
	@Autowired
	public ChatController(SimpMessagingTemplate simp) {
		this.simpMessagingTemplate=simp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@MessageMapping("/chat/{id}")
	@SendTo("/topic/showMessage/{id}") 
	public Message doChat(@DestinationVariable int id, @RequestBody Map<String, String> msg) throws InterruptedException {
		
		Calendar cal = new GregorianCalendar();
        cal.setTime(Calendar.getInstance().getTime());
		
	/*	Calendar cal = new GregorianCalendar();
        cal.setTime(Calendar.getInstance().getTime());
        
        User foundUser = userDao.findById(Integer.parseInt(msg.get("usr")));
        System.out.println(foundUser);
//		Chat foundChat = chatDao.findById(id);
         
        
        Message m = new Message();
        m.setContent("test");
        m.setAuthor(foundUser);
        
		
		return m;
		*/
		
		
		
		/*System.out.println(msg);
		
		System.out.println("in chat");
		
		System.out.println( msg.get("usr"));
		System.out.println(msg.get("message"));
		System.out.println(id);*/
		
		User foundUser = userDao.findById(Integer.parseInt(msg.get("usr")));
		Chat foundChat = chatDao.findById(id);
		
		
		Message m = new Message();
		m.setAuthor(foundUser);
		m.setContent(msg.get("message"));
		m.setChat(foundChat);
		m.setTimeStamp(cal);
		
		//this.simpMessagingTemplate.convertAndSend("/topic/showMessage/" +id, m);
		
		return m;
		
		
	}
	
	
	

}
