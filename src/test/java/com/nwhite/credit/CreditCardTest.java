package com.nwhite.credit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreditCardTest {
    BonusCreditCard bonusCreditCard;
    CashbackCreditCard cashbackCreditCard;
    AccumulatorCreditCard accumulatorCreditCard;

    @BeforeEach
    public void setUp() {
        bonusCreditCard = new BonusCreditCard(BigDecimal.valueOf(10000));
        cashbackCreditCard = new CashbackCreditCard(BigDecimal.valueOf(10000));
        accumulatorCreditCard = new AccumulatorCreditCard(BigDecimal.valueOf(10000));
    }

    @DisplayName("JUnit test for bonus credit card operations")
    @Test
    public void bonusCreditCardTest () {
        assertThat(bonusCreditCard.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(bonusCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(10000));

        bonusCreditCard.deposit(BigDecimal.valueOf(5000));

        assertThat(bonusCreditCard.getBalance()).isEqualTo(BigDecimal.valueOf(5000));
        assertThat(bonusCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(10000));

        bonusCreditCard.withdraw(BigDecimal.valueOf(5000));

        assertThat(bonusCreditCard.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(bonusCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(10000));

        bonusCreditCard.withdraw(BigDecimal.valueOf(3000));

        assertThat(bonusCreditCard.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(bonusCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(7000));

        bonusCreditCard.deposit(BigDecimal.valueOf(2000));

        assertThat(bonusCreditCard.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(bonusCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(9000));

        bonusCreditCard.deposit(BigDecimal.valueOf(2000));

        assertThat(bonusCreditCard.getBalance()).isEqualTo(BigDecimal.valueOf(1000));
        assertThat(bonusCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(10000));
    }

    @DisplayName("JUnit test for cashback credit card operations")
    @Test
    public void cashbackCreditCardTest () {
        assertThat(cashbackCreditCard.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(cashbackCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(10000));

        cashbackCreditCard.deposit(BigDecimal.valueOf(5000));

        assertThat(cashbackCreditCard.getBalance()).isEqualTo(BigDecimal.valueOf(5000));
        assertThat(cashbackCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(10000));

        cashbackCreditCard.withdraw(BigDecimal.valueOf(5000));

        assertThat(cashbackCreditCard.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(cashbackCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(10000));

        cashbackCreditCard.withdraw(BigDecimal.valueOf(3000));

        assertThat(cashbackCreditCard.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(cashbackCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(7000));

        cashbackCreditCard.deposit(BigDecimal.valueOf(2000));

        assertThat(cashbackCreditCard.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(cashbackCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(9000));

        cashbackCreditCard.deposit(BigDecimal.valueOf(2000));

        assertThat(cashbackCreditCard.getBalance()).isEqualTo(BigDecimal.valueOf(1000));
        assertThat(cashbackCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(10000));
    }

    @DisplayName("JUnit test for accumulator credit card operations")
    @Test
    public void accumulatorCreditCardTest () {
        assertThat(accumulatorCreditCard.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(accumulatorCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(10000));

        accumulatorCreditCard.deposit(BigDecimal.valueOf(5000));

        assertThat(accumulatorCreditCard.getBalance()).isEqualTo(BigDecimal.valueOf(5000));
        assertThat(accumulatorCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(10000));

        accumulatorCreditCard.withdraw(BigDecimal.valueOf(5000));

        assertThat(accumulatorCreditCard.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(accumulatorCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(10000));

        accumulatorCreditCard.withdraw(BigDecimal.valueOf(3000));

        assertThat(accumulatorCreditCard.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(accumulatorCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(7000));

        accumulatorCreditCard.deposit(BigDecimal.valueOf(2000));

        assertThat(accumulatorCreditCard.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(accumulatorCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(9000));

        accumulatorCreditCard.deposit(BigDecimal.valueOf(2000));

        assertThat(accumulatorCreditCard.getBalance()).isEqualTo(BigDecimal.valueOf(1000));
        assertThat(accumulatorCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(10000));
    }

    @DisplayName("JUnit test for bonus credit card feature")
    @Test
    public void givenBonusCreditCardObject_whenWithdrawDeposit_thenBonus () {
        // given

        // when
        bonusCreditCard.withdraw(BigDecimal.valueOf(3000));
        cashbackCreditCard.withdraw(BigDecimal.valueOf(3000));
        accumulatorCreditCard.deposit(BigDecimal.valueOf(5000));

        // then
        assertThat(bonusCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(7000));
        assertThat(bonusCreditCard.getBonus().setScale(0)).isEqualTo(BigDecimal.valueOf(30));

        assertThat(cashbackCreditCard.getCreditLimit()).isEqualTo(BigDecimal.valueOf(7000));

        assertThat(accumulatorCreditCard.getAccumulator().setScale(2)).isEqualTo(BigDecimal.valueOf(0.25));
    }

    @DisplayName("JUnit test for cashback credit card feature")
    @Test
    public void givenCashbackCreditCardObject_whenWithdraw_thenCashback () {
        // given

        // when
        cashbackCreditCard.withdraw(BigDecimal.valueOf(10000));

        // then
        assertThat(cashbackCreditCard.getCashback().setScale(0)).isEqualTo(BigDecimal.valueOf(500));
    }
}
