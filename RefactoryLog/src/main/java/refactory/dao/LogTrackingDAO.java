package refactory.dao;

import refactory.dto.LogTrackingDTO;
import refactory.exception.TrackingException;

public interface LogTrackingDAO {

	/**
	 * 
	 * @param log
	 * @return
	 * @throws TrackingException
	 */
	int insertLogTracking(LogTrackingDTO log)throws TrackingException;
	
}
