package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;

import java.util.Locale;

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
        amount = 0;

        switch (c.getAgreement()) {
            case SPOTPRICE -> amount = MonthlyPower.computeSpotPrice(usage, prices);
            case POWERSUPPORT -> amount = MonthlyPower.computeSpotPrice(usage, prices)
                    - MonthlyPower.computePowerSupport(usage, prices);
            case NORGESPRICE -> amount = MonthlyPower.computeNorgesPrice(usage);
        }
    }

    public void printInvoice() {
        double totalUsage = 0;
        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {
                totalUsage += usage[i][j];
            }
        }

        System.out.println(c);
        System.out.println();
        System.out.println("Month: " + month);
        System.out.printf(Locale.ROOT, "Usage: %12.2f kWh%n", totalUsage);
        System.out.printf(Locale.ROOT, "Amount: %12.2f NOK%n", amount);
    }
}
