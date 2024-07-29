package org.example.Swing.CustomComponents;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PTextField extends JTextField {
    private String promptText="";
    public PTextField()
    {

        Design();
    }
    public PTextField(final String promptText) {
        super(promptText);
        this.promptText=promptText;
        Design();
    }
    private void Design()
    {
        setOpaque(false);
        setForeground(Color.decode("#F5F4F5"));
        setBorder(new MatteBorder(0, 0, 2, 0, Color.decode("#F5F4F5")));
        addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(promptText);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(promptText)) {
                    setText("");
                }
            }
        });
    }
}
