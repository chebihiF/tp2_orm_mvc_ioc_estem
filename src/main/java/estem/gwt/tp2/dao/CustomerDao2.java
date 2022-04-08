package estem.gwt.tp2.dao;

import estem.gwt.tp2.entities.Customer;
import estem.gwt.tp2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;


public class CustomerDao2 implements ICustomerDao{

    private SessionFactory factory = HibernateUtil.getFactory();
    private Session session;

    @Override
    public Customer addCustomer(Customer customer) throws Exception {
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(customer);
            session.getTransaction().commit();
            customer.setId(id);
            return customer;
        }catch (Exception e) {
            session.getTransaction().rollback();
            throw e ;
        }finally {
            session.close();
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) throws Exception {
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
            return customer;
        }catch (Exception e) {
            session.getTransaction().rollback();
            throw e ;
        }finally {
            session.close();
        }
    }

    @Override
    public Customer removeCustomer(Customer customer) throws Exception {
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();
            return customer;
        }catch (Exception e) {
            session.getTransaction().rollback();
            throw e ;
        }finally {
            session.close();
        }
    }

    @Override
    public Customer getCustomer(Long id) throws Exception {
        try {
            session = factory.openSession();
            session.beginTransaction();
            Customer customer = session.get(Customer.class,id);
            session.getTransaction().commit();
            return customer;
        }catch (Exception e) {
            session.getTransaction().rollback();
            throw e ;
        }finally {
            session.close();
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws Exception {
        try {
            session = factory.openSession();
            session.beginTransaction();
            List<Customer> customers =
                    session.createQuery("from Customer c",Customer.class).getResultList();
            session.getTransaction().commit();
            return customers;
        }catch (Exception e) {
            session.getTransaction().rollback();
            throw e ;
        }finally {
            session.close();
        }
    }
}
