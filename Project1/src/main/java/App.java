import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println("starting project...");

        // create a configuration object
        Configuration config = new Configuration();

        // read the configuration and load in the object
        config.configure("hibernate.cfg.xml");

        // create factory
        SessionFactory factory = config.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin transaction
        Transaction t = session.beginTransaction();

        // create object
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Loser");
        employee.setEmail("loser@gmail.com");

        // save the object
        session.save(employee);
        //session.update(employee);
        //session.delete(employee);

        // commit
        t.commit();
        session.close();

    }
}
