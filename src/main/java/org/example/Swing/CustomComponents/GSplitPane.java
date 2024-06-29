package org.example.Swing.CustomComponents;

import javax.swing.*;
import java.awt.*;

public class GSplitPane extends JSplitPane {
    private GradientPaint cachedGradient = null;
    private Dimension cachedSize = null;

    public GSplitPane(int orientation) {
        super(orientation);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        if (cachedGradient == null || cachedSize == null || !cachedSize.equals(new Dimension(w, h))) {
            cachedGradient = createGradient(w, h);
            cachedSize = new Dimension(w, h);
        }

        g2d.setPaint(cachedGradient);
        g2d.fillRect(0, 0, w, h);
    }

    private GradientPaint createGradient(int w, int h) {
        Color color1 = Color.decode("#00408F");
        Color color2 = Color.decode("#333333");

        double angle = Math.toRadians(30);
        double x2 = w * Math.cos(angle);
        double y2 = w * Math.sin(angle);

        return new GradientPaint(0, 0, color1, (float) x2, (float) y2, color2);
    }
}
