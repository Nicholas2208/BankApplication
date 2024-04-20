package com.nwhite;

import java.math.BigDecimal;

public abstract class BankCard {
    protected BigDecimal balance;

    public BankCard(BigDecimal balance) {
        this.balance = balance;
    }

    public void getFundsInfo() {
        System.out.println("Баланс: " + this.balance);
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public abstract Boolean withdraw(BigDecimal amount);

    public abstract void deposit(BigDecimal amount);

    protected abstract void handleBonus(BigDecimal amount);
}
