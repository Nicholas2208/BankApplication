package com.nwhite;

import java.math.BigDecimal;

public class CashbackDebitCard extends DebitCard {

    public CashbackDebitCard(BigDecimal balance) {
        super(balance);
    }

    @Override
    public Boolean withdraw(BigDecimal amount) {
        if (amount.compareTo(balance) >= 0) {
            balance = balance.subtract(amount);
            if (amount.compareTo(BigDecimal.valueOf(5000)) > 0) {
                balance = balance.add(amount.multiply(BigDecimal.valueOf(0.05)));
            }
            return true;
        } else {
            return false;
        }
    }
}
