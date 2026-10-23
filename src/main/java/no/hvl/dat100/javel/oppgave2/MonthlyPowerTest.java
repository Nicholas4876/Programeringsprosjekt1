package no.hvl.dat100.javel.oppgave2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class MonthlyPowerTest {

    // Merk: koden er KI-generert.

    public static void main(String[] args) {
        testPrintPowerUsage();
        testPrintPowerPrices();

        // 1.5 + 2.0 + 0.5 + 3.0 + 0.0 + 4.0 = 11.0
        testSum("Flere dager", new double[][] {{1.5, 2.0, 0.5}, {3.0, 0.0, 4.0}}, 11.0);
        testSum("En verdi", new double[][] {{2.75}}, 2.75);
        testSum("Bare nuller", new double[][] {{0.0, 0.0}, {0.0, 0.0}}, 0.0);
        testSum("Tom tabell", new double[][] {}, 0.0);
        testSum("Ulike radlengder og tom rad", new double[][] {{1.0, 2.0}, {}, {4.0}}, 7.0);
        testSum("Desimaltall", new double[][] {{0.1, 0.2}}, 0.3);

        System.out.println("Alle 10 tester bestått!");
    }

    private static void testPrintPowerUsage() {
        // Fang utskriften slik at vi kan sammenligne den med forventet tekst.
        PrintStream konsoll = System.out;
        ByteArrayOutputStream utskrift = new ByteArrayOutputStream();
        try (PrintStream testUt = new PrintStream(utskrift, true, StandardCharsets.UTF_8)) {
            System.setOut(testUt);
            MonthlyPower.print_PowerUsage(new double[][] {{1.5, 0.0}, {}, {2.75}});
            testTekst("Utskrift av forbruk",
                    "Månedens strøm forbruk: 1.5 kWh, 0.0 kWh, 2.75 kWh, ",
                    utskrift.toString(StandardCharsets.UTF_8));

            utskrift.reset();
            MonthlyPower.print_PowerUsage(new double[][] {});
            testTekst("Utskrift av tom forbrukstabell", "Månedens strøm forbruk: ",
                    utskrift.toString(StandardCharsets.UTF_8));
        } finally {
            // Gjenopprett vanlig utskrift, også dersom en test feiler.
            System.setOut(konsoll);
        }
    }

    private static void testPrintPowerPrices() {
        PrintStream konsoll = System.out;
        ByteArrayOutputStream utskrift = new ByteArrayOutputStream();
        try (PrintStream testUt = new PrintStream(utskrift, true, StandardCharsets.UTF_8)) {
            System.setOut(testUt);
            MonthlyPower.print_PowerPrices(new double[][] {{0.5, 0.0}, {}, {-0.25}});
            testTekst("Utskrift av priser",
                    "Månedens priser: 0.5 kr/kWh, 0.0 kr/kWh, -0.25 kr/kWh, ",
                    utskrift.toString(StandardCharsets.UTF_8));

            utskrift.reset();
            MonthlyPower.print_PowerPrices(new double[][] {});
            testTekst("Utskrift av tom pristabell", "Månedens priser: ",
                    utskrift.toString(StandardCharsets.UTF_8));
        } finally {
            System.setOut(konsoll);
        }
    }

    private static void testSum(String navn, double[][] forbruk, double forventet) {
        double faktisk = MonthlyPower.computePowerUsage(forbruk);
        // double kan ha små avrundingsfeil, så vi tillater en veldig liten forskjell.
        if (!(Math.abs(forventet - faktisk) < 0.000000001)) {
            throw new AssertionError(navn + ": forventet " + forventet + ", fikk " + faktisk);
        }
    }

    private static void testTekst(String navn, String forventet, String faktisk) {
        if (!forventet.equals(faktisk)) {
            throw new AssertionError(navn + ": forventet [" + forventet + "], fikk [" + faktisk + "]");
        }
    }
}
