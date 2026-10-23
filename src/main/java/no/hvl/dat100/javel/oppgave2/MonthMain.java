package no.hvl.dat100.javel.oppgave2;

import java.util.Locale;

public class MonthMain {
    public static void main(String[] args) {

        // test data
        double[][] power_prices_month = MonthPowerData.powerprices_month;

        double[][] power_usage_month = MonthPowerData.powerusage_month;

        System.out.println("==============");
        System.out.println("OPPGAVE 2");
        System.out.println("==============");
        System.out.println();

        MonthlyPower.print_PowerUsage(power_usage_month);
        System.out.println();
        MonthlyPower.print_PowerPrices(power_prices_month);

        System.out.println();
        double sum = MonthlyPower.computePowerUsage(power_usage_month);
        System.out.printf("Totalt strømforbruk: %.2f kWh%n", sum);
        System.out.println();

        boolean overskreder = MonthlyPower.exceedThreshold(power_usage_month, 5000);
        System.out.print(overskreder);
        /*
        TODO

         Write code that tests the methods you implement in the MonthlyPower class
         Remember to teste the methods as you implement them
         Remember to also to check that you get the expected results
         */

    }
}