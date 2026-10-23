package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

public class Customers {

    private Customer[] customers;

    // a) Complete constructor
    public Customers(int size) {
        customers = new Customer[size]; // Ny liste som kan romme kunder. Privat tilgang.

    }

    // b) count number of non-null references
    public int countNonNull() {

        int count = 0;

        // Reads customers, checks for occupied elements and counts them.
        for (Customer c : customers) {
            if (c != null) {
                count++;
            }
        }
        return count;
    }

    // c) return reference to customer with given id (if exists)
    public Customer getCustomer(int customer_id) {

        // Reads customers, searches for wanted id, returns reference if found, null if not.
        for (Customer c : customers) {
            if (c != null && c.getCustomer_id() == customer_id) {
                return c;
            }
        }
        return null;
    }

    // d) add a customer to the reference table
    public boolean addCustomer(Customer c) {

        boolean inserted = false;

        // Searches customers for an empty element (null). If found, inserts customer and returns true, otherwise returns false.
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = c;
                inserted = true;
                return inserted;
            }
        }

        return inserted;
    }

    // e) remove customer with given id from reference table
    public Customer removeCustomer(int customer_id) {

        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null && customers[i].getCustomer_id() == customer_id) {
                Customer c = customers[i];
                customers[i] = null;
                return c;
            }
        }
        return null;
    }

    // f) return reference table with all customers
    public Customer[] getCustomers() {
        Customer[] allCustomers = new Customer[countNonNull()];
        int nextIndex = 0;

        for (Customer customer : customers) {
            if (customer != null) {
                allCustomers[nextIndex] = customer;
                nextIndex++;
            }
        }

        return allCustomers;
    }
}