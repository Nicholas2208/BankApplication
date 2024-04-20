package com.nwhite.credit;

import java.math.BigDecimal;

public final class AccumulatorCreditCard extends CreditCard {
    private BigDecimal accumulator;

    public AccumulatorCreditCard(BigDecimal initialCreditLimit) {
        super(initialCreditLimit);
        this.accumulator = BigDecimal.ZERO;
    }

    @Override
    protected void handleBonus(BigDecimal amount) {
        accumulator = accumulator.add(amount.multiply(BigDecimal.valueOf(0.00005)));
    }

    @Override
    public void deposit(BigDecimal amount) {
        super.deposit(amount);
        handleBonus(amount);
    }

    @Override
    public void getFundsInfo() {
        super.getFundsInfo();
        System.out.println("Накопление: " + this.accumulator);
    }

    public BigDecimal getAccumulator() {
        return this.accumulator;
    }
}
