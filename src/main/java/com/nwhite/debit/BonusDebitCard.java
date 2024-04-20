package com.nwhite.debit;

import com.nwhite.exception.InsufficientFundsException;

import java.math.BigDecimal;

public final class BonusDebitCard extends DebitCard {
    private BigDecimal bonus;

    public BonusDebitCard(BigDecimal balance) {
        super(balance);
        this.bonus = BigDecimal.ZERO;
    }

    @Override
    public Boolean withdraw(BigDecimal amount) {
        if (super.withdraw(amount)) {
            handleBonus(amount);
            return true;
        } else {
            throw new InsufficientFundsException("Недостаточно средств на балансе");
        }
    }

    /**
     * Увеличивает бонусные баллы на 1% от суммы покупки.
     *
     * @param amount сумма покупки
     */
    @Override
    protected void handleBonus(BigDecimal amount) {
        bonus = bonus.add(amount.multiply(BigDecimal.valueOf(0.01)));
    }

    @Override
    public void getFundsInfo() {
        super.getFundsInfo();
        System.out.println("Бонус: " + this.getBonus());
    }

    public BigDecimal getBonus() {
        return this.bonus;
    }
}
