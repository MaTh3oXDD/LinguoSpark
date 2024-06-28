package org.example.Swing.CustomComponents;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PTextField extends JTextField {
    @Override
    public void setPreferredSize(Dimension preferredSize) {
        super.setPreferredSize(preferredSize);
    }

    public PTextField(final String proptText) {

        super(proptText);
        setOpaque(false);
        setForeground(Color.decode("#F5F4F5"));
        setBorder(new MatteBorder(0, 0, 2, 0, Color.decode("#F5F4F5")));
        addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if(getText().isEmpty()) {
                    setText(proptText);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(getText().equals(proptText)) {
                    setText("");
                }
            }
        });

    }
}
