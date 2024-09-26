package org.example.Swing.CustomComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class GradientPanel extends JPanel {
    private final int topLeftRadius;
    private final int topRightRadius;
    private final int bottomLeftRadius;
    private final int bottomRightRadius;

    public GradientPanel(int topLeftRadius, int topRightRadius, int bottomLeftRadius, int bottomRightRadius) {
        this.topLeftRadius = topLeftRadius;
        this.topRightRadius = topRightRadius;
        this.bottomLeftRadius = bottomLeftRadius;
        this.bottomRightRadius = bottomRightRadius;
        setOpaque(false);
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = Color.decode("#6d6e6d");
        Color color2 = Color.decode("#a7a8a7");
        GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);

        Shape roundShape = createRoundShape();

        g2d.setClip(roundShape);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);

        g2d.dispose();
    }

    private Shape createRoundShape() {
        int width = getWidth();
        int height = getHeight();
        Path2D path = new Path2D.Double();

        path.moveTo(topLeftRadius, 0);
        path.lineTo(width - topRightRadius, 0);
        path.quadTo(width, 0, width, topRightRadius);
        path.lineTo(width, height - bottomRightRadius);
        path.quadTo(width, height, width - bottomRightRadius, height);
        path.lineTo(bottomLeftRadius, height);
        path.quadTo(0, height, 0, height - bottomLeftRadius);
        path.lineTo(0, topLeftRadius);
        path.quadTo(0, 0, topLeftRadius, 0);

        path.closePath();
        return path;
    }

    @Override
    public void setOpaque(boolean isOpaque) {
        super.setOpaque(isOpaque);
    }
}
