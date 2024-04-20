package com.nwhite;

import java.math.BigDecimal;

public class BonusDebitCard extends DebitCard {
    private BigDecimal bonus;

    public BonusDebitCard(BigDecimal balance) {
        super(balance);
        this.bonus = BigDecimal.ZERO;
    }

    @Override
    public Boolean withdraw(BigDecimal amount) {
        if (amount.compareTo(balance) >= 0) {
            balance = balance.subtract(amount);
            bonus = bonus.add(amount.multiply(BigDecimal.valueOf(0.01)));
            return true;
        } else {
            return false;
        }
    }
}
