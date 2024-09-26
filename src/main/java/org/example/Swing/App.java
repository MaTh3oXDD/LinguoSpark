package org.example.Swing;

import org.example.Swing.ButtonFunction.ContentChanger;
import org.example.Swing.CustomComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App extends JFrame {
    private ImageIcon dabIcon;
    private JLabel dabLabel;
    private ContentChanger contentChanger;
    private String username;

    public App(String username) {
        super("Linguospark");
        this.username=username;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/LinguoSpark.png"));
        setIconImage(icon.getImage());
        initializeComponent();
        this.setVisible(true);
    }

    public void initializeComponent() {

        JSplitPane panel = new GSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        RoundPanel left = new RoundPanel(0, 50, 0, 50);
        JPanel right = new JPanel(new GridBagLayout());
        JPanel topMenu = new JPanel();
        JPanel bottomMenu = new JPanel();
        JLabel linguoSparkLabel = new JLabel("LinguoSpark");
        RoundLabel menuLabel = new RoundLabel("Menu", Color.decode("#002C60"), 30, 35);
        RoundLabel statisticLabel = new RoundLabel("Statistic", Color.decode("#002C60"), 30, 30);
        RoundLabel gameLabel = new RoundLabel("Game", Color.decode("#002C60"), 30, 30);
        RoundLabel listeningLabel = new RoundLabel("Listening", Color.decode("#002C60"), 30, 30);
        RoundPanel rightBackground = new RoundPanel(30, 30, 30, 30);
        right.setOpaque(false);

        contentChanger = new ContentChanger(rightBackground) ;
        menuLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                contentChanger.showMenuPanel();
            }
        });
        statisticLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                contentChanger.showStatisticPanel(username);
            }
        });

        gameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                contentChanger.showGamePanel();
            }
        });
        listeningLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                contentChanger.showMusicPlayerPanel();
            }
        });
        dabIcon = new ImageIcon(getClass().getResource("/img/LinguoSpark.png"));
        dabLabel = new JLabel(scaleIcon(dabIcon, 100, 100));

        linguoSparkLabel.setFont(new Font("Arial", Font.BOLD, 40));
        linguoSparkLabel.setForeground(Color.decode("#545454"));
        linguoSparkLabel.setHorizontalAlignment(SwingConstants.CENTER);

        left.setLayout(new GridBagLayout());
        panel.setResizeWeight(0.05);
        panel.setEnabled(false);
        panel.setDividerSize(0);

        left.setBackground(Color.decode("#164175"));
        right.setBackground(new Color(0, 0, 0, 0));
        topMenu.setBackground(Color.decode("#164175"));
        bottomMenu.setBackground(Color.decode("#164175"));

        topMenu.setLayout(new GridBagLayout());
        bottomMenu.setLayout(new GridBagLayout());

        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.weightx = 1.0;

        gbcMain.weighty = 0.9;
        gbcMain.anchor = GridBagConstraints.NORTH;
        left.add(topMenu, gbcMain);

        gbcMain.gridy = 1;
        gbcMain.weighty = 0.1;
        gbcMain.anchor = GridBagConstraints.SOUTH;
        left.add(bottomMenu, gbcMain);

        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.gridx = 0;
        gbcTitle.gridy = 0;
        gbcTitle.weightx = 1.0;
        gbcTitle.weighty = 0.0;
        gbcTitle.insets = new Insets(10, 10, 10, 10);
        gbcTitle.anchor = GridBagConstraints.NORTH;
        gbcTitle.fill = GridBagConstraints.HORIZONTAL;
        topMenu.add(linguoSparkLabel, gbcTitle);

        GridBagConstraints gbcSpacer = new GridBagConstraints();
        gbcSpacer.gridx = 0;
        gbcSpacer.gridy = 1;
        gbcSpacer.weightx = 1.0;
        gbcSpacer.weighty = 0.0;
        gbcSpacer.insets = new Insets(40, 0, 0, 0);
        gbcSpacer.anchor = GridBagConstraints.NORTH;
        gbcSpacer.fill = GridBagConstraints.HORIZONTAL;
        topMenu.add(Box.createVerticalStrut(40), gbcSpacer);

        GridBagConstraints gbcLabels = new GridBagConstraints();
        gbcLabels.gridx = 0;
        gbcLabels.gridy = GridBagConstraints.RELATIVE;
        gbcLabels.weightx = 1.0;
        gbcLabels.weighty = 0.0;
        gbcLabels.insets = new Insets(10, 0, 0, 0);
        gbcLabels.anchor = GridBagConstraints.NORTH;
        gbcLabels.fill = GridBagConstraints.NONE;

        topMenu.add(menuLabel, gbcLabels);
        topMenu.add(statisticLabel, gbcLabels);
        topMenu.add(gameLabel, gbcLabels);
        topMenu.add(listeningLabel, gbcLabels);

        GridBagConstraints gbcImage = new GridBagConstraints();
        gbcImage.gridx = 0;
        gbcImage.gridy = 0;
        gbcImage.weightx = 1.0;
        gbcImage.weighty = 1.0;
        gbcImage.anchor = GridBagConstraints.SOUTH;
        gbcImage.fill = GridBagConstraints.NONE;
        bottomMenu.add(dabLabel, gbcImage);

        bottomMenu.setOpaque(false);

        GridBagConstraints gbcRightBackground = new GridBagConstraints();
        gbcRightBackground.gridx = 0;
        gbcRightBackground.gridy = 0;
        gbcRightBackground.weightx = 1.0;
        gbcRightBackground.weighty = 1.0;
        gbcRightBackground.insets = new Insets(80, 80, 80, 80);
        gbcRightBackground.anchor = GridBagConstraints.CENTER;
        gbcRightBackground.fill = GridBagConstraints.BOTH;
        right.add(rightBackground, gbcRightBackground);

        panel.setLeftComponent(left);
        panel.setRightComponent(right);

        this.add(panel, BorderLayout.CENTER);
    }

    private ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

}
