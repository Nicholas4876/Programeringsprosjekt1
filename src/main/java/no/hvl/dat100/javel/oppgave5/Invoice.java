package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;

import java.util.Arrays;

public class Invoice {

    private Customer c; // customer associated with this invoice
    private String month; // month that the invoice covers
    private double[][] usage; // power usage this month (per day and per hour)
    private double[][] prices; // power prices for this month

    private double amount; // power price for this month


    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) {
     for (int i = 0; i < usage.length; i++) {
            if (usage[i].length != 24) {
                throw new IllegalArgumentException("Each day must have 24 hours of usage data.");
            }
        }
        for (int i = 0; i < power_prices.length; i++) {
            if (power_prices[i].length != 24) {
                throw new IllegalArgumentException("Each day must have 24 hours of price data.");
            }
        }

        this.c = c;
        this.month = month;
        this.usage = usage;
        this.prices = power_prices;
    }

    public void computeAmount() {
        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {
                amount += usage[i][j] * prices[i][j];
            }
        }
        

    }

    public void printInvoice() {

        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {


                
            }
        }

    }
}
