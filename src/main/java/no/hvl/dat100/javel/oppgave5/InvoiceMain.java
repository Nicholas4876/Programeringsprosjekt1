package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import no.hvl.dat100.javel.oppgave2.MonthPowerData;

public class InvoiceMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 5");
        System.out.println("==============");
        System.out.println();

        Customer customer1 = new Customer(
                "Charlie Rose", "charlie@example.com", 1003,
                PowerAgreementType.POWERSUPPORT);
        Customer customer2 = new Customer(
                "Diana Prince", "diana@example.com", 1004,
                PowerAgreementType.NORGESPRICE);
        Customer customer3 = new Customer(
                "Ethan Hunt", "ethan@example.com", 1005,
                PowerAgreementType.SPOTPRICE);

        Invoice[] invoices = {
                new Invoice(customer1, "January",
                        CustomerPowerUsageData.usage_month_customer1,
                        MonthPowerData.powerprices_month),
                new Invoice(customer2, "January",
                        CustomerPowerUsageData.usage_month_customer2,
                        MonthPowerData.powerprices_month),
                new Invoice(customer3, "January",
                        CustomerPowerUsageData.usage_month_customer3,
                        MonthPowerData.powerprices_month)
        };

        Invoices.processInvoices(invoices);

    }
}
