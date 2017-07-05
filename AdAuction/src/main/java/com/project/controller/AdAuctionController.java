package com.project.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.project.dto.AucData;
import com.project.dto.NewUser;
import com.project.dto.Otpact;
import com.project.model.Auction;
import com.project.model.Otp;
import com.project.model.State;
import com.project.model.User;
import com.project.service.AuctionService;
import com.project.service.UserService;
import sendmail.ProduceMail;

@Controller
public class AdAuctionController {
	
	final String otpurl="192.168.1.6:8085/AdAuction/activationid=";
	User accessor;
	int uid=0;
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name="auctionService")
	private AuctionService auctionService;
     
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "welcome";
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		accessor=userService.getUserDetails(this.getAccesser());
		model.addAttribute("user", accessor.getName());
		return "accessDenied";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String formPage(ModelMap model) {
		NewUser nu=new NewUser();
		model.addAttribute("user",nu);
		return "regform";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") NewUser user , BindingResult result , ModelMap model){
		if(result.hasErrors()){
			return "regform";
		}
		if(userService.checkEmailDup(user.getEmail())){
			model.addAttribute("message","User already Registered");
		}else{
			if(userService.checkAdhaarDup(user.getAdhaarno())){
				model.addAttribute("message", "Adhaar Number already registered with another email address");
			}
			else{
				try{
					this.addUser(user);
					model.addAttribute("message","Registered\nOTP link: "+otpurl+uid);
					return "loginform";
					
				}catch(Exception e){
					model.addAttribute("message", e);
				}
			}
		}
		return "regform";
		
	}
	
	@RequestMapping(value = "/activationid={id}", method = RequestMethod.GET)
	public String otpPage(ModelMap model,@PathVariable int id) {
		try{
			Otpact usero=new Otpact();
			model.addAttribute("usero",usero);
			model.addAttribute("id",id);
			User u=userService.getUserDetails(id);
			model.addAttribute("email",u.getEmail());
			if(u.getState().equals(State.ACTIVE.getState())){
				model.addAttribute("message",u.getName()+" , you already have your account , "+u.getEmail()+" activated.");
				return "loginform";
			}
			return "otp";
		}catch(Exception e){
			model.addAttribute("message","No User With id "+id+" exists");
			return "loginform";
		}
		
		
	}
	
	@RequestMapping(value="/activate",method=RequestMethod.POST)
	public String activatePage(@Valid @ModelAttribute("usero") Otpact usero , BindingResult result , ModelMap model){
		if(result.hasErrors()){
			model.addAttribute("message","Error has occured while activation\nPlease contact us on complaints.adauction@gmail.com" );
			return "loginform";
		}
		try{
			if(this.activateUser(usero)){
				model.addAttribute("message","Your Account with Email Id : "+usero.getEmail()+" has been activated successfully!" );
				return "loginform";
			}else{
				model.addAttribute("message","Invalid OTP" );
				return "loginform";
			}
		}catch(Exception e){
			model.addAttribute("message",e);
			return "otp";
		}
		 //change appropriately
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "loginform";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		
		try{
			accessor=userService.getUserDetails(this.getAccesser());
			model.addAttribute("user",accessor.getName());
		}catch(Exception e){
			model.addAttribute("message","There was some error completing request : "+e);
			return "admin";
		}
		
		return "admin";
	}
	
	@RequestMapping(value="/admin/new",method=RequestMethod.GET)
	public String newAuction(ModelMap model){
		AucData data=new AucData();
		model.addAttribute("data",data);
		return "newweb";
	}
	
	@ModelAttribute("adtypes") //To Enter Values to Tech Filed Box
	public List<String> initTech(){
		List<String> adtypes=new ArrayList<String>();
		adtypes.add("popups");adtypes.add("banners");
		return adtypes;
	}
	
	@RequestMapping(value="/admin/add",method=RequestMethod.POST)
	public String savAucData(@Valid @ModelAttribute("data")AucData data , BindingResult result , ModelMap model){
		if(result.hasErrors()){
			model.addAttribute("message","Error" );
			return "newweb";
		}
		try{
			addData(data);
			model.addAttribute("message","Entery Done" );
		}catch(Exception e){
			model.addAttribute("message",e);
		}
		return "adminDispatcher"; //change appropriately
	}	
	
	@RequestMapping(value="/admin/addAdmin",method=RequestMethod.GET)
	public String addAdmin(ModelMap model){
		User u=new User();
		model.addAttribute("user",u);
		return "addAdmin";
	}
	@RequestMapping(value="/admin/assignAdmin",method=RequestMethod.POST)
	public String assignAdmin(@Valid @ModelAttribute("user")User user , BindingResult result , ModelMap model){
		if(result.hasErrors()){
			model.addAttribute("mess","Error" );
			return "addAdmin";
		}
		try{
			user=userService.getUserDetails(user.getEmail());
			user.setTypeid(1);
			userService.updateUser(user);
			model.addAttribute("message","User "+user.getName()+" Email : "+user.getEmail()+" assigned as Admin" );
		
		}catch(Exception e){
			model.addAttribute("message",e);
			
		}
			return "adminDispatcher"; //change appropriately
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage(ModelMap model) {
		
		try{
			accessor=userService.getUserDetails(this.getAccesser());
			List<Auction> aucs=new ArrayList<Auction>();
			aucs=auctionService.getAllAuc();
			model.addAttribute("aucs",aucs);
			model.addAttribute("user", accessor.getName());
		}catch(Exception e){
			model.addAttribute("message","There was some error completing request : "+e);
			return "user";
		}
		
		return "user";
	}
	
	
	@RequestMapping(value = "/user/bid={id}", method = RequestMethod.GET)
	public String bidPage(ModelMap model,@PathVariable int id) {
		try{
			Auction auction=auctionService.getDetails(id);
			model.addAttribute("auction",auction);
		}catch(Exception e){
			model.addAttribute("message","Auction has already Ended...");
			return "userDispatcher";
		}
		
		
		return "bid";
	}
	
	@RequestMapping(value="/user/confBid",method=RequestMethod.POST)
	public String confBidPage( @Valid @ModelAttribute("auction")Auction auction , BindingResult result , ModelMap model){
		if(result.hasErrors()){
			model.addAttribute("message","Error" );
		}
		Auction prev=auctionService.getDetails(auction.getId());
		if(prev.getCurrbid()>=auction.getCurrbid()){
			model.addAttribute("message","Amount should be greater than previous bid");
		}else{
		try{
		prev.setCurrbid(auction.getCurrbid());
		prev.setHighbidder(getAccesser());
		auctionService.updateBid(prev);
		model.addAttribute("message","Bid Successfull");
		}catch(Exception e){
			model.addAttribute("message",e);
			}
		}
		try{
			accessor=userService.getUserDetails(this.getAccesser());
			List<Auction> aucs=new ArrayList<Auction>();
			aucs=auctionService.getAllAuc();
			model.addAttribute("aucs",aucs);
			model.addAttribute("user", accessor.getName());
		}catch(Exception e){
			
			model.addAttribute("message","There was some error completing request : "+e);
			
		}
		
		return "userDispatcher";
	}
	
	@RequestMapping(value = "/user/payments", method = RequestMethod.GET)
	public String paymentsPage(ModelMap model) {
		return "payments";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	

	private String getAccesser(){
		String email = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			email = ((UserDetails)principal).getUsername();
		} else {
			email = principal.toString();
		}
		return email;
	}
	
	//To add a new USER
	public void addUser(NewUser nuser){
		User u=new User();
		u.setName(nuser.getName());
		u.setEmail(nuser.getEmail());
		u.setPassword(nuser.getPassword());
		u.setAdhaarno(nuser.getAdhaarno());
		u.setState(State.INACTIVE.getState());
		u.setTypeid(2);
		userService.registerUser(u);
		ProduceMail pm=new ProduceMail();
		String otp=this.OTPproducer();
		pm.OTPmail(u.getName(), u.getEmail(),otp ,otpurl+u.getId());
		this.uid=u.getId();
		this.assignOtp(u.getEmail(),otp);
	}
	//Function to assign OTP to a user
	public void assignOtp(String email, String otp){
		Otp o=new Otp();
		User temp=userService.getUserDetails(email);
		o.setId(temp.getId());
		o.setEmail(email);
		o.setOtp(otp);
		userService.saveOtp(o);
	}
	//Function to produce OTP
		public String OTPproducer(){
	        int otp = (int)(Math.random()*9000)+1000;
	        return String.valueOf(otp);
	    }
	//Function to activate the user
	public boolean activateUser(Otpact usero){
		if(userService.activateUser(usero)){
			userService.setActiveUser(usero.getEmail());
			return true	;
		}
		return false;
	}
	//To Register a new Auction Website
	public void addData(AucData data){
		Calendar start=this.getDate(data.getStarttime());
		Calendar end=this.getDate(data.getEndtime());
		Auction adata=new Auction();
		adata.setName(data.getName());
		adata.setUrl(data.getUrl());
		adata.setType(data.getType());
		adata.setCurrbid(Double.parseDouble(data.getCurrbid()));
		adata.setHighbidder("admin.adauction@gmail.com");
		Calendar cal=Calendar.getInstance();
		Date date = start.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        adata.setStarttime(start.getTime());
		adata.setEndtime(end.getTime());
		auctionService.scheduleAuction(adata);
	}
	//Function to convert form date to object : to be simplified
	Calendar getDate(String x){
	String[] a=x.split("T");
	String[] b=a[0].split("-");
	String[] c=a[1].split(":");
	Calendar cc=Calendar.getInstance();
	cc.set(Integer.parseInt(b[0]),Integer.parseInt(b[1])-1, Integer.parseInt(b[2]),Integer.parseInt(c[0]), Integer.parseInt(c[1]),0);
	return cc;
}
	
 
 
}



