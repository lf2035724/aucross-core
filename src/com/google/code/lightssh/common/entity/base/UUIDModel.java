package com.google.code.lightssh.common.entity.base;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.code.lightssh.common.entity.Persistence;

/**
 *  模型基类,程序生成ID
 * @author YangXiaojin
 *
 */
@MappedSuperclass
public abstract class UUIDModel implements Persistence<Long>{
	
	private static final long serialVersionUID = -3724545121540047990L;

	/**
	 * table
	 */
	@Id
	@Column(name="ID")
	@GeneratedValue( strategy=GenerationType.TABLE)
	protected Long id;
	
	/**
	 * 创建日期
	 */
	@Column(name="CREATED_TIME",columnDefinition="DATE")
	@Temporal( TemporalType.TIMESTAMP )
	protected Calendar createdTime;
	
	public UUIDModel(){
	}

	public Long getIdentity( ){
		return this.id;
	}
	
	public void postInsertFailure( ){
		this.createdTime = null;
		this.id = null;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UUIDModel other = (UUIDModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
