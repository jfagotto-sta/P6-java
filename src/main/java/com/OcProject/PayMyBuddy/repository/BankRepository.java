package com.OcProject.PayMyBuddy.repository;

import com.OcProject.PayMyBuddy.model.Bank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Integer> {

    @Query("UPDATE Bank SET feesamount = feesamount + amount")
    public void addFeesAmount(@Param("amount")double amount);

}
