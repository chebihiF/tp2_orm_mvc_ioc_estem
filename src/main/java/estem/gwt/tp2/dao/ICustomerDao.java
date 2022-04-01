package estem.gwt.tp2.dao;

import estem.gwt.tp2.entities.Customer;

import java.util.List;

public interface ICustomerDao {
    Customer addCustomer(Customer customer) throws Exception;
    Customer updateCustomer(Customer customer) throws Exception;
    Customer removeCustomer(Customer customer) throws Exception;
    Customer getCustomer(Long id) throws Exception;
    List<Customer> getAllCustomers() throws Exception;
}
