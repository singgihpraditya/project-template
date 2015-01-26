package com.singgih.spring.sample.vo;

import java.util.Date;

import com.google.common.base.Objects;
import com.singgih.spring.sample.type.Gender;

public class UserVo {
	private String userName;
	private String firstName;
	private String lastName;
//	private String password;
//	private Date birthDate;
//	private Gender gender;
//	private RoleVo role;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
//
//	public Date getBirthDate() {
//		return birthDate;
//	}
//
//	public void setBirthDate(Date birthDate) {
//		this.birthDate = birthDate;
//	}
//
//	public Gender getGender() {
//		return gender;
//	}
//
//	public void setGender(Gender gender) {
//		this.gender = gender;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public RoleVo getRole() {
//		return role;
//	}
//
//	public void setRole(RoleVo role) {
//		this.role = role;
//	}

	@Override
	public String toString() {
		return Objects.toStringHelper(getClass())
				.add("userName", userName)
				.add("firstName", firstName)
				.add("lastName", lastName)
//				.add("gender", gender)
//				.add("birthDate", birthDate)
//				.add("password", password)
//				.add("role", role)
				.toString();
	}
}
