package com.OcProject.PayMyBuddy.services;

import com.OcProject.PayMyBuddy.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void updateBankFeesAmount(double amount) {
        bankRepository.addFeesAmount(amount);
    }
}
