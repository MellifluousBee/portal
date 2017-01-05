package org.stlsymphony.portal.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PortalController extends AbstractController {
//need to use methods on the DAOs to fetch users and schedules
	@RequestMapping(value = "/myShifts", method=RequestMethod.GET)
	public String shift(Model model){
		
		return "myShifts";
	}
	
	@RequestMapping(value="/calendar", method=RequestMethod.GET)
	public String calendar(Model model){
		
		return "calendar";
	}
	
	@RequestMapping(value="/myprofile", method=RequestMethod.GET)
	public String profile(Model model){
		
		return "myprofile";
	}
	@RequestMapping(value="/setAvailablity", method=RequestMethod.GET)
	public String setAvailability(Model model){
		return "setAvailability";
	}
	
		
	}
