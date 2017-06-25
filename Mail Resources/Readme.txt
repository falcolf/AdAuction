Function to generate OTP:
	
	public String OTPproducer(){
        int otp = (int)(Math.random()*9000)+1000;
        return String.valueOf(otp);
    }



Mailing Procedure:

		ProduceMail pm=new ProduceMail(); //Class containing all the methods
		String otp=this.OTPproducer();
		pm.OTPmail(u.getName(), u.getEmail(),otp ,otpurl+u.getId()); //function to send mail
		//u.getName()->Name of the user
		//u.getEmail()->Email id of the user
		//otp->The otp generated
		//otpurl+u.getId()->generates link for the otp confirmation url using id;
		


		final String otpurl="192.168.1.6:8087/AdAuction/activationid="
		//on local host and my server,change accordingly



Methods Implementtion

public class ProduceMail {
    
    public void OTPmail(String user , String email,String otp,String url){
        
        String message="<p>Greetings "+user+"<br>Here is the four digit OTP for the access of your account<br>"+otp+"<br>Please go to the following URL and enter the OTP for enabling your account for auction purpose.<br>"+url;
        Mailer.send(email, "OTP from AdAuction", message);//Mailer Class , unjar to read.
    }
    public void congratsMail(String user,String email,String url,String desc,String amount){
        String message="<p>Congratulations "+user+"<br> Your bid of amount "+amount+" for "+desc+" has been unbeaten and therefore it's sold to you.<br>Please pay the amount using any of the given facilities within next 6 hours. YOu can visit here for further information and payments<br>"+url;
        Mailer.send(email, "Congratulation from AdAuction", message);
    }
    
}


