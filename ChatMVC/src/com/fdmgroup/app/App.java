package com.fdmgroup.app;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.DbConnection;
import com.fdmgroup.dao.IChatDao;
import com.fdmgroup.dao.IRoleDao;
import com.fdmgroup.dao.IRoomDao;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.model.Chat;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.RoleType;
import com.fdmgroup.model.Room;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserStatus;

public class App {


	@Resource(name = "dbConnection")
	DbConnection dbConnection;
	
	@Resource(name = "userDao")
	private IUserDao userDao;

	@Resource(name = "roleDao")
	private IRoleDao roleDao;
	
	@Resource(name = "roomDao")
	private IRoomDao roomDao;
	@Resource(name = "chatDao")
	private IChatDao chatDao;

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/applicationContext.xml");

		App app = context.getBean(App.class);

		app.start();
		
		System.out.println("table done");
		
		((ClassPathXmlApplicationContext) context).close();
		
	}


	private void start() {
		
		Calendar cal = new GregorianCalendar();
        cal.setTime(Calendar.getInstance().getTime());
		

		Role user = new Role(RoleType.USER);
		Role admin = new Role(RoleType.ADMIN);
		
		Role createdUser = roleDao.create(user);
		Role createdAdmin = roleDao.create(admin);
		
		System.out.println(createdUser);
		System.out.println(createdAdmin);
		

		
		
		User u1=new User("jdoe", "John", "Doe", "xx@xx.com","default.png",UserStatus.ACTIVE,cal,createdUser);
		User u2=new User("mjane", "Marry", "Jane", "xx@xx.com","default.png",UserStatus.ACTIVE,cal,createdUser);
		User u3=new User("asmith", "Alex", "Smith", "xx@xx.com","default.png",UserStatus.ACTIVE,cal,createdUser);
		User u4=new User("sxue", "Shawn", "Xue", "xx@xx.com","default.png",UserStatus.ACTIVE,cal,createdAdmin);
		u1.setPassword("1234");
		u2.setPassword("1234");
		u3.setPassword("1234");
		u4.setPassword("1234");
		
		userDao.create(u1);
		userDao.create(u2);
		userDao.create(u3);
		userDao.create(u4);
		
		Chat c1= new Chat("chat1");
		Chat c2= new Chat("chat2");
		
		Chat createdC1 = chatDao.create(c1);
		Chat createdC2 = chatDao.create(c2);
		
		Room r1 = new Room("Room1",cal,"public");
		Room r2 = new Room("Room2",cal,"public");
		r1.setOwner(u1);
		r2.setOwner(u2);
		
		r1.setChat(createdC1);
		r2.setChat(createdC2);
		
		List<User> usersInvited =  new ArrayList<User>();
		usersInvited.add(u1);
		usersInvited.add(u2);
		usersInvited.add(u3);
		
		r1.setUsersInvited(usersInvited);
		
		roomDao.create(r1);

		List<User> usersInvited2 =  new ArrayList<User>();
		usersInvited2.clear();
		usersInvited2.add(u1);
		usersInvited2.add(u2);
		
		r2.setUsersInvited(usersInvited2);
		
		roomDao.create(r2);
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		dbConnection.close();
	}
	
	
}
