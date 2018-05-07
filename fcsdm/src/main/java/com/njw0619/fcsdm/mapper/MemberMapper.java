package com.njw0619.fcsdm.mapper;

import com.njw0619.fcsdm.model.Member;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Peter on 2018-02-06.
 */
@Repository
public interface MemberMapper {
	public List<Member> selectMembers();
    public Member selectMember(@Param("id") int id);
    public Member selectMemberByName(@Param("name") String name);
}
