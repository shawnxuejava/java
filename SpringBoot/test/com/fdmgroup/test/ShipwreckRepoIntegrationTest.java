package com.fdmgroup.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fdmgroup.app.App;
import com.fdmgroup.model.Shipwreck;
import com.fdmgroup.repository.ShipwreckRepo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class ShipwreckRepoIntegrationTest {

	@Autowired
	private ShipwreckRepo shipwreckRepo;
	
	@Test
	public void testFindAll(){
		List<Shipwreck> wrecks= shipwreckRepo.findAll();
		assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
	}
	
	
}
