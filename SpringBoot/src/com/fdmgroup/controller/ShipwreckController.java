package com.fdmgroup.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.model.Shipwreck;
import com.fdmgroup.repository.ShipwreckRepo;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {
	
	@Autowired
	private ShipwreckRepo shipwreckRepo;

	@RequestMapping(value="shipwrecks",method=RequestMethod.GET)
	public List<Shipwreck> list(){
		
		//return ShipwreckStub.list();
		return shipwreckRepo.findAll();
	}
	
	@RequestMapping(value="shipwrecks",method=RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		//return ShipwreckStub.create(shipwreck);
		return shipwreckRepo.saveAndFlush(shipwreck);
	}

	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.GET)
	public  Shipwreck get(@PathVariable Long id) {
		//return ShipwreckStub.get(id);
		return shipwreckRepo.findOne(id);
	}

	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.PUT)
	public  Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		//return ShipwreckStub.update(id, shipwreck);
		
		Shipwreck foundShipwreck=shipwreckRepo.findOne(id);
		BeanUtils.copyProperties(shipwreck, foundShipwreck);
		return shipwreckRepo.saveAndFlush(foundShipwreck);
	
		
	}

	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.DELETE)
	public  Shipwreck delete(@PathVariable Long id) {
		//return ShipwreckStub.delete(id);
		Shipwreck foundShipwreck = shipwreckRepo.findOne(id);
		shipwreckRepo.delete(foundShipwreck);
		return foundShipwreck;
	}
	
	
}
