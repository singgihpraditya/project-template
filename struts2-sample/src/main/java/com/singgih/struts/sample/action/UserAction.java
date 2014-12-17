package com.singgih.struts.sample.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.singgih.struts.sample.vo.UserVo;


public class UserAction extends BaseAction {
	private static final long serialVersionUID = -3500171507041956356L;

	Logger log = Logger.getLogger("com.singgih.struts");
	private UserVo user;
	private List<UserVo> userList;

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}

	public List<UserVo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserVo> userList) {
		this.userList = userList;
	}

	public String save() {
		startTimer();
		log.debug(user);
		stopTimer();
		return SUCCESS;
	}

	public String list() {
		startTimer();
		log.debug(userList);
		stopTimer();
		return SUCCESS;
	}
}
