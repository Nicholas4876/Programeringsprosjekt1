package no.hvl.dat100.javel.oppgave4;

import java.util.Arrays;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class CustomersMain {

    public static void main(String[] args) {
        System.out.println("==============");
        System.out.println("OPPGAVE 4");
        System.out.println("==============");
        System.out.println();

        Customers customers = new Customers(3);
        Customer nicholas = new Customer(
                "Nicholas", "nicholas@example.com", 1, PowerAgreementType.NORGESPRICE);
        Customer sara = new Customer(
                "Sara", "sara@example.com", 2, PowerAgreementType.SPOTPRICE);
        Customer amir = new Customer(
                "Amir", "amir@example.com", 3, PowerAgreementType.POWERSUPPORT);
        Customer extra = new Customer(
                "Extra", "extra@example.com", 4, PowerAgreementType.SPOTPRICE);

        System.out.println("countNonNull on empty table: " + customers.countNonNull());
        System.out.println("getCustomer on empty table: " + customers.getCustomer(1));
        System.out.println("removeCustomer on empty table: " + customers.removeCustomer(1));
        System.out.println("getCustomers on empty table: "
                + Arrays.toString(customers.getCustomers()));

        System.out.println("\naddCustomer (Nicholas): " + customers.addCustomer(nicholas));
        System.out.println("addCustomer (Sara): " + customers.addCustomer(sara));
        System.out.println("addCustomer (Amir): " + customers.addCustomer(amir));
        System.out.println("countNonNull when full: " + customers.countNonNull());
        System.out.println("addCustomer when full: " + customers.addCustomer(extra));

        System.out.println("\ngetCustomer (id 2):\n" + customers.getCustomer(2));
        System.out.println("getCustomer (missing id 99): " + customers.getCustomer(99));

        Customer[] customerCopy = customers.getCustomers();
        System.out.println("\ngetCustomers: " + Arrays.toString(customerCopy));
        customerCopy[0] = null;
        System.out.println("Original table after changing returned array: "
                + customers.getCustomer(1));

        System.out.println("\nremoveCustomer (id 2):\n" + customers.removeCustomer(2));
        System.out.println("countNonNull after removal: " + customers.countNonNull());
        System.out.println("removeCustomer (missing id 99): " + customers.removeCustomer(99));
        Customer[] afterRemoval = customers.getCustomers();
        System.out.println("getCustomers after removing id 2 (middle slot): "
                + Arrays.toString(afterRemoval));
        System.out.println("Returned array length: " + afterRemoval.length
                + " (expected: 2)");

        customers.removeCustomer(1);
        Customer[] afterLeadingSlotRemoval = customers.getCustomers();
        System.out.println("getCustomers after removing id 1 (leading slot): "
                + Arrays.toString(afterLeadingSlotRemoval));
        System.out.println("Returned array length: " + afterLeadingSlotRemoval.length
                + " (expected: 1)");
    }

    private static void printCustomers(Customer[] customers) {
        if (customers.length == 0) {
            System.out.println("[]");
            return;
        }

        for (Customer customer : customers) {
            System.out.println(customer);
            System.out.println();
        }
     }
}