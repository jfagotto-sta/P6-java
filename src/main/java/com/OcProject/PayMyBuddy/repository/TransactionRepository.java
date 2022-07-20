package com.OcProject.PayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OcProject.PayMyBuddy.model.Transaction;

import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>{

//    public Transaction deleteTransactionByID(int id);
//
//    public Transaction findById(int id);

}
