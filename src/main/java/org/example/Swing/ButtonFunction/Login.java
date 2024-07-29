package org.example.Swing.ButtonFunction;

import org.example.Class.HibernateClass.Client;
import org.example.Swing.Menu;
import org.example.Swing.App;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login implements ActionListener {

    private final Menu menu;
    private String username;

    public Login() {

        menu = null;
    }
    public Login(Menu menu,String username) {
        this.menu = menu;
        this.username=username;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate/hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        // Pobierz dane z pól tekstowych
        String username = menu.getLoginText();
        String password = menu.getPasswordText();

        // Zapisz nowego klienta
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Wyświetl wszystkie wpisy w tabeli Client
        List<Client> clients = session.createQuery("FROM Client", Client.class).list();
        for (Client client : clients) {
            if(username.equals(client.getUsername()) && password.equals(client.getPassword()))
            {

                menu.dispose();
                username=client.getUsername();
                new App(getUsername());

            }
        }
        System.out.println(username+password);

        session.getTransaction().commit();

        // Zamknij sesję i SessionFactory
        session.close();
        sessionFactory.close();
    }

    public String getUsername() {
        return username;
    }
}
