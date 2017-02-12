package org.stlsymphony.portal.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.stlsymphony.portal.models.Bartender;
import org.stlsymphony.portal.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController extends AbstractController {
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupForm() {
		return "signup";
	}//display template
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(HttpServletRequest request, Model model) {
		
		//1st- get parameters from request object 
		String username= request.getParameter("username");
		String password=request.getParameter("password");
		String verify=request.getParameter("verify");
		String jobtitle=request.getParameter("jobtitle");
		
		if(User.isValidUsername(username)){//if the username meets minimum standards
			if(userDao.findByUsername(username)!=null){
				model.addAttribute("error", "This username already exists.");
				return "signup";
			}else{
			if(User.isValidPassword(password)){
					if (password.equals(verify)){//and if password and verify password are equal
						//create a new user according to jobtitle, setup the session
//						if(jobtitle=="headBartender"){
//							HeadBartender hb= new HeadBartender();
//							hb.setPassword(password);
//							hb.setUsername(username);
//							userDao.save(hb);
//							HttpSession thisSession=request.getSession();
//							setUserInSession(thisSession,hb);	
//							
//							return "redirect:/myShifts";
//							
//						}else{
							Bartender b= new Bartender();
							b.setPassword(password);
							b.setUsername(username);
							//add user to database
							userDao.save(b);
							HttpSession thisSession= request.getSession();
							setUserInSession(thisSession, b);
							
							return "redirect:/myShifts";
						}
					else{//put error message into the template
						model.addAttribute("verify_error", "Your passwords don't match. Try again.");
						return "signup";
					}
				}else{
					model.addAttribute("password_error", "This is an invalid password. Nice try.");
					return "signup";
				}
			}}else{
			model.addAttribute("username_error", "This username is not valid.");
			return "signup";
		}
		
		//2nd-validate parameters (username, password, and verify password using methods in User model class)
		//also make sure the passwords match
		//if they validate, create a new user and store them in the session
		// can access session by saying HttpSession thisSession= request.getSession();
		//going to use the setUserInSession method in the abstract controller
		
		
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginForm() {
		return "index";
	}//displays login template
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		
		//get parameters from request, get user by their username
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		
		//check password is correct, if incorrect, pass an error through the template
		if(userDao.findByUsername(username)!= null){//checks if user exists in DB
			//establish a user object
			User u= userDao.findByUsername(username);//this method returns a user,saved as user u
			//check password against database
			if(u.isMatchingPassword(password)){//checks if the password variable hashes to be the same as the hashed password in the database
				HttpSession thisSession= request.getSession();//log them in if so (by setting the user in the session)
				setUserInSession(thisSession, u);
			}else{
				model.addAttribute("error", "This is not the correct password");
				return "index";
			}
		}else{
			model.addAttribute("error", "Um... this user doesn't exist");
			return "index";
		}
		
		
		return "redirect:/myShifts";
	}
	//redirects
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
        request.getSession().invalidate();
		return "redirect:/";
	}
}
