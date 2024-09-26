package org.example.Swing.ButtonFunction;

import org.example.Class.HibernateClass.Client;
import org.example.Swing.Menu;
import org.example.Swing.Register;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterAction implements ActionListener {
    private final Register register;

    public RegisterAction(Register register) {
        this.register = register;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate/hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        String username = register.getUsernameText();
        String email = register.getEmailText();
        String password = register.getPasswordText();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Client client = new Client();
        client.setUsername(username);
        client.setEmail(email);
        client.setPassword(password);
        session.save(client);
        transaction.commit();
        System.out.println("zapisane");

        session.close();
        sessionFactory.close();
        new Menu();
        register.dispose();

    }
}
