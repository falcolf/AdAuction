package com.project.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dto.NewUser;
import com.project.dto.Otpact;
import com.project.model.Otp;
import com.project.model.State;
import com.project.model.User;
import com.project.service.UserService;

import sendmail.ProduceMail;



@Controller
public class AdAuctionController {
	
	final String otpurl="192.168.1.6:8087/AdAuction/activationid=";
	
	
	@Resource(name = "userService")
	private UserService userService;
     
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("registration","" );
		model.addAttribute("greeting", "Hi, Welcome to mysite");
		return "welcome";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String formPage(ModelMap model) {
		NewUser nu=new NewUser();
		model.addAttribute("user",nu);
		return "regform";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerUser(@Valid NewUser user , BindingResult result , ModelMap model){
		if(result.hasErrors()){
			return "regform";
		}
		this.addUser(user);
		model.addAttribute("registration","User via email address "+user.getEmail()+" registered successfully" );
		return "welcome"; //change appropriately
	}
	
	@RequestMapping(value = "/activationid={id}", method = RequestMethod.GET)
	public String otpPage(ModelMap model,@PathVariable int id) {
		Otpact usero=new Otpact();
		model.addAttribute("usero",usero);
		model.addAttribute("id",id);
		User u=userService.getUserDetails(id);
		model.addAttribute("email",u.getEmail());
		return "otp";
	}
	@RequestMapping(value="/activate",method=RequestMethod.POST)
	public String activatePage(@Valid Otpact usero , BindingResult result , ModelMap model){
		System.out.println(usero.getEmail()+usero.getOtp()+usero.getId());
		if(result.hasErrors()){
			model.addAttribute("message","Error" );
		}
		if(this.activateUser(usero)){
			model.addAttribute("message","activated" );
		}else
			model.addAttribute("message","Otp Failure" );
		
		return "temp"; //change appropriately
	}
	
	
	/*
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginUser(@Valid NewUser user , BindingResult result , ModelMap model,HttpSession ss){
		if(result.hasErrors()){
			return "form";
		}
		System.out.println(user);
		
		return "welcome"; //change appropriately
	}*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "loginform";
}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "user";
	}
	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	public void addUser(NewUser nuser){
		User u=new User();
		u.setName(nuser.getName());
		u.setEmail(nuser.getEmail());
		u.setPassword(nuser.getPassword());
		u.setAdhaarno(nuser.getAdhaarno());
		u.setState(State.INACTIVE.getState());
		u.setTypeid(2);
		System.out.println(u);
		userService.registerUser(u);
		ProduceMail pm=new ProduceMail();
		String otp=this.OTPproducer();
		pm.OTPmail(u.getName(), u.getEmail(),otp ,otpurl+u.getEmail());
		this.assignOtp(u.getEmail(),otp);
	}
	public void assignOtp(String email, String otp){
		Otp o=new Otp();
		User temp=userService.getUserDetails(email);
		o.setId(temp.getId());
		o.setEmail(email);
		o.setOtp(otp);
		userService.saveOtp(o);
	}
	public boolean activateUser(Otpact usero){
		
		if(userService.activateUser(usero)){
			userService.setActiveUser(usero.getEmail());
			return true	;
		}
		return false;
			
			
	}
	public String OTPproducer(){
        int otp = (int)(Math.random()*9000)+1000;
        return String.valueOf(otp);
    }
	
 
 
}



