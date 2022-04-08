package estem.gwt.tp2.util;

import estem.gwt.tp2.entities.Customer;
import estem.gwt.tp2.entities.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;
    static{
        factory = new Configuration()
                .configure()
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Customer.class)
//                .addPackage("estem.gwt.tp2.entities")
                .buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
