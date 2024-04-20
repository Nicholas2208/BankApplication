package com.nwhite.debit;

import com.nwhite.credit.BonusCreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static  org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DebitCardTest {
    BonusDebitCard bonusDebitCard;
    CashbackDebitCard cashbackDebitCard;
    AccumulatorDebitCard accumulatorDebitCard;
    BonusCreditCard bonusCreditCard;

    @BeforeEach
    public void setUp() {
        bonusDebitCard = new BonusDebitCard(BigDecimal.valueOf(5000));
        cashbackDebitCard = new CashbackDebitCard(BigDecimal.valueOf(5000));
        accumulatorDebitCard = new AccumulatorDebitCard(BigDecimal.valueOf(5000));
    }

    @DisplayName("JUnit test for deposit operation")
    @Test
    public void givenDebitCardObject_whenDeposit_thenReturnTrue () {
        // given

        // when
        bonusDebitCard.deposit(BigDecimal.valueOf(5000));
        cashbackDebitCard.deposit(BigDecimal.valueOf(5000));
        accumulatorDebitCard.deposit(BigDecimal.valueOf(5000));

        // then
        assertThat(bonusDebitCard.getBalance()).isEqualTo(BigDecimal.valueOf(10000));
        assertThat(cashbackDebitCard.getBalance()).isEqualTo(BigDecimal.valueOf(10000));
        assertThat(accumulatorDebitCard.getBalance()).isEqualTo(BigDecimal.valueOf(10000));
    }

    @DisplayName("JUnit test for bonus debit card feature")
    @Test
    public void givenBonusDebitCardObject_whenWithdrawDeposit_thenBonus () {
        // given

        // when
        bonusDebitCard.withdraw(BigDecimal.valueOf(3000));
        cashbackDebitCard.withdraw(BigDecimal.valueOf(3000));
        accumulatorDebitCard.deposit(BigDecimal.valueOf(10000));

        // then
        assertThat(bonusDebitCard.getBalance()).isEqualTo(BigDecimal.valueOf(2000));
        assertThat(bonusDebitCard.getBonus().setScale(0)).isEqualTo(BigDecimal.valueOf(30));

        assertThat(cashbackDebitCard.getBalance()).isEqualTo(BigDecimal.valueOf(2000));

        assertThat(accumulatorDebitCard.getAccumulator().setScale(1)).isEqualTo(BigDecimal.valueOf(0.5));
    }

    @DisplayName("JUnit test for cashback debit card feature")
    @Test
    public void givenCashbackDebitCardObject_whenDeposit_thenCashback () {
        // given
        cashbackDebitCard.deposit(BigDecimal.valueOf(5000));

        // when
        cashbackDebitCard.withdraw(BigDecimal.valueOf(6000));

        // then
        assertThat(cashbackDebitCard.getCashback().setScale(0)).isEqualTo(BigDecimal.valueOf(300));
    }
}
