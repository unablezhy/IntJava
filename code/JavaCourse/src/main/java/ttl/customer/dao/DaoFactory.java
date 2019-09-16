package ttl.customer.dao;

import java.util.ResourceBundle;

/**
 * @author whynot
 */
public class DaoFactory {

    public static CustomerDAO getDao() {
        ResourceBundle bundle = ResourceBundle.getBundle("customerapp");
        String profile = bundle.getString("customerapp.profile");

        switch(profile) {
            case "dev":
                return new InMemoryCustomerDAO();
            case "prod":
                return new MysqlCustomerDAO();
            default:
                throw new RuntimeException("Unknown profile: " + profile);
        }

    }
}
