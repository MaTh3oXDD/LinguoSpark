package org.example.Swing.CustomComponents;

import javax.swing.*;
import java.awt.*;

public class GSplitPane extends JSplitPane {
    public GSplitPane(int orientation) {
        super(orientation);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth(), h = getHeight();
        Color color1 = Color.decode("#00408F");
        Color color2 = Color.decode("#333333");

        double angle = Math.toRadians(30);
        double x2 = w * Math.cos(angle);
        double y2 = w * Math.sin(angle);
        GradientPaint gp = new GradientPaint(0, 0, color1, (float)x2, (float)y2, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
