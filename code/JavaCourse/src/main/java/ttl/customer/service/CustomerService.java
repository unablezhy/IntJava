package ttl.customer.service;

import ttl.customer.dao.CustomerDAO;
import ttl.customer.domain.Customer;

import java.util.List;

/**
 * @author whynot
 */
public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();

    public Customer getCustomer(int id) {
        //Lots code here
        Customer c = customerDAO.findById(id);
        return c;
    }

    public Customer addCustomer(Customer input) {
        //Business logic here

        Customer result = customerDAO.insert(input);
        return result;
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }
}
