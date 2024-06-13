package org.example.Swing;

import com.sun.jdi.VMCannotBeModifiedException;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    public Menu() {

        super("LinguoSpark");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
        setLayout(new BorderLayout());
        initializeComponents();
    }
    public void initializeComponents()
    {
        JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel left = new JPanel();
        JPanel right = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel label = new JLabel("Login");
        JLabel loginLabel = new JLabel("Login:");
        JTextField loginField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");


        JSeparator loginSeparator = new JSeparator();
        JSeparator passwordSeparator = new JSeparator();

        panel.setResizeWeight(0.4);
        panel.setEnabled(false);
        panel.setDividerSize(0);

        label.setFont(new Font("Lato", Font.PLAIN, 44));

        left.setBackground(Color.black);
        right.setBackground(Color.pink);


        gbc.insets = new Insets(10, 10, 10, 10); // Odstępy między komponentami
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        right.add(label, gbc);

        gbc.gridy++;
        right.add(loginLabel, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        right.add(loginField, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        right.add(loginSeparator, gbc);

        gbc.gridy++;
        right.add(passwordLabel, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        right.add(passwordField, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        right.add(passwordSeparator, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        right.add(loginButton, gbc);

        panel.setLeftComponent(left);
        panel.setRightComponent(right);

        this.add(panel, BorderLayout.CENTER);
    }
}
