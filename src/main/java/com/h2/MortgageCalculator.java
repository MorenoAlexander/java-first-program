package com.h2;

public class MortgageCalculator {
    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    private int getNumberOfPayments() {
        return termInYears * 12;
    }

    private float getMonthlyInterestRate() {
        float interestRate = annualRate / 100;
        return interestRate / 12;
    }

    public double calculateMonthlyPayment() {
        float rate = getMonthlyInterestRate();
        int numberOfPayments = getNumberOfPayments();
        return this.loanAmount * (((getMonthlyInterestRate() * Math.pow(1 + rate, numberOfPayments))) / (Math.pow((1 + rate), numberOfPayments) - 1));
    }


}
