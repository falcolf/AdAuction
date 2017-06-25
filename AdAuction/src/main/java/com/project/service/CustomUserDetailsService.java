package com.project.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.NewUser;
import com.project.model.State;
import com.project.model.User;
import com.project.model.UserProfile;
import com.project.model.UserProfileType;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		User user = userService.getUserDetails(email);
		if(user==null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
				 user.getState().equals("ACTIVE"), true, true, true, getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		/*for(UserProfile userProfile : user.getUpros()){
			System.out.println("UserProfile : "+userProfile);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
		}
		*/
		
		if(user.getTypeid()==1)
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		else
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		System.out.print("authorities :"+authorities);
		return authorities;
	}
	
}
