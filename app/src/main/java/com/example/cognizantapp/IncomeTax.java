package com.example.cognizantapp;

 public class IncomeTax {

   public int calculateTax(int income){
        return income /10;
    }

    public int calculateTax(int income, int luxurySpending){

        int tax = income /10;
        int luxuryTax = income /100;
        return tax + luxuryTax;
    }

}
