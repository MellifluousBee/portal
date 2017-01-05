package org.stlsymphony.portal.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stlsymphony.portal.models.BarSchedule;
import org.stlsymphony.portal.models.Bartender;

@Controller
public class BarScheduleController extends AbstractController {
	@RequestMapping(value="/requestoff", method=RequestMethod.GET)
	public String requestoff(Model model){
		
		return "requestoff";
	}
	@RequestMapping(value = "/createBarSchedule", method = RequestMethod.GET)
	public String newBarSchedule() {
		return "createBarSchedule";
	}
	@RequestMapping(value = "/createBarSchedule", method = RequestMethod.POST)
	public String saveBarSchedule(HttpServletRequest request, Model model) {
		
	
		//get request parameters
		String day=request.getParameter("day");
		String formdate=request.getParameter("date");

		//convert String to LocalDate
		LocalDate date= LocalDate.parse(formdate);
		String calltime=request.getParameter("calltime");
		String formbartenders=request.getParameter("bartenders");
		ArrayList<String> namestring= new ArrayList<>(Arrays.asList(formbartenders.split(",")));
		ArrayList<Bartender>bartenders=new ArrayList<Bartender>();//create arraylist bartenders, add each String username as bartenders object to arraylist to instantiate barschedule
//		for(int i=0;i<namestring.size();i++){//for each indice of liststring, use bartenderDao to return a bartender
//			String username=namestring.get(i);
//			Bartender b=bartenderDao.findByUsername(username);//method returns a bartender
//			bartenders.add(b);//method sets the value of bartender b at that index of the bartender array	
//		}
		for (String name : namestring){
			String username=name;
			Bartender b=bartenderDao.findByUsername(username);//method returns a bartender
			bartenders.add(b);//method sets the value of bartender b at that index of the bartender array	
		}
		//can try to figure out how to use JS and AJAX to display the users information to them in the browser before submitting
		//validate parameters
		
//			if (day == "Monday" || day =="Tuesday"||day=="Wednesday"||day=="Thursday"||day=="Friday"||day=="Saturday"||day=="Sunday"){
//			
//			}else{model.addAttribute("day_error", "You must enter a day of the week with the first letter capitalized");
//		
			//create a new barschedule object and save it to database
		BarSchedule bs= new BarSchedule(day, date, calltime, bartenders);
		barscheduleDao.save(bs);
		int uid=bs.getUid();
		return "redirect:/viewBarSchedule/" + uid;
		}
		
		
		@RequestMapping(value="/viewBarSchedule/{uid}", method=RequestMethod.GET)
		public String viewBarSchedule(@PathVariable int uid, Model model){
//			BarSchedule bs= barscheduleDao.findByUid(uid);
//			String day=bs.getDay();
//			LocalDate date= bs.getDate();
//			String calltime=bs.getCallTime();
//			ArrayList<Bartender>bartenders=bs.getBartenders();//?don't have to turn this back into a String list
//			model.addAttribute("day", day);
//			model.addAttribute("date", date);
//			model.addAttribute("calltime",calltime);
//			model.addAttribute("bartenders", bartenders);
//			
			return "viewBarSchedule";
		}
	
}
