package org.example.Swing;

import org.example.Swing.CustomComponents.*;

import javax.swing.*;
import java.awt.*;

public class Words extends JFrame {
    private ImageIcon dabIcon;
    private JLabel dabLabel;

    public Words() {
        super("Linguospark");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/LinguoSpark.png"));
        setIconImage(icon.getImage());
        initializeComponent();
        this.setVisible(true);
    }

    public void initializeComponent() {
        // Create the main split pane
        JSplitPane panel = new GSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        RoundPanel left = new RoundPanel(0, 50, 0, 50);
        JPanel right = new JPanel(new GridBagLayout());
        JPanel topMenu = new JPanel();
        JPanel middleMenu = new JPanel();
        JPanel bottomMenu = new JPanel();
        JLabel linguoSparkLabel = new JLabel("LinguoSpark");
        RoundLabel menuLabel = new RoundLabel("Menu", Color.CYAN, 30, 35);
        RoundLabel statisticLabel = new RoundLabel("Statistic", Color.CYAN, 30, 30);
        RoundLabel forumLabel = new RoundLabel("Forum", Color.CYAN, 30, 30);
        RoundLabel gameLabel = new RoundLabel("Game", Color.CYAN, 30, 30);
        RoundLabel listeningLabel = new RoundLabel("Listening", Color.CYAN, 30, 30);
        JPanel rightBackground = new GradientPanel(30,30,30,30);


        dabIcon = new ImageIcon(getClass().getResource("/img/LinguoSpark.png"));
        dabLabel = new JLabel(scaleIcon(dabIcon, 100, 100));  // Skaluj ikonę

        // Ustawienia dla etykiety "LinguoSpark"
        linguoSparkLabel.setFont(new Font("Arial", Font.BOLD, 24));
        linguoSparkLabel.setHorizontalAlignment(SwingConstants.CENTER);

        left.setLayout(new GridBagLayout());
        panel.setResizeWeight(0.05);
        panel.setEnabled(false);
        panel.setDividerSize(0);

        // Set background colors
        left.setBackground(Color.decode("#164175")); // Set the desired background color
        right.setBackground(new Color(0, 0, 0, 0)); // Transparent background color
        topMenu.setBackground(Color.decode("#164175")); // Match the left panel background
        middleMenu.setBackground(Color.decode("#164175")); // Match the left panel background
        bottomMenu.setBackground(Color.decode("#164175")); // Match the left panel background

        // Set layouts for the sub-panels
        topMenu.setLayout(new GridBagLayout());
        middleMenu.setLayout(new GridBagLayout());
        bottomMenu.setLayout(new GridBagLayout());

        // Add GridBagConstraints for the sub-panels in the main panel (left)
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.weightx = 1.0;


        // Add topMenu to the main panel (left) with 10% height
        gbcMain.weighty = 0.1;
        gbcMain.anchor = GridBagConstraints.NORTH;
        left.add(topMenu, gbcMain);

        // Add middleMenu to the main panel (left) with 80% height
        gbcMain.gridy = 1;
        gbcMain.weighty = 0.8;
        gbcMain.anchor = GridBagConstraints.CENTER;
        left.add(middleMenu, gbcMain);

        // Add bottomMenu to the main panel (left) with 10% height
        gbcMain.gridy = 2;
        gbcMain.weighty = 0.1;
        gbcMain.anchor = GridBagConstraints.SOUTH;
        left.add(bottomMenu, gbcMain);

        // Configure GridBagConstraints for the title label
        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.gridx = 0;
        gbcTitle.gridy = 0;
        gbcTitle.weightx = 1.0;
        gbcTitle.weighty = 0.0;
        gbcTitle.insets = new Insets(0, 0, 10, 0);
        gbcTitle.anchor = GridBagConstraints.NORTH;
        gbcTitle.fill = GridBagConstraints.HORIZONTAL;
        topMenu.add(linguoSparkLabel, gbcTitle);

        // Configure GridBagConstraints for the rest of the labels
        GridBagConstraints gbcLabels = new GridBagConstraints();
        gbcLabels.gridx = 0;
        gbcLabels.gridy = GridBagConstraints.RELATIVE;
        gbcLabels.weightx = 1.0;
        gbcLabels.weighty = 0.0;
        gbcLabels.insets = new Insets(10, 0, 0, 0);
        gbcLabels.anchor = GridBagConstraints.NORTH;
        gbcLabels.fill = GridBagConstraints.NONE;

        // Add labels to middleMenu with constraints
        middleMenu.add(menuLabel, gbcLabels);
        middleMenu.add(statisticLabel, gbcLabels);
        middleMenu.add(forumLabel, gbcLabels);
        middleMenu.add(gameLabel, gbcLabels);
        middleMenu.add(listeningLabel, gbcLabels);

        // Configure GridBagConstraints for the dabLabel to be at the bottom
        GridBagConstraints gbcImage = new GridBagConstraints();
        gbcImage.gridx = 0;
        gbcImage.gridy = 0;
        gbcImage.weightx = 1.0;
        gbcImage.weighty = 1.0;
        gbcImage.anchor = GridBagConstraints.SOUTH;
        gbcImage.fill = GridBagConstraints.NONE;  // To prevent stretching
        bottomMenu.add(dabLabel, gbcImage);

        bottomMenu.setOpaque(false);

        // Configure GridBagConstraints for rightBackground
        GridBagConstraints gbcRightBackground = new GridBagConstraints();
        gbcRightBackground.gridx = 0;
        gbcRightBackground.gridy = 0;
        gbcRightBackground.weightx = 1.0;
        gbcRightBackground.weighty = 1.0;
        gbcRightBackground.insets = new Insets(80,80,80,80);
        gbcRightBackground.anchor = GridBagConstraints.CENTER;
        gbcRightBackground.fill = GridBagConstraints.BOTH;
        right.add(rightBackground, gbcRightBackground);

        // Set proportions for the split pane
        panel.setLeftComponent(left);
        panel.setRightComponent(right);

        // Add the split pane to JFrame
        this.add(panel, BorderLayout.CENTER);
    }

    // Metoda do skalowania obrazu
    private ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

}
