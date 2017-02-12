package org.stlsymphony;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stlsymphony.portal.controllers.AbstractController;
import org.stlsymphony.portal.models.dao.BarScheduleDao;
import org.stlsymphony.portal.models.dao.UserDao;
import org.stlsymphony.portal.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//used to determine whether or not a user is logged in
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	//spring's dependency injection will set up the DAO
    //data access objects used to pull users and schedules out of database
      @Autowired
      UserDao userDao;
      
      @Autowired
      BarScheduleDao barScheduleDao;
    
    @Override//preHandle means this code will run before every single request
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
    	//make a list of restricted URLs, so user has to be authenticated in order to see it
        List<String> authPages = Arrays.asList("/myprofile","/myShifts","/requestoff", "/setAvailability");

        // Require sign-in for auth pages
        if ( authPages.contains(request.getRequestURI()) ) {
        	// if the requested url in the browser is one of the restricted pages
        	boolean isLoggedIn = false;//initially set isloggedin to false
        	User user;
        	//look for a loggedin user, login is stored in a "session" that normally uses cookies to store user info
            //this session stores user info in server, not browser
        	//looked for the id of a logged in user
        	Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null) {
            	user = userDao.findByUid(userId);//try to look up user in database
            	
            	if (user != null) {
            		isLoggedIn = true;
            	}
            }

            // If user not logged in, redirect to login page
            if (!isLoggedIn) {
                response.sendRedirect("/");
                return false;
            }
        }

        return true;//it will direct where user was trying to go in the first place
    }

}


