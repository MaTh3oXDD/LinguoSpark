package org.example.Swing;

import org.example.Swing.CustomComponents.*;

import javax.swing.*;
import java.awt.*;

public class Register extends JFrame {

    public Register() {
        super("LinguoSpark");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        setLayout(new BorderLayout());
        initializeComponents();
        this.setVisible(true);
        ImageIcon icon = new ImageIcon(getClass().getResource("/LinguoSpark.png"));
        setIconImage(icon.getImage());
    }

    private void initializeComponents() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel label = new JLabel("Register");
        JLabel usernameLabel = new JLabel("Username");
        PTextField usernameField = new PTextField("Username");
        JLabel emailLabel = new JLabel("Email");
        PTextField emailField = new PTextField("Email");
        JLabel passwordLabel = new JLabel("Password");
        PPasswordField passwordField = new PPasswordField("Password", 20);
        CButton registerButton = new CButton("Register");
        CButton backButton = new CButton("Back");

        // Add action listener to the back button
        backButton.addActionListener(e -> {
            new Menu();
            this.dispose();
        });


        backButton.setFont(new Font("Lato", Font.PLAIN, 20));
        backButton.setPreferredSize(new Dimension(120, 40));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(registerButton);
        buttonPanel.add(backButton);
        this.add(buttonPanel, gbc);
    }
}
