package com.njw0619.fcsdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njw0619.fcsdm.mapper.TransactionMapper;
import com.njw0619.fcsdm.model.Transaction;

@Service
public class TransactionService {
	
	@Autowired
	TransactionMapper transactionMapper;

	public List<Transaction> getTransactions(String startDate, String endDate){
		return transactionMapper.selectTransactions(startDate, endDate);
	}
	
	public int addTransaction(Transaction transaction){
		return transactionMapper.insertTransaction(transaction);
	}
}
