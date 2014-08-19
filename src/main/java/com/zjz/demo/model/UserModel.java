package com.zjz.demo.model;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class UserModel {
	private int id;
	
	@Pattern(regexp = "[A-Za-z0-9]{5,20}", message = "{username.illegal}")
	// java validator验证（用户名字母数字组成，长度为5-10）
	private String username;
	
	// 错误消息会自动到MessageSource中查找
	private String email;
	
	@Pattern(regexp = "[A-Za-z0-9]{5,20}", message = "{password.illegal}")
	private String password;
	
	// 自定义的验证器
	private Date registerDate;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getRegisterDate() {
		return registerDate;
	}
	
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UserModel) {
			UserModel other = (UserModel) obj;
			return new EqualsBuilder().append(id, other.getId()).isEquals();
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("username", username)
				.append("registerDate", registerDate).toString();
	}
	
	public UserModel(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	public UserModel() {
		// TODO Auto-generated constructor stub
	}
	
	public UserModel(int id, String username, Date registerDate) {
		super();
		this.id = id;
		this.username = username;
		this.registerDate = registerDate;
	}
	
}
