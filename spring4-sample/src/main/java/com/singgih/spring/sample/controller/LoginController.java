package com.singgih.spring.sample.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.singgih.spring.sample.vo.LoginVo;

@Controller
public class LoginController {

	Logger log = Logger.getLogger("com.singgih.spring4");

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("loginVo") LoginVo login, Model model) {
		log.debug("LoginVo : " + login);
		return "login";
	}

}
