package com.project.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class NewUser {
	
	
	
	@NotEmpty
		private String name;
		
	@NotEmpty @Email
		private String email;
		
	@NotEmpty
		private String password;
		
	@NotEmpty
		private String adhaarno;
		
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getAdhaarno() {
			return adhaarno;
		}

		public void setAdhaarno(String adhaarno) {
			this.adhaarno = adhaarno;
		}


		@Override
		public String toString() {
			return "User [ email=" + email + ", password=" + password
					+ ", Name=" + name +  ", Adhaar Number=" + adhaarno +"]";
		}
		


	

}
