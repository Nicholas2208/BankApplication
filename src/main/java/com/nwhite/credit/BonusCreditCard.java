package com.nwhite.credit;

import java.math.BigDecimal;

public final class BonusCreditCard extends CreditCard {
    private BigDecimal bonus;

    public BonusCreditCard(BigDecimal initialCreditLimit) {
        super(initialCreditLimit);
        this.bonus = BigDecimal.ZERO;
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
        bonus = bonus.add(amount.multiply(BigDecimal.valueOf(0.01)));
    }

    public BigDecimal getBonus() {
        return this.bonus;
    }

    @Override
    public void getFundsInfo() {
        super.getFundsInfo();
        System.out.println("Бонус: " + this.bonus);
    }
}
