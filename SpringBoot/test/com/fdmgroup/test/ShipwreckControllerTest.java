package com.fdmgroup.test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.controller.ShipwreckController;
import com.fdmgroup.model.Shipwreck;
import com.fdmgroup.repository.ShipwreckRepo;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepo shipwreckRepo;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet(){
		Shipwreck sw = new Shipwreck();
		sw.setId(1l);

		//mockito stubbing
		when(shipwreckRepo.findOne(1l)).thenReturn(sw);
		

		Shipwreck wreck =  sc.get(1L);
		
		verify(shipwreckRepo).findOne(1l);
		//assertEquals(1L,wreck.getId().longValue());
		
		//hamcrest test!
		assertThat(wreck.getId(),is(1l));
	}

}
