package com.nwhite;

import java.math.BigDecimal;

public class BonusCreditCard extends CreditCard {
    private BigDecimal bonus;

    public BonusCreditCard(BigDecimal initialCreditLimit) {
        super(initialCreditLimit);
        this.bonus = BigDecimal.ZERO;
    }

    @Override
    public Boolean withdraw(BigDecimal amount) {
        if (amount.compareTo(balance) <= 0) {
            balance = balance.subtract(amount);
            bonus = bonus.add(amount.multiply(BigDecimal.valueOf(0.01)));
        } else if (amount.compareTo(balance.add(creditLimit)) <= 0) {
            BigDecimal remainingAmount = amount.subtract(balance);
            balance = BigDecimal.ZERO;
            creditLimit = creditLimit.subtract(remainingAmount);
        } else {
            return false;
        }
        return true;
    }
}
