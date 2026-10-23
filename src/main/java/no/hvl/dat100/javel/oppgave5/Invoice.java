package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave1.DailyPower;
import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

import java.util.Locale;

public class Invoice {

    private Customer c; 
    private String month; 
    private double[][] usage; 
    private double[][] prices; 

    private double amount; 


    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) {
        this.c = c;
        this.month = month;
        this.usage = usage;
        this.prices = power_prices;
        this.amount = 0;

    }

    public void computeAmount() {

        switch (c.getAgreement()) {

            case NORGESPRICE:
                amount = MonthlyPower.computeNorgesPrice(usage);
                break;

            case POWERSUPPORT:
                amount = MonthlyPower.computePowerSupport(usage, prices);
                break;

            default:
                amount = MonthlyPower.computeSpotPrice(usage, prices);
        }

    }

    public double getAmount() {
        return amount;
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
