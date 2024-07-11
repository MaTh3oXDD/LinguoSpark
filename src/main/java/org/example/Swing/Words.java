package org.example.Swing;

import org.example.Swing.CustomComponents.GSplitPane;
import org.example.Swing.CustomComponents.RoundLabel;
import org.example.Swing.CustomComponents.RoundPanel;

import javax.swing.*;
import java.awt.*;

public class Words extends JFrame {
    public Words() {
        super("Linguospark");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/LinguoSpark.png"));
        setIconImage(icon.getImage());
        initializeComponent();
    }

    public void initializeComponent() {
        // Create the main split pane
        JSplitPane panel = new GSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        RoundPanel left = new RoundPanel(0,50,0,50);
        JPanel right = new JPanel(new BorderLayout());
        JPanel bigMenu = new JPanel();
        JLabel linguoSparkLabel = new JLabel("LinguoSpark");
        RoundLabel menuLabel = new RoundLabel("Menu", Color.CYAN, 5, 5);
        RoundLabel statisticLabel = new RoundLabel("Statistic", Color.CYAN, 30, 30);
        RoundLabel forumLabel = new RoundLabel("Forum", Color.CYAN, 30, 30);
        RoundLabel gameLabel = new RoundLabel("Game", Color.CYAN, 30, 30);
        RoundLabel listeningLabel = new RoundLabel("Listening", Color.CYAN, 30, 30);

        left.setLayout(new GridBagLayout());
        panel.setResizeWeight(0.2);
        panel.setEnabled(false);
        panel.setDividerSize(0);

        // Set the location of the divider
         // Set background color for the split pane

        // Set background colors
        left.setBackground(Color.decode("#164175")); // Set the desired background color
        right.setBackground(new Color(0, 0, 0, 0)); // Transparent background color
        bigMenu.setBackground(Color.decode("#ffffff"));
        bigMenu.setSize(new Dimension(300,300));
        // Add GridBagConstraints to center bigMenu
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        left.add(bigMenu);

        // Set initial size of bigMenu
        //bigMenu.setPreferredSize(new Dimension(300, 300)); // Set initial size

        // Set BoxLayout for bigMenu
        bigMenu.setLayout(new BoxLayout(bigMenu, BoxLayout.Y_AXIS));
        bigMenu.add(menuLabel);
        bigMenu.add(statisticLabel);
        bigMenu.add(forumLabel);
        bigMenu.add(gameLabel);
        bigMenu.add(listeningLabel);
        bigMenu.setOpaque(false);

        // Add listener to left panel to set the size of bigMenu


        // Set proportions for the split pane
        panel.setLeftComponent(left);
        panel.setRightComponent(right);

        // Add the split pane to JFrame
        this.add(panel, BorderLayout.CENTER);
    }

}
