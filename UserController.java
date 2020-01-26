package com.app.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Users;
import com.app.service.IUserService;

import org.springframework.mail.MailException;
//import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = "*")
public class UserController 
{
	@Autowired
	private IUserService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Users user)
	{
		System.out.println("Inside Register");
		
		Integer uid = service.registerUserService(user);
		
		if(uid != null)
			return new ResponseEntity<Integer>(uid,HttpStatus.OK);
		return new ResponseEntity<String>("Already Exists",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Users user)
	{
		System.out.println("Inside Login Method");
		byte statusVal=1;
		user.setStatus(statusVal);
		try 
		{
			return new ResponseEntity<Users>(service.loginUserService(user),HttpStatus.OK);
		} 
		catch (RuntimeException e)
		{
			return new ResponseEntity<String>("Invalid User",HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@GetMapping("/forget")
	public String showForgotPassword()
	{
		return "Forgot Password";
	}
	
	@PostMapping("/forget")
	public String processForgetPassword(@RequestBody Users user,HttpSession hs,Model map)
	{
		String email = user.getEmail();
		System.out.println(email);
		Users getUser;
		
		try 
		{
			getUser = service.findByEmailService(email);
			hs.setAttribute("user", getUser);
			
			if(getUser != null)
			{
				int otp = service.generateOtp();
				hs.setAttribute("OTP",otp);
				String msg="Your one time password for forget password is = " + otp;
				
				SimpleMailMessage mailmessage = new SimpleMailMessage();
				mailmessage.setTo(getUser.getEmail());
				mailmessage.setSubject("One Time Password");
				mailmessage.setText(msg);
				
				
				try 
				{
					mailSender.send(mailmessage);
				}
				catch (MailException e) 
				{
					System.out.println("Inside Mail Exception");
					e.printStackTrace();
				}
			}
		}
		catch(NoResultException e)
		{
			map.addAttribute("msg","Please Enter Valid Email");
			e.printStackTrace();
		}
		
		
		return "forget password";
	}
}
