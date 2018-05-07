package com.njw0619.fcsdm.mapper;

import com.njw0619.fcsdm.model.Transaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Peter on 2018-02-06.
 */
@Repository
public interface TransactionMapper {    
    public List<Transaction> selectTransactions(@Param("startDate") String startDate, @Param("endDate") String endDate);
    public int insertTransaction(Transaction transaction);
}
