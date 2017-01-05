package org.stlsymphony.portal.controllers;

import javax.servlet.http.HttpSession;

import org.stlsymphony.portal.models.User;
import org.stlsymphony.portal.models.dao.BarScheduleDao;
import org.stlsymphony.portal.models.dao.BartenderDao;
import org.springframework.beans.factory.annotation.Autowired;
//want all controllers to have access to methods in this controller
public abstract class AbstractController {
	//dependency inject DAOs to query database for user and schedule objects
	//spring creates objects for us that implement the database

	@Autowired
	protected BarScheduleDao barDao;
	@Autowired 
	protected BartenderDao bartenderDao;
	@Autowired
	protected BarScheduleDao barscheduleDao;
	
	//static variables can be accessed in other classes without creating an instances of the origin class
    public static final String userSessionKey = "user_id";
    //sessions let you store little bits of info on the server about the requester, like cookies, so we can keep the user logged in 
    
    protected User getUserFromSession(HttpSession session) {//all classes can ask for the logged in user using this method
    	
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : bartenderDao.findByUid(userId);
    }
    //if someone correctly authenticates, you need to set them as logged in
    protected void setUserInSession(HttpSession session, User user) {
    	session.setAttribute(userSessionKey, user.getUid());
    }
	
}
