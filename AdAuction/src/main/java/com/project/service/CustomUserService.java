package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customUserDetailsService")
public class CustomUserService implements UserDetailsService{
 
    /*@Autowired
    private UserService userService;
     
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String ssoId)
            throws UsernameNotFoundException {
        User user = userService.findBySso(ssoId);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(), 
                 user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
    */}