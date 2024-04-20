package com.nwhite.debit;

import com.nwhite.BankCard;
import com.nwhite.exception.InsufficientFundsException;

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
    public Boolean withdraw(BigDecimal amount) {
        try {
            if (balance.compareTo(amount) >= 0) {
                balance = balance.subtract(amount);
                return true;
            } else {
                throw new InsufficientFundsException("Недостаточно средств на балансе");
            }
        } catch (InsufficientFundsException e) {
            return false;
        }
    }
}
