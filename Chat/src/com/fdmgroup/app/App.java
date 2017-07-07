package com.fdmgroup.app;


import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	
//	@Resource(name = "dbConnection")
//	DbConnection dbConnection;
	
	//@Resource(name = "userDao")
	//private IUserDao userDao;
	
	
	public static void main(String[] args) {
		
//		SpringApplication.run(App.class, args);
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/applicationContext.xml");
		
		App app = context.getBean(App.class);
	
		app.start();
		
		System.out.println("done");

		((ClassPathXmlApplicationContext) context).close();
		

	}
	
	
	private void start(){
		 
	}

}
