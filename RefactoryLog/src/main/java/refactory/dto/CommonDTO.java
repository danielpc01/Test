package refactory.dto;

import java.io.Serializable;
import java.util.Date;

public class CommonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Attributes to Audit
	private Long createdBy;
	private Date dateCreated;
	private Long updatedBy;
	private Date dateUpdated;
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	
}
