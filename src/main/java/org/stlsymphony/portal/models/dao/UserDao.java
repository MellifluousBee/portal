package org.stlsymphony.portal.models.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.stlsymphony.portal.models.User;

@Transactional//include it on daos
@Repository//treat it like an object repository and automatically creates instances for you
public interface UserDao extends UserBaseRepository<User> {

    

    
}