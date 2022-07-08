package com.example.cognizantapp;

public class Gst extends IncomeTax{

    @Override
    public int calculateTax(int income) {
        int oldTax = super.calculateTax(income);
        int newTax = income/100;
        return oldTax + newTax;
    }
}
