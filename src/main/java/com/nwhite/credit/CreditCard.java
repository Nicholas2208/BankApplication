package com.nwhite;

import java.math.BigDecimal;

public class CreditCard extends BankCard {
    protected BigDecimal creditLimit;
    private final BigDecimal initialCreditLimit;

    public CreditCard(BigDecimal initialCreditLimit) {
        super(BigDecimal.ZERO);
        this.initialCreditLimit = this.creditLimit = initialCreditLimit;
    }

    @Override
    public Boolean withdraw(BigDecimal amount) {
        if (amount.compareTo(balance) <= 0) {
            balance = balance.subtract(amount);
        } else if (amount.compareTo(balance.add(creditLimit)) <= 0) {
            BigDecimal remainingAmount = amount.subtract(balance);
            balance = BigDecimal.ZERO;
            creditLimit = creditLimit.subtract(remainingAmount);
        } else {
            return false;
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
        System.out.println("Баланс: " + balance);
        System.out.println("Кредитный лимит: " + creditLimit);
    }
}
