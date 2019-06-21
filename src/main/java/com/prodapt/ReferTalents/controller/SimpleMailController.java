package com.prodapt.ReferTalents.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class SimpleMailController {
    @Autowired
    private JavaMailSender sender;

    @GetMapping("/sendMailMethod")
    public String sendMail(@RequestParam String rjEmployeeMail,@RequestParam String rjStatus,@RequestParam String rjEmployeeName,@RequestParam String rtPositionCode,
              @RequestParam String rjName,@RequestParam String jdPositionTitle,@RequestParam String rjCommend)  throws MessagingException{
       
//    SimpleMailMessage message =new SimpleMailMessage();
       MimeMessage message = sender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message);
      helper.setTo(rjEmployeeMail);
      helper.setSubject("text");
      helper.setFrom("prithiviraj.r@prodapt.com");
       
      
      if (rjStatus.equals("Screened")) {
                     helper.setSubject("Job Status Change: Screened ");
                     helper.setText("<b>"+"Dear"+" "+rjEmployeeName+","+"</b>"+"<br>"+"<br>"+"We regret to inform your referral"+" "+"<b>"+rjName +" is "+"Screened"+" for "+"'"+jdPositionTitle+"'"+"Position"+","+"Jobcode:"+rtPositionCode+"."+"</b>"+"<br>"+
                     "We really appreciate your effort in referring candidates to Prodapt, looking forward to receive further referrals from you"+"<br>"+"<br>"+"<b>"+"Thank you<br>" + 
                     "Recruitment Team"+"</b>",true);  
                     
              }
      else if (rjStatus.equals("Rejected")) {
                     helper.setSubject("Job Status Change: Rejected ");
                     helper.setText("<b>"+"Dear"+" "+rjEmployeeName+","+"</b>"+"<br>"+"<br>"+"We regret to inform your referral"+" "+"<b>"+rjName +" is "+"REJECTED"+" for "+"'"+jdPositionTitle+"'"+"Position"+","+"Jobcode:"+rtPositionCode+"."+"</b>"+"<br>"+
                     "<u>Reason for REJECTION</U>:"+rjCommend+"<br>"+"We really appreciate your effort in referring candidates to Prodapt, looking forward to receive further referrals from you"+"<br>"+"<br>"+"<b>"+"Thank you<br>" + 
                     "Recruitment Team"+"</b>",true);  
                     
              }
              
              else if(rjStatus.equals("1st Round Scheduled")){
                     helper.setSubject("Job Status Change: First Round Interview Scheduled");
                     helper.setText("<b>"+"Dear"+" "+rjEmployeeName+","+"</b>"+"<br>"+"<br>"+"The First Round of Interview is scheduled for your referral "+" "+"<b>" +rjName +" for "+"'"+jdPositionTitle+"' "+"Position"+", "+"Jobcode:"+rtPositionCode+"."+"</b>"+"<br>"+
                     "We are looking forward to the interaction with the candidate, all the very best for your referral."+"<br>"+"<br>"+"<b>"+"Thank you<br>" + 
                     "Recruitment Team"+"</b>",true);  
                     
                     
              }
              
              else if(rjStatus.equals("1st Round Failed")) {
                     helper.setSubject("Job Status Change: First Round Interview Rejected");
                     helper.setText("<b>"+"Dear"+" "+rjEmployeeName+","+"</b>"+"<br>"+"<br>"+"We regret to inform your referral " +"<b>"+rjName +" not suitable for "+"'"+jdPositionTitle+"' "+"Position"+","+"Jobcode:"+rtPositionCode+"and confirmed as REJECTED."+"</b>"+"<br>"+"<br>"+
                     "<u>"+"Reason for REJECTION</u>:"+rjCommend+"<br>"+"One of the great things about Prodapt is the endless career opportunities we offer, looking forward to receive more referrals from you. "+"<br>"+"<br>"+"<b>"+"Thank you<br>" + 
                     "Recruitment Team"+"</b>",true);  
              
                     
              }
              
              
              else if(rjStatus.equals("1st Round Success")) {
                     helper.setSubject("Job Status Change: First Round Interview Selected");
                     helper.setText("<b>"+"Dear"+" "+rjEmployeeName+","+"</b>"+"<br>"+"<br>"+"We are pleased to inform your referral "+" " +"<b>"+rjName +" have successfully cleared the ‘First Round of Interview’ for "+"'"+jdPositionTitle+"' "+"Position"+","+"Jobcode:"+rtPositionCode+"."+"</b>"+"<br>"+
                     "We really appreciate your effort in referring candidates to Prodapt, the Second round of Interview schedule will be initiated on subsequent days."+"<br>"+"<br>"+"<b>"+"Thank you<br>" + 
                     "Recruitment Team"+"</b>",true);  
                     
                     
              }
              
              
              else if(rjStatus.equals("2nd Round Scheduled")) {
                     helper.setSubject("Job Status Change: Second Round Interview Selected");
                     
                     helper.setText("<b>"+"Dear"+" "+rjEmployeeName+","+"</b>"+"<br>"+"<br>"+"We are pleased to inform your referral "+" "+"<b>"+rjName +"have successfully cleared the ‘First Round of Interview’ for "+"'"+jdPositionTitle+"' "+"Position"+","+"Jobcode:"+rtPositionCode+"."+"</b>"+"<br>"+
                     "We really appreciate your effort in referring candidates to Prodapt, the Second round of Interview schedule will be initiated on subsequent days."+"<br>"+"<br>"+"<b>"+"Thank you<br>" + 
                     "Recruitment Team"+"</b>",true);  
                     
                     
              }
              
              
              else if(rjStatus.equals("2nd Round Failed")) {
                     helper.setSubject("Job Status Change: Second Round Interview Rejected");
                     
                     helper.setText("<b>"+"Dear"+" "+rjEmployeeName+","+"</b>"+"<br>"+"<br>"+"We regret to inform your referral" +" "+"<b>"+rjName +" not suitable for "+"'"+jdPositionTitle+"' "+"Position"+","+" Jobcode:"+rtPositionCode+"and confirmed as REJECTED.</b><br><br>"+
                     
                     "<u>Reason for REJECTION:</u>"+rjCommend+"<br>"+"One of the great things about Prodapt is the endless career opportunities we offer, looking forward to receive more referrals from you. " +"<br>"+"<br>"+"<b>"+"Thank you<br>" + 
                     "Recruitment Team"+"</b>",true ); 
                     
                     
              }
              
              else if(rjStatus.equals("2nd Round Success")) {
                     helper.setSubject("Job Status Change: Second Round Interview Selected");
                     
                     helper.setText("<b>"+"Dear"+" "+rjEmployeeName+","+"</b>"+"<br>"+"<br>"+"We are pleased to inform your referral "+" "+"<b>" +rjName +" have successfully cleared the ‘Second Round of Interview’ for "+"'"+jdPositionTitle+"' "+"Position"+","+"Jobcode:"+rtPositionCode+"</b>"+"<br>"+
                     "We really appreciate your effort in referring candidates to Prodapt, HR team will continue the discussion  with your referral"+" "+"<b>"+ rjName+"</b>"+" for further Offering Process."+"<br>"+"<br>"+"<b>"+"Thank you<br>" + 
                     "Recruitment Team"+"</b>",true);  
                     
                     
              }
              
              else if(rjStatus.equals("Offer Rolledout")) {
                     helper.setSubject("Job Status Change: Offer Rolled Out");
                     helper.setText("<b>"+"Dear"+" "+rjEmployeeName+","+"</b>"+"<br>"+"<br>"+"We are pleased to inform that Offer have been Rolled Out for your referral"+" "+"<b>" +rjName+" " +"for"+"'"+jdPositionTitle+"' "+"Position"+","+"Jobcode:"+rtPositionCode+"."+"</b>"+"<br>"+
                     "We really appreciate your effort in referring candidates to Prodapt, eagerly waiting for your referral"+" "+"<b>"+rjEmployeeName+" "+"to ‘Accept the Offer’."+"</b>"+"<br>"+"<br>"+"<b>"+"Thank you<br>" + 
                     "Recruitment Team"+"</b>",true);
                     
                     
              }
              
              else if(rjStatus.equals("Offer Rejected")) {
                     helper.setSubject("Job Status Change: Offer Rejected");
                     helper.setText("<b>"+"Dear"+" "+rjEmployeeName+","+"</b>"+"<br>"+"<br>"+"We regret to inform you that your referral "+" "+"<b>"+rjName+" " +" have Rejected Our Offer for "+"'"+jdPositionTitle+"' "+"Position"+","+"Jobcode:"+rtPositionCode+"."+"</b>"+"<br>"+"<br>"+"<u>"+
                     "Reason for Offer Rejection</u>:"+rjCommend+"<br>"+ "One of the great things about Prodapt is the endless career opportunities we offer, looking forward to receive more referrals from you."+"<br>"+"<br>"+"<b>"+"Thank you"+"<br>" + 
                     "Recruitment Team"+"</b>",true);
              
                     
              }
              
              else if(rjStatus.equals("Offer Accepted")) {
                     helper.setSubject("Job Status Change: Offer Accepted");
                     helper.setText("<b>"+"Dear"+" "+rjEmployeeName+","+"</b>"+"<br>"+"<br>"+"We are pleased to inform that your referral "+" "+"<b>"+rjName+" "+"have Accepted Our Offer for "+"'"+jdPositionTitle+"' "+"Position"+","+"Jobcode:"+rtPositionCode+"."+"</b>"+"<br>"+
                     "We really appreciate your effort in referring candidates to Prodapt, eagerly waiting for your referral"+" "+"<b>"+ rjEmployeeName +" "+"to become a Prodaptian."+"</b>"+"<b>"+"<br>"+"<br>"+"Thank you"+"<br>"+ 
                     "Recruitment Team"+"</b>",true);
              
                     
              }
              
              else{
                     helper.setSubject("Job Status Change: Joined");
                     helper.setText("<b>"+"Dear"+" "+rjEmployeeName+","+"</b>"+"<br>"+"<br>"+"We are pleased to inform that your referral"+" "+"<b>" +rjName+" " +"have Joined us on "+jdPositionTitle+"' "+"Position"+","+"Jobcode:"+rtPositionCode+"</b>"+"<br>"+
                     "Appreciate your support in building the Future of Prodapt, we are happy to present you with the Referral Points you deserve."+"<br>"+"<br>"+"<b>"+"Thank you<br>" + 
                     "Recruitment Team"+"</b>",true);  
              }
              sender.send(message);
        return "Mail Sent Success!";
    }
    
    @PostMapping("/jobMailSend")
    public String jobMailSend(@RequestParam String mail,@RequestParam String title,@RequestParam String positioncode,@RequestParam String empname) throws MessagingException{
//       SimpleMailMessage message=new SimpleMailMessage();
        MimeMessage message = sender.createMimeMessage();
       MimeMessageHelper helper = new MimeMessageHelper(message);
       helper.setTo(mail+"@prodapt.com");
       helper.setFrom("prithiviraj.r@prodapt.com");
       helper.setSubject("job details");
       helper.setText("Dear"+","+"<br>"+"<br>"+"Your Friend"+" "+"<b>"+empname+" ,"+"has referred "+"'"+title+"' "+"Position"+","+"Jobcode:"+positioncode+"</b>"+"<br>"+"<br>"+"<b>"+
                     "Thank you<br>" + 
                     "Recruitment Team"+"</b>",true);
       sender.send(message);
              return "mail send success";
    }

    
    
    @GetMapping("/sendMailStartMethod")
    public String sendMailStartMethod(@RequestParam String rjEmployeeMail,@RequestParam String jdPositionTitle,@RequestParam String rjEmployeeName,@RequestParam String rtPositionCode,@RequestParam String rjName)  throws MessagingException{
//    SimpleMailMessage message =new SimpleMailMessage();
    	MimeMessage message = sender.createMimeMessage();
    	MimeMessageHelper helper = new MimeMessageHelper(message);

    	helper.setTo(new String[] {rjEmployeeMail,"prithiviraj.r@prodapt.com"});
    	helper.setSubject("Profile Referral");
    	helper.setFrom("prithiviraj.r@prodapt.com");
    	helper.setText("<b>"+"Dear"+rjEmployeeName+"</b>"+"<br>"+"you have successfully referred"+" "+"<b>"+rjName+"</b>"+" "+"for"+"'"+"<b>"+jdPositionTitle+"</b>"+" '"+" Position"+","+" Jobcode:"+"<b>"+rtPositionCode+"</b>"+"<br><br>"+
               "Thank you"+"<br>" + 
               "Recruitment Team",true);
  
    	sender.send(message);

    	return "Mail Sent Success!";
    	}

}


