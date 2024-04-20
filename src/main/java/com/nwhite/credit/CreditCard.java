package com.nwhite.credit;

import com.nwhite.BankCard;

import java.math.BigDecimal;

public abstract class CreditCard extends BankCard {
    protected BigDecimal creditLimit;
    protected final BigDecimal initialCreditLimit;

    public CreditCard(BigDecimal initialCreditLimit) {
        super(BigDecimal.ZERO);
        this.initialCreditLimit = this.creditLimit = initialCreditLimit;
    }

    @Override
    public Boolean withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
        } else if (amount.compareTo(balance.add(creditLimit)) <= 0) {
            BigDecimal remainingAmount = amount.subtract(balance);
            balance = BigDecimal.ZERO;
            creditLimit = creditLimit.subtract(remainingAmount);
        } else {
            throw new RuntimeException("Недостаточно средств на балансе");
        }
        return true;
    }

    @Override
    public void deposit(BigDecimal amount) {
        if (creditLimit.compareTo(initialCreditLimit) == 0) {
            balance = balance.add(amount);
        } else {
            BigDecimal difference = initialCreditLimit.subtract(creditLimit);
            if (amount.compareTo(difference) >= 0) {
                creditLimit = creditLimit.add(difference);
                balance = balance.add(amount.subtract(difference));
            } else {
                creditLimit = creditLimit.add(amount);
            }
        }
    }

    @Override
    public void getFundsInfo() {
        super.getFundsInfo();
        System.out.println("Кредитный лимит: " + creditLimit);
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }
}
