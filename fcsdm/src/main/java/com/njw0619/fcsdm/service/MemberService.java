package com.njw0619.fcsdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njw0619.fcsdm.mapper.MemberMapper;
import com.njw0619.fcsdm.model.Member;
import com.njw0619.fcsdm.model.Membership;

@Service
public class MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	public List<Member> getMembers(){
		return memberMapper.selectMembers();
	}
	
	public Member getMember(int id) {
		return memberMapper.selectMember(id);
	}
	
	public Member getMemberByName(String name) {
		return memberMapper.selectMemberByName(name);
	}
	
}
