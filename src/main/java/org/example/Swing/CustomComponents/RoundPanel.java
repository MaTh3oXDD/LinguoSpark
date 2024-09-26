package org.example.Swing.CustomComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class RoundPanel extends JPanel {
    private int topLeftRadius;
    private int topRightRadius;
    private int bottomLeftRadius;
    private int bottomRightRadius;

    public RoundPanel(int topLeftRadius, int topRightRadius, int bottomLeftRadius, int bottomRightRadius) {
        this.topLeftRadius = topLeftRadius;
        this.topRightRadius = topRightRadius;
        this.bottomLeftRadius = bottomLeftRadius;
        this.bottomRightRadius = bottomRightRadius;
        setOpaque(false);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fill(createRoundShape());

        g2.dispose();
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
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public void setCornerRadii(int topLeftRadius, int topRightRadius, int bottomLeftRadius, int bottomRightRadius) {
        this.topLeftRadius = topLeftRadius;
        this.topRightRadius = topRightRadius;
        this.bottomLeftRadius = bottomLeftRadius;
        this.bottomRightRadius = bottomRightRadius;
        repaint();
    }

    @Override
    public void setOpaque(boolean isOpaque) {
        super.setOpaque(isOpaque);
    }
}
