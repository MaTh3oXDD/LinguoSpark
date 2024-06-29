package org.example.Swing.CustomComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class CustomPanelMenu extends JPanel {
    private BufferedImage cachedShadowImage = null;
    private Dimension cachedSize = null;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        if (cachedShadowImage == null || cachedSize == null || !cachedSize.equals(new Dimension(width, height))) {
            cachedShadowImage = createShadowImage(width, height);
            cachedSize = new Dimension(width, height);
        }

        g2d.drawImage(cachedShadowImage, 0, 0, null);

        g2d.setColor(Color.decode("#00408F"));
        GeneralPath path2 = createMainShapePath(width, height);
        g2d.fill(path2);

        g2d.setColor(Color.decode("#002C60"));
        GeneralPath path = createSecondaryShapePath(width, height);
        g2d.fill(path);
    }

    private GeneralPath createMainShapePath(int width, int height) {
        GeneralPath path2 = new GeneralPath();
        path2.moveTo(0, 0);
        path2.lineTo(width / 2.3, 0);
        path2.curveTo(width / 1.2, height / 2, width, height, width / 1.2, height);
        path2.lineTo(0, height);
        path2.closePath();
        return path2;
    }

    private GeneralPath createSecondaryShapePath(int width, int height) {
        GeneralPath path = new GeneralPath();
        path.moveTo(0, 0);
        path.lineTo(width / 4, 0);
        path.curveTo(width / 1.2, height / 2, width / 1.5, height, width / 1.6, height);
        path.lineTo(0, height);
        path.closePath();
        return path;
    }

    private BufferedImage createShadowImage(int width, int height) {
        Color shadowColor = new Color(0, 0, 0, 100);

        GeneralPath path2 = createMainShapePath(width, height);

        BufferedImage shadowImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gShadow = shadowImage.createGraphics();
        gShadow.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gShadow.setColor(shadowColor);
        gShadow.fill(path2);
        gShadow.dispose();

        float[] blurKernel = {
                1 / 16f, 2 / 16f, 1 / 16f,
                2 / 16f, 4 / 16f, 2 / 16f,
                1 / 16f, 2 / 16f, 1 / 16f
        };
        ConvolveOp blur = new ConvolveOp(new Kernel(3, 3, blurKernel));
        return blur.filter(shadowImage, null);
    }
}
