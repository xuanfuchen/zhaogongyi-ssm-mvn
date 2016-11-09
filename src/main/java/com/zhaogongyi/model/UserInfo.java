package com.zhaogongyi.model;

import java.util.Date;

import javax.persistence.Id;

public class UserInfo {
	
	private Integer userId;
	private String userName;
	private Integer age;
	private Byte gender; // A very small integer. The signed range is -128 to
							// 127. The unsigned range is 0 to 255.

	private Double weight;
	private Date birthday;
	private Date regDatetime;
	@Id
	public Integer getUserId() {
		return userId;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getRegDatetime() {
		return regDatetime;
	}

	public void setRegDatetime(Date regDatetime) {
		this.regDatetime = regDatetime;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", age=" + age + ", gender=" + gender
				+ ", weight=" + weight + ", birthday=" + birthday + ", regDatetime=" + regDatetime + "]";
	}
	
	

}
