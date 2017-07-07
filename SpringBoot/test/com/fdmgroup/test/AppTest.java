package com.fdmgroup.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.fdmgroup.controller.HomeController;

public class AppTest {
	
	@Test
	public void testApp(){
		//assertTrue(true);
		
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals(result, "das boot, reporting for duty!"); 
		
	}

}
