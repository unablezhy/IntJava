package ttl.customer.dao;

import ttl.customer.domain.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author whynot
 */
public class CustomerDAO {

    private static List<Customer> customers = new ArrayList<>();
    private static int nextId = 0;


    public Customer insert(Customer customer) {
        int id = ++nextId;
        customer.setId(id);
        customers.add(customer);

        return customer;
    }

    public Customer findById(int id) {
        for(Customer c : customers) {
            if(c.getId() == id) {
                return c;
            }
        }

        return null;
    }

    public List<Customer> findAll() {
        return customers;
    }

}
