package no.hvl.dat100.javel.oppgave1;

public class DayMain {

    public static void main(String[] args) {

        // test data
        double[] powerusage_day = DayPowerData.powerusage_day;

        double[] powerprices_day = DayPowerData.powerprices_day;

        System.out.println("==============");
        System.out.println("OPPGAVE 1");
        System.out.println("==============");
        System.out.println("a) Test printPowerPrices");
        DailyPower.printPowerPrices(powerprices_day);
        System.out.println("b) Test printPowerUsage");
        DailyPower.printPowerUsage(powerusage_day);
        System.out.println("c) Test computePowerUsage");
        System.out.println(DailyPower.computePowerUsage(powerusage_day));
        System.out.println("d) Test computeSpotPrice");
        System.out.println(DailyPower.computeSpotPrice(powerusage_day, powerprices_day));
        System.out.println("--------------");
        System.out.println("e) og f) Test computePowerSupport");
        System.out.println(DailyPower.computePowerSupport(powerusage_day, powerprices_day));
        System.out.println("--------------");
        System.out.println("g) Test computeNorgesPrice");
        System.out.println(DailyPower.computeNorgesPrice(powerusage_day));
        System.out.println("--------------");
        System.out.println("h) Test findPeakUsage");
        System.out.println(DailyPower.findPeakUsage(powerusage_day));
        System.out.println("--------------");
        System.out.println("i) Test findAvgPower");
        System.out.println(DailyPower.findAvgPower(powerusage_day));
        System.out.println("--------------");

    }
}
