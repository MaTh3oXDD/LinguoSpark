package org.example.Swing.CustomComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundLabel extends JLabel {

    private Color backgroundColor;
    private int arcWidth;
    private int arcHeight;

    public RoundLabel(String text, Color backgroundColor, int arcWidth, int arcHeight) {
        super(text);
        this.backgroundColor = backgroundColor;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false); // Make sure the JLabel is not opaque
        setFont(new Font("Arial", Font.BOLD, 20));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension(100, 35));
        setMinimumSize(new Dimension(100, 35));
        setMaximumSize(new Dimension(100, 35));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Paint the rounded background
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        // Set clipping region to ensure text is within rounded rectangle
        Shape clip = g2.getClip();
        g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));

        // Paint the text
        super.paintComponent(g);

        // Restore the original clipping region
        g2.setClip(clip);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Optionally, you can paint a border here
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
    }

}
