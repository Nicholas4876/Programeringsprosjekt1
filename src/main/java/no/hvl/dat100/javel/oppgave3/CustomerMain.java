
package no.hvl.dat100.javel.oppgave3;

public class CustomerMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 3");
        System.out.println("==============");

        Customer customer = new Customer(
            "Nicholas",
            "nicholas@example.com",
            1001,
            PowerAgreementType.SPOTPRICE
        );

        System.out.println("a) Test av getter-metoder");
        System.out.println("Name: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Customer ID: " + customer.getCustomer_id());
        System.out.println("Agreement: " + customer.getAgreement());

        System.out.println("--------------");

    
        System.out.println("b) Test av setter-metoder");

        customer.setName("Brage");
        customer.setEmail("brage@example.com");
        customer.setCustomer_id(1002);
        customer.setAgreement(PowerAgreementType.NORGESPRICE);

        System.out.println("Name: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Customer ID: " + customer.getCustomer_id());
        System.out.println("Agreement: " + customer.getAgreement());

        System.out.println("--------------");

        System.out.println("c) Test av toString()");
        System.out.println(customer);
    }
}