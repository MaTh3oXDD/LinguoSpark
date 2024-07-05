package org.example.Class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate/hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Client user = new Client(1,"xdd","xdd","xdd");
        session.save(user);
        transaction.commit();
        System.out.println("zapisane");



        //SwingUtilities.invokeLater(Menu::new);
    }
}
