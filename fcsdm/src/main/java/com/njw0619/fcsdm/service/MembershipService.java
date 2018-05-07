package com.njw0619.fcsdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njw0619.fcsdm.mapper.MembershipMapper;
import com.njw0619.fcsdm.model.Membership;

@Service
public class MembershipService {
	
	@Autowired
	MembershipMapper membershipMapper;

	public List<Membership> getMemberships(){
		return membershipMapper.selectMemberships();
	}
	
	public int addMembership(int memberId, String occurMonth){
		return membershipMapper.insertMembership(memberId, occurMonth);
	}
}
