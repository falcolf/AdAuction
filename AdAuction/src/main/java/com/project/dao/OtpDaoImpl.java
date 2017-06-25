package com.project.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.project.dto.Otpact;
import com.project.model.Otp;

@Repository("otpDao")
public class OtpDaoImpl extends AbstractDao<Integer, Otp> implements OtpDao{

	@Override
	public boolean activateUser(Otpact eo) {
		
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("email", eo.getEmail()));
		Otp o=(Otp)crit.uniqueResult();
		if(o.getOtp().equals(eo.getOtp())){
			getSession().delete(o);
			return true;
		}
		else 
			return false;
		
	}

	@Override
	public void saveOtp(Otp otp) {
		getSession().saveOrUpdate(otp);
		
	}

}
