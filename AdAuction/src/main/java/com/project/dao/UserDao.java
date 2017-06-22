package com.project.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.model.State;
import com.project.model.User;
import com.project.model.UserProfileType;

public class UserDao {
	@Autowired
	private SessionFactory sf;
	
	protected Session getSession(){
		return sf.getCurrentSession();
	}
	public User getByEmail(String email){
		return (User)getSession().get(User.class, email);
	}
	public void regUser(User u){
		u.setState(State.INACTIVE.getState());
		
		getSession().save(u);
		System.out.println("saved");
	}
	public void activateUser(String email){
		User u=this.getByEmail(email);
		u.setState(State.ACTIVE.getState());
		getSession().update(u);
	}
	public void deleteUser(User u){
		getSession().delete(u);
	}
	public void updateEmail(String oemail,String nemail){
		User u =(User)getSession().get(User.class, oemail);
		u.setEmail(nemail);
		getSession().update(u);
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		List<User> luser=new ArrayList<User>();
		Criteria cr=getSession().createCriteria(User.class);
		luser=cr.list();
		
		return luser;
	}
	public void deleteAllUsers(){
		List<User> luser=new ArrayList<User>();
		luser=this.getAllUsers();
		Iterator<User> it=luser.iterator();
		while(it.hasNext()){
			this.deleteUser(it.next());
		}
		System.out.println("All Users Deleted !");
	}
}
