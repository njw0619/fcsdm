package com.njw0619.fcsdm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.njw0619.fcsdm.service.TransactionService;

@Controller
public class HomeController {
	
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	TransactionService transactionService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String goHome(Model model) {
		return "home";
	}
}
