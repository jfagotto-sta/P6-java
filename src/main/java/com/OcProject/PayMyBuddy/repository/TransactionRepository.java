package com.OcProject.PayMyBuddy.repository;

import com.OcProject.PayMyBuddy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OcProject.PayMyBuddy.model.Transaction;

import java.util.Optional;




@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>{



    }


