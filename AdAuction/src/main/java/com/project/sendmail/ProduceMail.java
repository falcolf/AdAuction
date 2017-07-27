package com.project.sendmail;
public class ProduceMail {
    
    public void OTPmail(String user , String email,String otp,String url){
        
        String message="<p>Greetings "+user+"<br>Here is the four digit OTP for the access of your account<br>"+otp+"<br>Please go to the following URL and enter the OTP for enabling your account for auction purpose.<br>"+url;
        Mailer.send(email, "OTP from AdAuction", message);
    }
    public void congratsMail(String user,String email,String url,String desc,String amount){
        String message="<p>Congratulations "+user+"<br> Your bid of amount "+amount+" for "+desc+" has been unbeaten and therefore it's sold to you.<br>Please pay the amount using any of the given facilities within next 6 hours. YOu can visit here for further information and payments<br>"+url;
        Mailer.send(email, "Congratulation from AdAuction", message);
    }
    
}
