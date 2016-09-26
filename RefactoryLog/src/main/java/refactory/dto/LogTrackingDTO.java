package refactory.dto;

import java.io.Serializable;

public class LogTrackingDTO extends CommonDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String message;
	private Long messageTypeId;
	private String messageTypeName;
	
	private Boolean isFile;
	private Boolean isConsole;
	private Boolean isDatabase;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getMessageTypeId() {
		return messageTypeId;
	}
	public void setMessageTypeId(Long messageTypeId) {
		this.messageTypeId = messageTypeId;
	}
	public String getMessageTypeName() {
		return messageTypeName;
	}
	public void setMessageTypeName(String messageTypeName) {
		this.messageTypeName = messageTypeName;
	}
	public Boolean getIsFile() {
		return isFile;
	}
	public void setIsFile(Boolean isFile) {
		this.isFile = isFile;
	}
	public Boolean getIsConsole() {
		return isConsole;
	}
	public void setIsConsole(Boolean isConsole) {
		this.isConsole = isConsole;
	}
	public Boolean getIsDatabase() {
		return isDatabase;
	}
	public void setIsDatabase(Boolean isDatabase) {
		this.isDatabase = isDatabase;
	}
	
	
	
	
}
