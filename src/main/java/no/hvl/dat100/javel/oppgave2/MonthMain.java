package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DayPowerData;
import no.hvl.dat100.javel.oppgave1.DailyPower;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MonthMain {
    public static void main(String[] args) {

        // test data
        double[][] power_prices_month = MonthPowerData.powerprices_month;

        double[][] power_usage_month = MonthPowerData.powerusage_month;

        System.out.println("==============");
        System.out.println("OPPGAVE 2");
        System.out.println("==============");

        System.out.println("c) Test computePowerUsage");
        System.out.println(MonthlyPower.computePowerUsage(power_usage_month));
        System.out.println("d) Test exceedThreshold");
        System.out.println(MonthlyPower.exceedThreshold(power_usage_month, 100.0));
        System.out.println("e) Test computeSpotPrice");
        System.out.println(MonthlyPower.computeSpotPrice(power_usage_month, power_prices_month));
        System.out.println("f) Test computePowerSupport");
        System.out.println(MonthlyPower.computePowerSupport(power_usage_month, power_prices_month));




        /*
        TODO

         Write code that tests the methods you implement in the MonthlyPower class
         Remember to teste the methods as you implement them
         Remember to also to check that you get the expected results
         */

    }
}