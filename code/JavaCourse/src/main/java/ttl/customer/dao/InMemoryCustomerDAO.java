package ttl.customer.dao;

import ttl.customer.domain.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author whynot
 */
public class InMemoryCustomerDAO implements CustomerDAO {

    private static List<Customer> customers = new ArrayList<>();
    private static int nextId = 0;


    @Override
    public Customer insert(Customer customer) {
        int id = ++nextId;
        //customer.setId(id);
        Customer newCustomer = new Customer(id, customer.getName(), customer.getPhoneNumbers(), customer.getStatus());
        customers.add(customer);

        return customer;
    }

    @Override
    public Customer findById(int id) {
        for(Customer c : customers) {
            if(c.getId() == id) {
                return c;
            }
        }

        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> result = new ArrayList<>(customers);
        return result;
        //return Collections.unmodifiableList(customers);
    }

}
