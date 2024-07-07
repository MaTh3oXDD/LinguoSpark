package org.example.Swing;

import org.example.Swing.CustomComponents.GSplitPane;

import javax.swing.*;
import java.awt.*;

public class Words extends JFrame {
    public Words() {
        super("Linguospark");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/LinguoSpark.png"));
        setIconImage(icon.getImage());
        initializeComponent();
    }

    public void initializeComponent() {
        // Utworzenie głównego panelu
        GSplitPane panel = new GSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel left = new JPanel(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());
        JPanel bigMenu = new JPanel();

        // Ustawienia kolorów tła
        left.setBackground(Color.pink);
        right.setBackground(Color.black);
        bigMenu.setBackground(Color.blue);

        // Ustawienie BoxLayout dla bigMenu
        bigMenu.setLayout(new BoxLayout(bigMenu, BoxLayout.Y_AXIS));
        bigMenu.add(Box.createVerticalGlue());
        bigMenu.add(Box.createHorizontalGlue());

        // Dodanie bigMenu do panelu left
        left.add(bigMenu, BorderLayout.CENTER);

        // Ustawienie proporcji dla panelu GSplitPane
        panel.setResizeWeight(0.6);
        panel.setLeftComponent(left);
        panel.setRightComponent(right);

        // Dodanie panelu do JFrame
        this.add(panel, BorderLayout.CENTER);
    }

}
