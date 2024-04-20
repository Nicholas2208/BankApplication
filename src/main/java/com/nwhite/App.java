package com.nwhite;

import com.nwhite.credit.AccumulatorCreditCard;
import com.nwhite.credit.BonusCreditCard;
import com.nwhite.credit.CashbackCreditCard;
import com.nwhite.debit.AccumulatorDebitCard;
import com.nwhite.debit.BonusDebitCard;
import com.nwhite.debit.CashbackDebitCard;

import java.math.BigDecimal;

public class App {
    public static void main( String[] args ) {
        BankCard bonusDebitCard = new BonusDebitCard(BigDecimal.valueOf(5000));
        bonusDebitCard.deposit(BigDecimal.valueOf(5000));
        bonusDebitCard.withdraw(BigDecimal.valueOf(6000));
        bonusDebitCard.getFundsInfo();
        System.out.println("-------------------------------------");

        BankCard cashbackDebitCard = new CashbackDebitCard(BigDecimal.valueOf(10000));
        cashbackDebitCard.withdraw(BigDecimal.valueOf(7000));
        cashbackDebitCard.getFundsInfo();
        System.out.println("-------------------------------------");

        BankCard accumulatorDebitCard = new AccumulatorDebitCard(BigDecimal.valueOf(5000));
        accumulatorDebitCard.deposit(BigDecimal.valueOf(5000));
        accumulatorDebitCard.getFundsInfo();
        System.out.println("-------------------------------------");

        BankCard bonusCreditCard = new BonusCreditCard(BigDecimal.valueOf(5000));
        bonusCreditCard.deposit(BigDecimal.valueOf(5000));
        bonusCreditCard.withdraw(BigDecimal.valueOf(6000));
        bonusCreditCard.getFundsInfo();
        System.out.println("-------------------------------------");

        BankCard cashbackCreditCard = new CashbackCreditCard(BigDecimal.valueOf(5000));
        cashbackCreditCard.deposit(BigDecimal.valueOf(10000));
        cashbackCreditCard.withdraw(BigDecimal.valueOf(8000));
        cashbackCreditCard.getFundsInfo();
        System.out.println("-------------------------------------");

        BankCard accumulatorCreditCard = new AccumulatorCreditCard(BigDecimal.valueOf(5000));
        accumulatorCreditCard.deposit(BigDecimal.valueOf(5000));
        accumulatorCreditCard.getFundsInfo();
        System.out.println("-------------------------------------");
    }
}
