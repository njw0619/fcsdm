package com.njw0619.fcsdm.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.njw0619.fcsdm.model.Member;
import com.njw0619.fcsdm.service.MemberService;

@Controller
@RequestMapping("members")
public class MemberController {
	
private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getMembers(Model model) {
		List<Member> members = memberService.getMembers();
		model.addAttribute("members", members);		
		return "member/list";
	}
	
}
