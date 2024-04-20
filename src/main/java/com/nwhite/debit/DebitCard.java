package com.nwhite;

import java.math.BigDecimal;

public abstract class DebitCard extends BankCard {

    public DebitCard(BigDecimal balance) {
        super(balance);
    }


    @Override
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    @Override
    public void getFundsInfo() {
        System.out.println("Баланс: " + balance);
    }
}
