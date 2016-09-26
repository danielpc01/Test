package refactory.rest.request;

import java.io.Serializable;

import refactory.dto.LogTrackingDTO;

public class TrackingRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LogTrackingDTO log;
	public LogTrackingDTO getLog() {
		return log;
	}
	public void setLog(LogTrackingDTO log) {
		this.log = log;
	}
	
	
	
	
}
