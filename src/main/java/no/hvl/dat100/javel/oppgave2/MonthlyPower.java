package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthlyPower {

    // a) print power usage for a month
    public static void print_PowerUsage(double[][] usage) {

      //TODO

    }

    // b) print power prices for a month
    public static void print_PowerPrices(double[][] prices) {

        // TODO

    }

    // c) compute total power usage for a month
    public static double computePowerUsage(double[][] usage) {

        double sum = 0;

          for (int i = 0; i < usage.length; i++){
            sum += DailyPower.computePowerUsage(usage[i]);
            System.out.println("Day " + (i + 1) + ": " + DailyPower.computePowerUsage(usage[i]) + " kWh");
        }

        return sum;
    }

    // d) determine whether a given threshold in powerusage for the month has been exceeded
    public static boolean exceedThreshold(double[][] powerusage, double threshold) {

        boolean exceeded = false;
        double usage = 0;

        for (int i = 0; i < powerusage.length; i++) {
            usage += DailyPower.computePowerUsage(powerusage[i]);
        }
        if (usage > threshold) {
            exceeded = true;
        }

        return exceeded;
    }

    // e) compute spot price
    public static double computeSpotPrice(double[][] usage, double[][] prices) {

        double price = 0;

        for (int i = 0; i < usage.length; i++) {
            price += DailyPower.computeSpotPrice(usage[i], prices[i]);
        }

        return price;
    }

    // f) power support for the month
    public static double computePowerSupport(double[][] usage, double[][] prices) {

        double support = 0;
        
        for ( int i=0; i<usage.length;i++) {
            support += DailyPower.computePowerSupport(usage[i], prices[i]);
        }
        

        return support;
    }

    // g) Norgesprice for the month
    public static double computeNorgesPrice(double[][] usage) {

        double price = 0;

        for (int i = 0; i < usage.length; i++) {
            price += DailyPower.computeNorgesPrice(usage[i]);
        }

        return price;
    }

}
