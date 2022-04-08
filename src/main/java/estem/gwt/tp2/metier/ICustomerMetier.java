package estem.gwt.tp2.metier;

import estem.gwt.tp2.entities.Customer;

import java.util.List;

public interface ICustomerMetier {
    Customer subscribe(Customer customer) throws Exception;
    Customer updateCustomer(Customer customer) throws Exception;
    Customer removeCustomer(Customer customer) throws Exception;
    Customer getCustomer(Long id) throws Exception;
    List<Customer> getAllCustomers() throws Exception;
}
