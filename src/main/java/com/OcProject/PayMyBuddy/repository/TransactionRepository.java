package com.OcProject.PayMyBuddy.repository;

import com.OcProject.PayMyBuddy.model.Contact;
import com.OcProject.PayMyBuddy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.OcProject.PayMyBuddy.model.Transaction;

import java.util.List;
import java.util.Optional;




@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>{



    @Query(nativeQuery = true, value = "SELECT * FROM transactions  WHERE (idSender = :mail1 or idRecipient =:mail1) order by dateTransaction desc LIMIT 10")
    public List<Transaction> findTransactionByMail(@Param("mail1") String mail1);



    }


