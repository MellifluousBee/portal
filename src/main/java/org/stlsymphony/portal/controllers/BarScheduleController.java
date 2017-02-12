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
