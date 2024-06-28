package org.example.Swing.CustomComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
public class CustomPanelMenu extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Włączenie lepszej jakości renderowania
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Kolory
        Color backgroundColor = new Color(10, 30, 80); // Ciemnoniebieski kolor tła
        Color shapeColor = new Color(30, 70, 140); // Kolor kształtu

        // Wypełnienie tła
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, width, height);

        // Tworzenie ścieżki dla niestandardowego kształtu
        GeneralPath path = new GeneralPath();
        path.moveTo(0, 0);
        path.lineTo(width / 2, 0);
        path.curveTo(width / 4, height / 2, width / 4, height, 0, height);
        path.closePath();

        // Rysowanie kształtu
        g2d.setColor(shapeColor);
        g2d.fill(path);
    }
}
