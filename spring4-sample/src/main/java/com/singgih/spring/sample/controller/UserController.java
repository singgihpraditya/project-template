package com.singgih.spring.sample.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.singgih.spring.sample.vo.UserVo;

@Controller
public class UserController extends BaseController {
	Logger log = Logger.getLogger("com.singgih.spring4");

	@RequestMapping("/user/list")
	public String list(Model model) {
		return "user/list";
	}

	@RequestMapping("/user/ajax/list/{page}")
	public String list(@PathVariable("page") int page, Model model) {
		return "user/ajax/list";
	}

	@RequestMapping(value = "/user/ajax/form", method = RequestMethod.GET)
	public String form(Model model) {
		return "user/ajax/form";
	}

	@RequestMapping(value = "/user/ajax/form", method = RequestMethod.POST)
	public String form(@ModelAttribute("user") UserVo user, Model model) {
		log.debug("user : "+user);
		return "user/ajax/form";
	}

}
