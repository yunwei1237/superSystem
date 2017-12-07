package com.tcf.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * SmbmsUser entity. @author MyEclipse Persistence Tools
 */

public class SmbmsUser implements java.io.Serializable {

	// Fields

	private Long id;
	@NotEmpty(message="用户编码不能空")
	private String userCode;
	@NotEmpty(message="用户名不能空")
	private String userName;
	@NotNull(message="密码不能为空")
	@Length(message="密码长度为6-10",min=6,max=10)
	private String userPassword;
	private Integer gender;
	/*@DateTimeFormat(pattern="yyyy-MM-dd")*/
	/*@JSONField(format="yyyy-MM-dd")*/
	@Past(message="必须是一个过去的时间")
	private Date birthday;
	private String phone;
	private String address;
	private Integer userRole;
	private Long createdBy;
	private Timestamp creationDate;
	private Long modifyBy;
	private Timestamp modifyDate;
	private SmbmsRole role;
	// Constructors

	/** default constructor */
	public SmbmsUser() {
	}
	
	public SmbmsUser(String userName, Integer userRole) {
		super();
		this.userName = userName;
		this.userRole = userRole;
	}

	public SmbmsUser(String userCode) {
		super();
		this.userCode = userCode;
	}

	/** full constructor */
	public SmbmsUser(String userCode, String userName, String userPassword,
			Integer gender, Date birthday, String phone, String address,
			Integer userRole, Long createdBy, Timestamp creationDate,
			Long modifyBy, Timestamp modifyDate) {
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userRole = userRole;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Long getModifyBy() {
		return this.modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Timestamp getModifyDate() {
		return this.modifyDate;
	}

	public SmbmsRole getRole() {
		return role;
	}

	public void setRole(SmbmsRole role) {
		this.role = role;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "SmbmsUser [id=" + id + ", userCode=" + userCode + ", userName="
				+ userName + ", userPassword=" + userPassword + ", gender="
				+ gender + ", birthday=" + birthday + ", phone=" + phone
				+ ", address=" + address + ", userRole=" + userRole
				+ ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + "]";
	}

}