package refactory.business;

import refactory.dto.LogTrackingDTO;
import refactory.exception.TrackingException;

public interface LogTrackingBusiness {

	int saveLog(LogTrackingDTO logTracking) throws TrackingException;
	
}
