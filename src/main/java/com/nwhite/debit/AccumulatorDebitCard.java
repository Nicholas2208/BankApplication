package com.nwhite;

import java.math.BigDecimal;

public class AccumulatorDebitCard extends DebitCard {
    private BigDecimal accumulator;

    public AccumulatorDebitCard(BigDecimal balance) {
        super(balance);
        this.accumulator = BigDecimal.ZERO;
    }

    @Override
    public Boolean withdraw(BigDecimal amount) {
        return null;
    }

    @Override
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        accumulator = accumulator.add(amount.multiply(BigDecimal.valueOf(0.00005)));
    }

    public BigDecimal getAccumulator() {
        return accumulator;
    }
}
