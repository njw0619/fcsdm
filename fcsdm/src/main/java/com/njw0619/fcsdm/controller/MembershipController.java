package com.njw0619.fcsdm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.njw0619.fcsdm.model.FlashMessage;
import com.njw0619.fcsdm.model.Member;
import com.njw0619.fcsdm.model.Membership;
import com.njw0619.fcsdm.model.Transaction;
import com.njw0619.fcsdm.service.MemberService;
import com.njw0619.fcsdm.service.MembershipService;
import com.njw0619.fcsdm.service.TransactionService;

@Controller
@RequestMapping("memberships")
public class MembershipController extends BaseController{
	
private static final Logger logger = LoggerFactory.getLogger(MembershipController.class);
	
	@Autowired
	MembershipService membershipService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	TransactionService transactionService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(method = RequestMethod.GET)
	public String getMemberships(Model model) {	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String currentMonth = sdf.format(new Date());
		
		List<Membership> memberships = membershipService.getMemberships();	
		
		List<Membership> paid = new ArrayList<Membership>();
		List<Membership> unpaid = new ArrayList<Membership>();
		
		for(Membership membership : memberships) {
			if(StringUtils.isEmpty(membership.getOccurMonth())) membership.setOccurMonth("납부이력 없음");
			membership.setOccupation("W".equals(membership.getOccupation()) ? "직장인" : "학생");
			membership.setGrade("1".equals(membership.getGrade()) ? "정규" : "명예");
			if(!"납부이력 없음".equals(membership.getOccurMonth()) && (Integer.parseInt(membership.getOccurMonth()) >= Integer.parseInt(currentMonth) 
					|| ("명예".equals(membership.getGrade()) && "2018".equals(membership.getOccurMonth())))) {
				paid.add(membership);
			}
			else {
				unpaid.add(membership);
			}
		}
		StringBuilder memo = new StringBuilder();
		memo.append("회비 미납자 명단\n");
		for(Membership membership : unpaid) {
			memo.append(membership.getName() + "(" + membership.getOccupation() + ") " + membership.getOccurMonth() + "\n");
		}
		
		model.addAttribute("memo", memo.toString());
		model.addAttribute("paid", paid);
		model.addAttribute("unpaid", unpaid);
		return "membership/list";
	}
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String goMembershipForm(Model model) {
		return "membership/form";
	}
	
	@RequestMapping(value = "form", method = RequestMethod.POST)
	public String addMemberships(@RequestParam("name") String name,
			@RequestParam("is_regular") boolean isRegular,
			@RequestParam("occur_months") String occurMonths, Model model) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String currentDate = sdf.format(new Date());
		
		Member member = memberService.getMemberByName(name);
		
		int amount = 0;
		
		if(isRegular) {
			if(!StringUtils.isEmpty(occurMonths)){
				for(String occurMonth : occurMonths.split(",")){
					membershipService.addMembership(member.getId(), currentDate.substring(0, 4) + String.format("%02d", Integer.parseInt(occurMonth)));
					if("W".equals(member.getOccupation())) amount += 20000;
					else amount += 10000;
				}
			}
		}
		else {
			membershipService.addMembership(member.getId(), currentDate.substring(0, 4));
			amount = 50000;
		}
		
		Transaction transaction = new Transaction();
		transaction.setStatus("I");
		transaction.setTitle(member.getName() + " 회비납부");
		transaction.setAmount(amount);
		transaction.setOccurDate(currentDate);
		transactionService.addTransaction(transaction);	
		
		this.addFlashMessage(new FlashMessage("success", "정상적으로 등록되었습니다."));
		
		return "redirect:form";
	}
	
}
