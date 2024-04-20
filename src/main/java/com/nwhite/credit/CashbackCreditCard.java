package com.nwhite.credit;

import java.math.BigDecimal;

public final class CashbackCreditCard extends CreditCard {
    private BigDecimal cashback;

    public CashbackCreditCard(BigDecimal initialCreditLimit) {
        super(initialCreditLimit);
        this.cashback = BigDecimal.ZERO;
    }

    @Override
    public Boolean withdraw(BigDecimal amount) {
        if (super.withdraw(amount)) {
            handleBonus(amount);
            return true;
        } else {
            throw new RuntimeException("Недостаточно средств на балансе");
        }
    }

    @Override
    protected void handleBonus(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(5000)) > 0) {
            cashback = cashback.add(amount.multiply(BigDecimal.valueOf(0.05)));
        }
    }

    @Override
    public void getFundsInfo() {
        super.getFundsInfo();
        System.out.println("Кэшбэк: " + this.cashback);
    }

    public BigDecimal getCashback() {
        return cashback;
    }
}
