package org.stlsymphony.portal.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.NoRepositoryBean;
import org.stlsymphony.portal.models.User;

//@NoRepositoryBean
public interface UserBaseRepository <T extends User> extends CrudRepository<T, Integer> {
	// create one DAO for each model class stored in the database
	//use dao to query one of the class in the database within the application
	//Spring builds a class that implements this interface for me
	//we can't create instances of interfaces, so we have to use spring to autowire the dao to use it for queries	
		public T findByUid(int uid);

		public T findByUsername(String username);
		
		public List<T> findAll();
		
}
