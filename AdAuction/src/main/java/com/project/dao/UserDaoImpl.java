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
import org.springframework.stereotype.Repository;

import com.project.model.State;
import com.project.model.User;
import com.project.model.UserProfileType;
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

	@Override
	public User findById(int id) {
		return getByKey(id);
	}

	@Override
	public User findByEmail(String email) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("email", email));
		return (User) crit.uniqueResult();
	}

	@Override
	public void regUser(User user) {
		getSession().save(user);
	}

	@Override
	public void setActiveUser(String email) {
		User u=this.findByEmail(email);
		u.setState(State.ACTIVE.getState());
		getSession().update(u);
		
	}

	@Override
	public void deleteUser(String email) {
		User u=this.findByEmail(email);
		this.delete(u);
		
	}

	@Override
	public void updateUser(User user) {
		getSession().update(user);
	}

	@Override
	public User findByAdhaar(String adhaarno) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("adhaarno", adhaarno));
		return (User) crit.uniqueResult();
	}

	
	
}
