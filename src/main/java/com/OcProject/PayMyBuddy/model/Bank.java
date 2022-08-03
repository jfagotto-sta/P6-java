package com.OcProject.PayMyBuddy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {

    @Id
    @Column(name="idbank")
    private int idBank;

    @Column(name="bankamount")
    private double bankReserve;

    @Column(name="feesamount")
    private double bankFeesReserve;


    public Bank() {
    }


    public Bank(int idBank, double bankReserve, double bankFeesReserve) {
        this.idBank = idBank;
        this.bankReserve = bankReserve;
        this.bankFeesReserve = bankFeesReserve;
    }

    public int getIdBank() {
        return idBank;
    }

    public void setIdBank(int idBank) {
        this.idBank = idBank;
    }

    public double getBankReserve() {
        return bankReserve;
    }

    public void setBankReserve(double bankReserve) {
        this.bankReserve = bankReserve;
    }

    public double getBankFeesReserve() {
        return bankFeesReserve;
    }

    public void setBankFeesReserve(double bankFeesReserve) {
        this.bankFeesReserve = bankFeesReserve;
    }
}
