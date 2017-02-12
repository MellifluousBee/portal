package org.stlsymphony.portal.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.stlsymphony.portal.models.Bartender;


@Transactional//include it on daos
@Repository//treat it like an object repository and automatically creates instances for you
public interface BartenderDao extends UserBaseRepository<Bartender> {
	   List<Bartender> findAll();
	    
	    Bartender findByUid(int uid);
    

    
}