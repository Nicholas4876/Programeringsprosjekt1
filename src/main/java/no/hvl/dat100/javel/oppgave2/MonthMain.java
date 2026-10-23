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
        System.out.println("a) Test print_PowerUsage");
        MonthlyPower.print_PowerUsage(power_usage_month);
        System.out.println("b) Test print_PowerPrices");
        MonthlyPower.print_PowerPrices(power_prices_month);
        System.out.println("c) Test computePowerUsage");
        System.out.printf(Locale.ROOT, "%.2f%n", MonthlyPower.computePowerUsage(power_usage_month));
        System.out.println("d) Test exceedThreshold (> 100 kWh)");
        System.out.println(MonthlyPower.exceedThreshold(power_usage_month, 100.0));
        System.out.println("Test exceedThreshold (> 1000 kWh)");
        System.out.println(MonthlyPower.exceedThreshold(power_usage_month, 1000.0));
        System.out.println("e) Test computeSpotPrice");
        System.out.printf(Locale.ROOT, "%.2f%n",
                MonthlyPower.computeSpotPrice(power_usage_month, power_prices_month));
        System.out.println("f) Test computePowerSupport");
        System.out.printf(Locale.ROOT, "%.2f%n",
                MonthlyPower.computePowerSupport(power_usage_month, power_prices_month));
        System.out.println("g) Test computeNorgesPrice");
        System.out.printf(Locale.ROOT, "%.2f%n",
                MonthlyPower.computeNorgesPrice(power_usage_month));

    }
}