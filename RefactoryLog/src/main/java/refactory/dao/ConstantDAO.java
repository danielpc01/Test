package refactory.dao;

import java.util.List;

import refactory.dto.ConstantDTO;
import refactory.exception.TrackingException;

public interface ConstantDAO {
	/**
	 * 
	 * @param id
	 * @param idFather
	 * @return
	 * @throws TrackingException
	 */
	ConstantDTO getConstant(Long id, Long idFather) throws TrackingException;
	
	/**
	 * 
	 * @param value1
	 * @param idFather
	 * @return
	 * @throws TrackingException
	 */
	ConstantDTO getConstant(String value1, Long idFather) throws TrackingException;
	
	/**
	 * 
	 * @param idFather
	 * @return
	 * @throws TrackingException
	 */
	List<ConstantDTO> getConstants(Long idFather)throws TrackingException;
	
}
