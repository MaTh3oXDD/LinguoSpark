package org.example.Swing.CustomComponents;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PPasswordField extends JPasswordField {
    public PPasswordField(final String proptText)
    {
        super(proptText);
        setOpaque(false);
        setBorder(new MatteBorder(0, 0, 2, 0, Color.GRAY));
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
