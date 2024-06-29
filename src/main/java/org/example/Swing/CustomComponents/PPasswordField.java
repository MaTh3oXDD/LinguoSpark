package org.example.Swing.CustomComponents;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PPasswordField extends JPasswordField {
    private final String promptText;

    public PPasswordField(final String promptText, int width) {
        super(width);
        this.promptText = promptText;
        setOpaque(false);
        setBorder(new MatteBorder(0, 0, 2, 0, Color.decode("#F5F4F5")));
        setForeground(Color.decode("#F5F4F5"));
        setEchoChar((char) 0);
        setText(promptText);

        addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (getPassword().length == 0) {
                    setText(promptText);
                    setEchoChar((char) 0);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (new String(getPassword()).equals(promptText)) {
                    setText("");
                    setEchoChar('\u2022');
                }
            }
        });
    }

    @Override
    public String getText() {
        return new String(getPassword());
    }
}
