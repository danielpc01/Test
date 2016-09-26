package refactory.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the constants database table.
 * 
 */
@Entity
@Table(name="constants")
@NamedQueries({
    @NamedQuery(name="Constant.findAll",
                query="SELECT c FROM Constant c"),
    @NamedQuery(name="Constant.findByValue1",
                query="SELECT c FROM Constant c where c.value1 = :value1 and c.fatherId =:fatherId"),
}) 
public class Constant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="CREATED_BY")
	private Long createdBy;


	@Column(name="DATE_CREATED")
	private Date dateCreated;


	@Column(name="DATE_UPDATED")
	private Date dateUpdated;

	@Column(name="FATHER_ID")
	private Long fatherId;

	private String name;

	@Column(name="UPDATED_BY")
	private Long updatedBy;

	private String value1;

	private String value2;

	private String value3;

	

	public Constant() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Long getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getValue1() {
		return this.value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return this.value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return this.value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

}