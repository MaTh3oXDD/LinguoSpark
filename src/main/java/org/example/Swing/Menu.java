package org.example.Swing;

import org.example.Swing.CustomComponents.CustomPanelMenu;
import org.example.Swing.CustomComponents.GSplitPane;
import org.example.Swing.CustomComponents.PPasswordField;
import org.example.Swing.CustomComponents.PTextField;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class Menu extends JFrame {
    public Menu() {

        super("LinguoSpark");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(800, 600);
        setLayout(new BorderLayout());
        initializeComponents();
        this.setVisible(true);
        ImageIcon icon = new ImageIcon(getClass().getResource("/LinguoSpark.png"));
        setIconImage(icon.getImage());

    }

    public void initializeComponents() {
        GSplitPane panel = new GSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel left = new CustomPanelMenu();
        JPanel right = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel label = new JLabel("Login");
        JLabel loginLabel = new JLabel("Login");
        PTextField loginField = new PTextField("Login");
        JLabel passwordLabel = new JLabel("Password");
        PPasswordField passwordField = new PPasswordField("Password", 20);
        JButton loginButton = new JButton("Login");

        label.setForeground(Color.decode("#F5F4F5"));
        loginLabel.setForeground(Color.decode("#F5F4F5"));
        passwordLabel.setForeground(Color.decode("#F5F4F5"));

        panel.setResizeWeight(0.6);
        panel.setEnabled(false);
        panel.setDividerSize(0);
        left.setOpaque(false);
        right.setOpaque(false);

        label.setFont(new Font("Lato", Font.PLAIN, 70));
        loginLabel.setFont(new Font("Lato", Font.PLAIN, 16));
        passwordLabel.setFont(new Font("Lato", Font.PLAIN, 16));
        loginField.setPreferredSize(new Dimension(300, 30));  // Ustawienie preferowanego rozmiaru
        passwordField.setPreferredSize(new Dimension(300, 30));  // Ustawienie preferowanego rozmiaru

        gbc.insets = new Insets(10, 10, 10, 10); // Odstępy między komponentami
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        right.add(label, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        right.add(loginLabel, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        right.add(loginField, gbc);

        gbc.gridy++;
        right.add(passwordLabel, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        right.add(passwordField, gbc);
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        right.add(loginButton, gbc);

        panel.setLeftComponent(left);
        panel.setRightComponent(right);

        this.add(panel, BorderLayout.CENTER);
    }

}