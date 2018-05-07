package com.njw0619.fcsdm.mapper;

import com.njw0619.fcsdm.model.Membership;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Peter on 2018-02-06.
 */
@Repository
public interface MembershipMapper {    
    public List<Membership> selectMemberships();
    public int insertMembership(@Param("memberId") int memberId, @Param("occurMonth") String occurMonth);
}
