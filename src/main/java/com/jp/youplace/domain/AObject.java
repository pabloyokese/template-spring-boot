package com.jp.youplace.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public abstract class AObject {

	@Version
	@Column(name = "VERSION")
	private int version;

	@CreatedDate
	@Column(name = "CREATION_DATE", nullable = false)
	private Date creationDate;

	@LastModifiedDate
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@JsonIgnore
	@CreatedBy
	@Column(name = "CREATED_BY", nullable = false)
	private String createdBy;

	@JsonIgnore
	@LastModifiedBy
	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "ENABLED", columnDefinition = "INT", nullable = false)
	private boolean enabled = true;

	public AObject() {
	}

	public abstract void editFrom(AObject object);

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
