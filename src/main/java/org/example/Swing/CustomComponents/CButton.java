package org.example.Swing.CustomComponents;

import javax.swing.*;
import java.awt.*;

public class CButton extends JButton {
    public CButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorderPainted(false);

    }

    @Override
    public void setPreferredSize(Dimension preferredSize) {
        super.setPreferredSize(preferredSize);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(0, 64, 143));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        super.paintComponent(g2);
        g2.dispose();
    }

}
