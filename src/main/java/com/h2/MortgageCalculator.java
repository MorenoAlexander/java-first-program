package com.h2;


import java.text.DecimalFormat;

public class MortgageCalculator {
    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public static void main(String[] args) {
        long loamAmount = Utilities.getLongValue(args[0]);
        int termInYears = Utilities.getIntValue(args[1]);
        float annualRate = Utilities.getFloatValue(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loamAmount, termInYears, annualRate);
        calculator.calculateMonthlyPayment();
        System.out.println(calculator.toString());

    }

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

    public void calculateMonthlyPayment() {
        float rate = getMonthlyInterestRate();
        int numberOfPayments = getNumberOfPayments();
        this.monthlyPayment = this.loanAmount * (((getMonthlyInterestRate() * Math.pow(1 + rate, numberOfPayments))) / (Math.pow((1 + rate), numberOfPayments) - 1));
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "monthlyPayment: " + df.format(this.monthlyPayment);
    }


}
