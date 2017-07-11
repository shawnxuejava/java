package com.fdmgroup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.dao.IRoleDao;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.model.RoleType;
import com.fdmgroup.model.User;

@Controller
@SessionAttributes(value={"user"}, types={User.class})
public class AuthenticationController {
	
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IRoleDao roleDao;
	
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String showLogin(Model model){
		model.addAttribute("user", new User());
		
		return "login";
	}
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public String logout(Model model){
		
		model.addAttribute("user", new User());
		
		return "login";
	}
	
	
	@RequestMapping(value="/processLogin", method= RequestMethod.POST)
	public String doLogin(@Valid User user, BindingResult br, Model model){
		
		if(br.hasErrors()){
			return"login";
		}
		
		
		User foundUser = userDao.findByUsername(user.getUsername());
		
		System.out.println(user.getUsername());
		System.out.println(foundUser);
		if(foundUser!=null && foundUser.getPassword().equals(user.getPassword())){
			if(foundUser.getRole().getRoleType()==RoleType.USER){
				model.addAttribute("user", foundUser);
				return "user";
			}
			else if (foundUser.getRole().getRoleType()==RoleType.ADMIN){
				model.addAttribute("user", foundUser);
				return "admin";
			}
			else{
				model.addAttribute("errorMsg", "Wrong Role");
				return "login";
			}
				
		}else{
			model.addAttribute("errorMsg", "Username/Password is Wrong");
			return "login";
		}
	}

}
