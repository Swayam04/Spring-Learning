package org.example.entities;

public class Payment {
    private double amount;
    private String bankAccountNumber;
    private String bankName;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "Amount: " + amount + ", Bank Account Number: " + bankAccountNumber + ", Bank Name: " + bankName;
    }
}
