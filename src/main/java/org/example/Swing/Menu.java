package org.example.Swing;

import org.example.Swing.CustomComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Menu extends JFrame{
    private ImageIcon dabIcon;
    private JLabel dabLabel;

    public Menu() {
        super("LinguoSpark");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        setLayout(new BorderLayout());
        initializeComponents();
        this.setVisible(true);
        ImageIcon icon = new ImageIcon(getClass().getResource("/LinguoSpark.png"));
        setIconImage(icon.getImage());
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Update components when the frame is resized
                updateComponents();
            }
        });

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
        CButton loginButton = new CButton("Login");
        CButton registerButton = new CButton("Register");
        registerButton.addActionListener(e -> {new Register();
        this.dispose();
        });

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
        loginButton.setFont(new Font("Lato", Font.PLAIN, 15));
        loginButton.setPreferredSize(new Dimension(120, 40));
        registerButton.setFont(new Font("Lato", Font.PLAIN, 15));
        registerButton.setPreferredSize(new Dimension(120, 40));
        loginField.setPreferredSize(new Dimension(300, 30));
        passwordField.setPreferredSize(new Dimension(300, 30));

        try {
            dabIcon = new ImageIcon(getClass().getResource("/LinguoSpark.png"));
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

        gbc.insets = new Insets(10, 10, 10, 10);
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
        // Create a panel to hold both buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        right.add(buttonPanel, gbc);

        panel.setLeftComponent(left);
        panel.setRightComponent(right);

        this.add(panel, BorderLayout.CENTER);
    }

    private void updateImageSize() {
        int width = getWidth() / 4;
        int height = width;  // Maintain aspect ratio
        Image scaledImage = dabIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        dabLabel.setIcon(new ImageIcon(scaledImage));
    }

    public void updateComponents() {
        updateImageSize();
        revalidate();
        repaint();
    }

}
