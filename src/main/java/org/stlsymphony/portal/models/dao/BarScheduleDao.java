package org.stlsymphony.portal.models.dao;

	import java.util.List;

	import javax.transaction.Transactional;


	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;
	import org.stlsymphony.portal.models.BarSchedule;



	@Transactional
	@Repository
	public interface BarScheduleDao extends CrudRepository<BarSchedule, Integer> {
	    
	    List<BarSchedule> findAll();
	    
	    BarSchedule findByUid(int uid);
	    

	}


