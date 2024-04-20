package com.nwhite.debit;

import java.math.BigDecimal;

public final class CashbackDebitCard extends DebitCard {
    private BigDecimal cashback;

    public CashbackDebitCard(BigDecimal balance) {
        super(balance);
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

    /**
     * Увеличивает потенциальный cashback на 5% в случае, если сумма покупки больше 5000.
     *
     * @param amount сумма покупки
     */
    @Override
    protected void handleBonus(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(5000)) > 0) {
            cashback = cashback.add(amount.multiply(BigDecimal.valueOf(0.05)));
        }
    }

    @Override
    public void getFundsInfo() {
        super.getFundsInfo();
        System.out.println("Кэшбэк: " + this.getCashback());
    }

    public BigDecimal getCashback() {
        return cashback;
    }
}
