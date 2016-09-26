package refactory.dao.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import refactory.dao.LogTrackingDAO;
import refactory.dto.LogTrackingDTO;
import refactory.entity.Constant;
import refactory.entity.LogTracking;
import refactory.exception.TrackingException;
import refactory.util.enums.ConstantFatherEnum;

@Repository("logTrackingDAO")
public class LogTrackingDAOImpl implements LogTrackingDAO {

	private final static Logger LOGGER = Logger.getLogger(LogTrackingDAOImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public int insertLogTracking(LogTrackingDTO logDTO) throws TrackingException {
		int result=0;
		try {
			LogTracking log =new LogTracking();
			Query query  =  entityManager.createNamedQuery("Constant.findByValue1", Constant.class);
			query.setParameter("value1", String.valueOf(logDTO.getMessageTypeId()));
			query.setParameter("fatherId", Long.parseLong(ConstantFatherEnum.LOG_TYPE.getValue1()));
			Constant constant = (Constant)query.getSingleResult();
			
			log.setMessage(logDTO.getMessage());
			log.setCreatedBy(logDTO.getCreatedBy());
			log.setDateCreated(new Date());
			log.setConstant(constant);
			
			entityManager.persist(log);
			result=1;
		} catch (Exception e) {
			LOGGER.error(e);
			result=0;
		}
		
		
		return result;
	}

}
