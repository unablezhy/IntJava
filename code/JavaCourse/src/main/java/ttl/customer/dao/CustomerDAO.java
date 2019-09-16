package ttl.customer.dao;

import ttl.customer.domain.Customer;

import java.util.List;

/**
 * @author whynot
 */
public interface CustomerDAO {
    Customer insert(Customer customer);

    Customer findById(int id);

    List<Customer> findAll();
}
