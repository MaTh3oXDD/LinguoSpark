package org.example.Class;

import org.example.Swing.Menu;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }
}
