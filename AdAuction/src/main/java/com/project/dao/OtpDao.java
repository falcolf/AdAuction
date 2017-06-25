package com.project.dao;

import com.project.dto.Otpact;
import com.project.model.Otp;

public interface OtpDao {
	boolean activateUser(Otpact eo);
	void saveOtp(Otp otp);
}
