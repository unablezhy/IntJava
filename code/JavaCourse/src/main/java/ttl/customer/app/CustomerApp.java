package ttl.customer.app;


import ttl.customer.domain.Customer;
import ttl.customer.service.CustomerService;

import java.util.Arrays;
import java.util.List;

/**
 * @author whynot
 */
public class CustomerApp {

    public static void main(String[] args) {
        request1();

        request2();
    }

    public static void request1() {
        Customer input = new Customer("Sarla", Arrays.asList("383 939 9393"), Customer.Status.Privelaged);
        Customer input2 = new Customer("Joey", Arrays.asList("383 939 9393"), Customer.Status.Privelaged);
        CustomerService cs = new CustomerService();

        cs.addCustomer(input);
        cs.addCustomer(input2);

        List<Customer> all = cs.getAllCustomers();

        for(Customer c : all) {
            System.out.println(c);
        }
    }

    public static void request2() {
        CustomerService cs = new CustomerService();
        List<Customer> all = cs.getAllCustomers();

        System.out.println("Second request");
        for(Customer c : all) {
            System.out.println(c);
        }
    }
}
