package estem.gwt.tp2.metier;

import estem.gwt.tp2.dao.ICustomerDao;
import estem.gwt.tp2.entities.Customer;

import java.util.List;

public class CustomerMetier2 implements ICustomerMetier{

    private ICustomerDao dao ;

    public void setDao(ICustomerDao dao) {
        this.dao = dao;
    }

    @Override
    public Customer subscribe(Customer customer) throws Exception {
        if(!customer.getEmail().contains("hotmail")) throw new Exception("email invalid");
        if(customer.getName().trim().equals("")) throw new Exception("name must be set");
        return dao.addCustomer(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws Exception {
        if(!customer.getEmail().contains("hotmail")) throw new Exception("email invalid");
        if(customer.getName().trim().equals("")) throw new Exception("name must be set");
        return dao.updateCustomer(customer);
    }

    @Override
    public Customer removeCustomer(Customer customer) throws Exception {
        // contraintes
        return dao.removeCustomer(customer);
    }

    @Override
    public Customer getCustomer(Long id) throws Exception {
        return dao.getCustomer(id);
    }

    @Override
    public List<Customer> getAllCustomers() throws Exception {
        return dao.getAllCustomers();
    }
}
