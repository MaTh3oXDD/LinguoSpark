package org.example.Swing;

import org.example.Swing.ButtonFunction.RegisterAction;
import org.example.Swing.CustomComponents.*;

import javax.swing.*;
import java.awt.*;

public class Register extends JFrame {
    private ImageIcon dabIcon;
    private JLabel dabLabel;
    private PTextField usernameField;
    private PTextField emailField;
    private  PPasswordField passwordField;
    public Register() {
        super("LinguoSpark");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        setLayout(new BorderLayout());
        initializeComponents();
        this.setVisible(true);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/LinguoSpark.png"));
        setIconImage(icon.getImage());
    }

    private void initializeComponents() {
        GridBagConstraints gbc = new GridBagConstraints();

        GSplitPane panel = new GSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel left = new CustomPanelMenu();
        JPanel right = new JPanel(new GridBagLayout());

        Color fontColor =  Color.decode("#F5F4F5");

        JLabel label = new JLabel("Register");
        JLabel usernameLabel = new JLabel("Username");
        usernameField = new PTextField("Username");
        JLabel emailLabel = new JLabel("Email");
        emailField = new PTextField("Email");
        JLabel passwordLabel = new JLabel("Password");
        passwordField = new PPasswordField("Password", 20);
        CButton registerButton = new CButton("Register");
        CButton backButton = new CButton("Back");

        try {
            dabIcon = new ImageIcon(getClass().getResource("/img/LinguoSpark.png"));
            dabLabel = new JLabel();
            updateImageSize();  // Initial image size setup

            JPanel wrapperPanel = new JPanel(new BorderLayout());
            wrapperPanel.setOpaque(false);
            wrapperPanel.add(dabLabel, BorderLayout.WEST);

            left.setLayout(new BorderLayout());
            left.add(wrapperPanel, BorderLayout.SOUTH);
        } catch (Exception e) {
            System.out.println("Failed to load image");
            e.printStackTrace();
        }

        // Add action listener to the back button
        backButton.addActionListener(e -> {
            new Menu();
            this.dispose();
        });
        registerButton.addActionListener(new RegisterAction(this));

        label.setForeground(fontColor);
        usernameLabel.setForeground(fontColor);
        emailLabel.setForeground(fontColor);
        passwordLabel.setForeground(fontColor);
        label.setFont(new Font("Lato", Font.PLAIN, 70));
        usernameLabel.setFont(new Font("Lato", Font.PLAIN, 16));
        emailLabel.setFont(new Font("Lato", Font.PLAIN, 16));
        passwordLabel.setFont(new Font("Lato", Font.PLAIN, 16));
        registerButton.setFont(new Font("Lato", Font.PLAIN, 20));
        registerButton.setPreferredSize(new Dimension(120, 40));
        backButton.setFont(new Font("Lato", Font.PLAIN, 20));
        backButton.setPreferredSize(new Dimension(120, 40));
        usernameField.setPreferredSize(new Dimension(300, 30));
        emailField.setPreferredSize(new Dimension(300, 30));
        passwordField.setPreferredSize(new Dimension(300, 30));

        panel.setResizeWeight(0.6);
        panel.setEnabled(false);
        panel.setDividerSize(0);
        right.setOpaque(false);
        left.setOpaque(false);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(registerButton);
        buttonPanel.add(backButton);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        right.add(label, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        right.add(usernameLabel, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        right.add(usernameField, gbc);

        gbc.gridy++;
        right.add(emailLabel, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        right.add(emailField, gbc);

        gbc.gridy++;
        right.add(passwordLabel, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        right.add(passwordField, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        right.add(buttonPanel, gbc);

        panel.setLeftComponent(left);
        panel.setRightComponent(right);
        this.add(panel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    private void updateImageSize() {
        int width = getWidth() / 4;
        int height = width;  // Maintain aspect ratio
        Image scaledImage = dabIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        dabLabel.setIcon(new ImageIcon(scaledImage));
    }
    public String getUsernameText()
    {
        return usernameField.getText();
    }
    public String getEmailText()
    {
        return emailField.getText();
    }
    public String getPasswordText()
    {
        return new String(passwordField.getPassword());
    }
}