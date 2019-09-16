package ttl.customer.service;

import ttl.customer.dao.CustomerDAO;
import ttl.customer.dao.DaoFactory;
import ttl.customer.dao.InMemoryCustomerDAO;
import ttl.customer.dao.MysqlCustomerDAO;
import ttl.customer.domain.Customer;
import ttl.reflect.metadata.MyNotNull;

import java.util.List;

/**
 * @author whynot
 */
public class CustomerService {

    //private CustomerDAO customerDAO = new MysqlCustomerDAO();
    //private CustomerDAO customerDAO = DaoFactory.getDao();
    private CustomerDAO customerDAO = DaoFactory.getDao();

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
