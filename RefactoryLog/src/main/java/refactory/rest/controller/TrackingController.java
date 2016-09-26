package refactory.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import refactory.business.LogTrackingBusiness;
import refactory.dao.impl.LogTrackingDAOImpl;
import refactory.dto.LogTrackingDTO;
import refactory.exception.TrackingException;
import refactory.rest.request.TrackingRequest;
import refactory.rest.response.CommonResponse;
import refactory.util.enums.ServiceResponseEnum;


@Controller
@RequestMapping( value = "/tracking" )
public class TrackingController {
	private final static Logger LOGGER = Logger.getLogger(TrackingController.class);
	

	
	
	
	@Autowired
	private LogTrackingBusiness logTrackingBusiness;
	
	
	@RequestMapping(
			value = "/saveLog", 
			method = RequestMethod.POST, 
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody CommonResponse saveLog(
			@RequestBody TrackingRequest request
			){
		CommonResponse response=new CommonResponse();
		
		String codResponse=null;
		String msgResponse=null;
		try {
			/*LogTrackingDTO logTracking=new LogTrackingDTO();
			logTracking.setMessage(request.getMessage());
			logTracking.setMessageTypeId(Long.parseLong(request.getMessageType()));
			
			logTracking.setSaveToConsole(request.getSaveToConsole());
			logTracking.setSaveToDatabase(request.getSaveToDatabase());
			logTracking.setSaveToFile(request.getSaveToFile());
			*/
			logTrackingBusiness.saveLog(request.getLog());
			codResponse=ServiceResponseEnum.SUCCESS.getCode();
			msgResponse=ServiceResponseEnum.SUCCESS.getMessage();
		} catch (TrackingException e) {
			codResponse=ServiceResponseEnum.ERROR.getCode();
			msgResponse = e.getMessage();
			LOGGER.error(e.getMessage(),e);
		}
		
		
		
		
		response.setCodResponse(codResponse);
		response.setMsgResponse(msgResponse);
		return response;
	}
}
