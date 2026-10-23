package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthlyPower {

    // a) print power usage for a month
    public static void print_PowerUsage(double[][] usage) {

        System.out.print("Månedens strøm forbruk: ");
    for (int i = 0; i<usage.length; i++) {
        for (int j = 0; j<usage[i].length; j++) {
            System.out.print(usage[i][j] + " kWh, ");
            }
        }
    }

    // b) print power prices for a month
    public static void print_PowerPrices(double[][] prices) {

    System.out.print("Månedens priser: ");
    for (int i = 0; i<prices.length; i++) {
        for (int j = 0; j<prices[i].length; j++) {
            System.out.print(prices[i][j] + " kr/kWh, ");
            }
        }
    }

    // c) compute total power usage for a month
    public static double computePowerUsage(double[][] usage) {
        double sum = 0;

        for (int i = 0; i<usage.length; i++) {
            for (int j = 0; j<usage[i].length; j++) {
                sum = sum + usage[i][j];
            }
        }
        return sum;
    }

    // d) determine whether a given threshold in powerusage for the month has been exceeded
    public static boolean exceedThreshold(double[][] powerusage, double threshold) {
        return computePowerUsage(powerusage) > threshold;
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

        for (int i = 0; i < usage.length; i++) {
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
