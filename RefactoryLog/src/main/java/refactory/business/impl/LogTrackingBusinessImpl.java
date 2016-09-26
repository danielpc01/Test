package refactory.business.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import refactory.business.LogTrackingBusiness;
import refactory.dao.ConstantDAO;
import refactory.dao.LogTrackingDAO;
import refactory.dto.ConstantDTO;
import refactory.dto.LogTrackingDTO;
import refactory.exception.TrackingException;
import refactory.util.enums.ConstantFatherEnum;
import refactory.util.enums.LogTypeEnum;

@Service("logTrackingBusiness")
public class LogTrackingBusinessImpl implements LogTrackingBusiness{
	private final static Logger LOGGER = Logger.getLogger(LogTrackingBusinessImpl.class);
	private final static Logger LOGGER_REPORT =Logger.getLogger("reportsLogger");
	
	@Autowired
	private LogTrackingDAO logTrackingDAO;
	
	@Autowired
	private ConstantDAO constantDAO;

	@Value("${log.console.enabled}")
	private String consoleEnabled;
	
	@Value("${log.file.enabled}")
	private String fileEnabled;
	
	@Value("${log.database.enabled}")
	private String databaseEnabled; 
	 
	@Override
	public int saveLog(LogTrackingDTO logTracking) throws TrackingException {
	
		Boolean isConsole = new Boolean(logTracking.getIsConsole());
		Boolean isFile = new Boolean(logTracking.getIsFile());
		Boolean isDatabase = new Boolean(logTracking.getIsDatabase());
		int result=0;
		
		// VALIDATION
		if (!isConsole && !isFile && !isDatabase) {
			throw new TrackingException("Invalid configuration");
		}
		
		if((logTracking.getMessage()==null || logTracking.getMessage().trim().isEmpty()) ||
				(logTracking.getMessageTypeId()<=0) ||
				(!LogTypeEnum.contains(String.valueOf(logTracking.getMessageTypeId())))
				){
			
			throw new TrackingException("Error or Warning or Message must be specified");
		}
		
		// CUSTOM THE MESSAGE
		StringBuilder sbMessage=new StringBuilder();
		ConstantDTO messageConst=constantDAO.getConstant(
				String.valueOf(logTracking.getMessageTypeId()), 
				Long.parseLong(ConstantFatherEnum.LOG_TYPE.getValue1()));
		
		sbMessage.
		append(messageConst.getValue2()).
		append(" ").
		append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date())).
		append(" ").
		append(logTracking.getMessage());
		
		if(isConsole){
			result=1;
			LOGGER.info(sbMessage.toString());
		}
		
		if(isFile){
			result=1;
			LOGGER_REPORT.info(sbMessage.toString());
		}
		
		if(isDatabase){
			logTracking.setMessage(sbMessage.toString());
			result=logTrackingDAO.insertLogTracking(logTracking);
		}
		
		return result;
	}
	
	
	
	
}
