package com.nwhite.debit;

import java.math.BigDecimal;

public final class AccumulatorDebitCard extends DebitCard {
    private BigDecimal accumulator;

    public AccumulatorDebitCard(BigDecimal balance) {
        super(balance);
        this.accumulator = BigDecimal.ZERO;
    }

    @Override
    public void deposit(BigDecimal amount) {
        super.deposit(amount);
        handleBonus(amount);
    }

    /**
     * Накопление в размере 0.005% от суммы пополнений.
     *
     * @param amount сумма пополнения
     */
    @Override
    protected void handleBonus(BigDecimal amount) {
        accumulator = accumulator.add(amount.multiply(BigDecimal.valueOf(0.00005)));
    }

    @Override
    public void getFundsInfo() {
        super.getFundsInfo();
        System.out.println("Накопитель: " + this.getAccumulator());
    }

    public BigDecimal getAccumulator() {
        return accumulator;
    }
}
