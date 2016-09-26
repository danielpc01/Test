package refactory.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import refactory.dao.ConstantDAO;
import refactory.dto.ConstantDTO;
import refactory.exception.TrackingException;

@Repository("constantDAO")
public class ConstantDAOImpl implements ConstantDAO  {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public ConstantDTO getConstant(Long id, Long idFather) throws TrackingException {

		ConstantDTO constant=null;
		
		StringBuilder sql =new StringBuilder();
		sql.append(" SELECT c.id, c.name, c.value1, c.value2, c.value3 ");
		sql.append(" FROM Constant c ");
		sql.append(" WHERE c.id = :constId ");
		sql.append(" AND c.fatherId = :constFathId ");
		Query query = this.entityManager.createQuery(sql.toString());
		query.setParameter("constId", id);
		query.setParameter("constFathId", idFather);
		
		
		List<Object[]> listObject = query.getResultList();
		for(Object[] obj : listObject){
			constant =new ConstantDTO();
			constant.setId((Long)obj[0]);
			constant.setName((String)obj[1]);
			constant.setValue1((String)obj[2]);
			constant.setValue2((String)obj[3]);
			constant.setValue3((String)obj[4]);
		
		}
		
		return constant;
	}
	
	@Override
	public ConstantDTO getConstant(String value1, Long idFather) throws TrackingException {

		ConstantDTO constant=null;
		
		StringBuilder sql =new StringBuilder();
		sql.append(" SELECT c.id, c.name, c.value1, c.value2, c.value3 ");
		sql.append(" FROM Constant c ");
		sql.append(" WHERE c.value1 = :value1 ");
		sql.append(" AND c.fatherId = :constFathId ");
		Query query = this.entityManager.createQuery(sql.toString());
		query.setParameter("value1", value1);
		query.setParameter("constFathId", idFather);
		
		
		List<Object[]> listObject = query.getResultList();
		for(Object[] obj : listObject){
			constant =new ConstantDTO();
			constant.setId((Long)obj[0]);
			constant.setName((String)obj[1]);
			constant.setValue1((String)obj[2]);
			constant.setValue2((String)obj[3]);
			constant.setValue3((String)obj[4]);
		
		}
		
		return constant;
	}

	@Override
	public List<ConstantDTO> getConstants(Long idFather) throws TrackingException {
		List<ConstantDTO> list= new ArrayList<ConstantDTO>();
		
		StringBuilder sql =new StringBuilder();
		sql.append(" SELECT c.id, c.name, c.value1, c.value2, c.value3 ");
		sql.append(" FROM Constant c ");
		sql.append(" WHERE c.fatherId = :constFathId ");
		
		Query query = this.entityManager.createQuery(sql.toString());
		query.setParameter("constFathId", idFather);
		
		
		List<Object[]> listObject = query.getResultList();
		for(Object[] obj : listObject){
			ConstantDTO constant =new ConstantDTO();
			constant.setId((Long)obj[0]);
			constant.setName((String)obj[1]);
			constant.setValue1((String)obj[2]);
			constant.setValue2((String)obj[3]);
			constant.setValue3((String)obj[4]);
			list.add(constant);
		}
		
		return list;
	}

}
