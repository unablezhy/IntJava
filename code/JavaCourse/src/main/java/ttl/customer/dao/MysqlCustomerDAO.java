package ttl.customer.dao;

import ttl.customer.domain.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author whynot
 */
public class MysqlCustomerDAO implements CustomerDAO{

    private static List<Customer> customers = new ArrayList<>();
    private static int nextId = 0;



    public Customer insert(Customer customer) {
        int id = ++nextId;
        //customer.setId(id);
        Customer newCustomer = new Customer(id, "Mysql: " + customer.getName(), customer.getPhoneNumbers(), customer.getStatus());
        customers.add(newCustomer);

        return newCustomer;
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
        List<Customer> result = new ArrayList<>(customers);
        return result;
        //return Collections.unmodifiableList(customers);
    }

}
