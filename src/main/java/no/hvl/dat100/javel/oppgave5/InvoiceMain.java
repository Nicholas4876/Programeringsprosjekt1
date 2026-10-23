package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.CustomerMain;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import no.hvl.dat100.javel.oppgave2.MonthPowerData;
import no.hvl.dat100.javel.oppgave4.Customers;
import no.hvl.dat100.javel.oppgave4.CustomersMain;

public class InvoiceMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 5");
        System.out.println("==============");
        System.out.println();


        // Invoice.computeAmount test
        Customer nicholas = new Customer(
                "Nicholas", "nicholas@example.com", 1, PowerAgreementType.NORGESPRICE);
        Customer sara = new Customer(
                "Sara", "sara@example.com", 2, PowerAgreementType.SPOTPRICE);
        Customer amir = new Customer(
                "Amir", "amir@example.com", 3, PowerAgreementType.POWERSUPPORT);

        Invoice fakt1 = new Invoice(nicholas, "october", MonthPowerData.powerusage_month, MonthPowerData.powerprices_month);
        fakt1.computeAmount();
        System.out.println("Fakturaen til " + nicholas.getName() + " er på " + fakt1.getAmount() + " kr.");

        Invoice fakt2 = new Invoice(sara, "october", MonthPowerData.powerusage_month, MonthPowerData.powerprices_month);
        fakt2.computeAmount();
        System.out.println("Fakturaen til " + sara.getName() + " er på " + fakt2.getAmount() + " kr.");

        Invoice fakt3 = new Invoice(amir, "october", MonthPowerData.powerusage_month, MonthPowerData.powerprices_month);
        fakt3.computeAmount();
        System.out.println("Fakturaen til " + amir.getName() + " er på " + fakt3.getAmount() + " kr.");

    }
}
