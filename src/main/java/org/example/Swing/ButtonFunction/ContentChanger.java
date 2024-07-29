package org.example.Swing.ButtonFunction;


import org.example.Swing.ButtonFunction.ContentChangerFolder.Game;
import org.example.Swing.ButtonFunction.ContentChangerFolder.GetWords;
import org.example.Swing.ButtonFunction.ContentChangerFolder.MusicPlayer;
import org.example.Swing.ButtonFunction.ContentChangerFolder.Statistic;
import org.example.Swing.CustomComponents.CButton;
import org.example.Swing.CustomComponents.PTextField;
import org.example.Swing.CustomComponents.RoundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContentChanger {
    private JPanel targetPanel;

    public ContentChanger(JPanel targetPanel) {
        this.targetPanel = targetPanel;
    }

    public void showMenuPanel() {
        targetPanel.removeAll();
        targetPanel.setBackground(new Color(0, 0, 0, 0));

        // Panel z obrazem i tekstem "LinguoSpark"
        RoundPanel topPanel = new RoundPanel(50, 50, 0, 0);
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.blue);
        // Ładowanie obrazu
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/linguospark.png"));
        imageIcon = scaleIcon(imageIcon, 100, 100);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Tekst "LinguoSpark"
        JLabel textLabel = new JLabel("LinguoSpark", SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 30));

        topPanel.add(imageLabel, BorderLayout.CENTER);
        topPanel.add(textLabel, BorderLayout.SOUTH);

        // Panel dolny z JTextField i przyciskami
        RoundPanel bottomPanel = new RoundPanel(0, 0, 50, 50);
        bottomPanel.setLayout(new GridBagLayout());
        bottomPanel.setBackground(Color.PINK);
        GridBagConstraints gbc = new GridBagConstraints();

        // JTextField
        PTextField textField = new PTextField();


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        bottomPanel.add(textField, gbc);

        // Przyciski
        CButton button1 = new CButton("Podpowiedź");
        CButton button2 = new CButton("Sprawdź");
        GetWords words = new GetWords(textLabel, textField, button1, button2);
        words.getRandomWord();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                words.help();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                words.checkTranslation();
            }
        });
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        bottomPanel.add(button1, gbc);
        gbc.gridx = 1;
        bottomPanel.add(button2, gbc);

        // Dodanie komponentów do targetPanel
        targetPanel.setLayout(new BorderLayout());
        targetPanel.add(topPanel, BorderLayout.CENTER);
        targetPanel.add(bottomPanel, BorderLayout.SOUTH);

        targetPanel.revalidate();
        targetPanel.repaint();

    }

    public void showStatisticPanel(String username) {
        targetPanel.removeAll();


        JTable table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        Statistic stat = new Statistic(table, username);
        stat.setData();
        targetPanel.setLayout(new BorderLayout());
        targetPanel.add(sp, BorderLayout.CENTER);

        targetPanel.revalidate();
        targetPanel.repaint();

    }

    public void showGamePanel() {
        targetPanel.removeAll();

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Drawing the hangman based on numberOfGuesses
                g.drawLine(50, 250, 200, 250); // base
                g.drawLine(125, 250, 125, 50); // post
                g.drawLine(125, 50, 200, 50); // crossbeam
                g.drawLine(200, 50, 200, 75); // rope

                // Draw hangman parts based on numberOfGuesses
                int numberOfGuesses = Game.getNumberOfGuesses();
                if (numberOfGuesses > 0) g.drawOval(175, 75, 50, 50); // head
                if (numberOfGuesses > 1) g.drawLine(200, 125, 200, 175); // torso
                if (numberOfGuesses > 2) g.drawLine(200, 150, 175, 130); // left arm
                if (numberOfGuesses > 3) g.drawLine(200, 150, 225, 130); // right arm
                if (numberOfGuesses > 4) g.drawLine(200, 175, 175, 200); // left leg
                if (numberOfGuesses > 5) g.drawLine(200, 175, 225, 200); // right leg
            }
        };
        Game game = new Game(drawingPanel);
        String word = game.getRandomWord();
        word = word.toUpperCase(); // Ensure consistency in casing
        JLabel wordLabel = new JLabel("_ ".repeat(word.length()).trim());
        wordLabel.setFont(new Font("Arial", Font.BOLD, 40));
        wordLabel.setHorizontalAlignment(SwingConstants.CENTER);

        game.setSolution(word);

        // Top panel with the word label
        JPanel topPanel = new JPanel();
        topPanel.add(wordLabel);

        // Middle panel for the hangman drawing
        JPanel middlePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        drawingPanel.setPreferredSize(new Dimension(300, 300));
        middlePanel.add(drawingPanel, gbc);

        // Bottom panel with letter buttons
        JPanel bottomPanel = new JPanel(new GridLayout(2, 13));
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char letter : letters.toCharArray()) {
            JButton letterButton = new JButton(String.valueOf(letter));
            letterButton.setFont(new Font("Arial", Font.BOLD, 20));
            letterButton.addActionListener(e -> {
                game.isRight(letterButton, wordLabel);
                drawingPanel.repaint(); // Repaint to update the hangman drawing
            });
            bottomPanel.add(letterButton);
        }

        // Add panels to the targetPanel
        targetPanel.add(topPanel, BorderLayout.NORTH);
        targetPanel.add(middlePanel, BorderLayout.CENTER);
        targetPanel.add(bottomPanel, BorderLayout.SOUTH);

        targetPanel.revalidate();
        targetPanel.repaint();
    }

    public void showMusicPlayerPanel() {
        targetPanel.removeAll();
        targetPanel.setLayout(new BorderLayout());

        // Initialize the music player
        MusicPlayer musicPlayer = new MusicPlayer(targetPanel);

        // Panel do odtwarzania muzyki
        JPanel musicPlayerPanel = new JPanel(new BorderLayout());
        JLabel musicLabel = new JLabel("Music Player");
        musicLabel.setFont(new Font("Arial", Font.BOLD, 30));
        musicLabel.setHorizontalAlignment(SwingConstants.CENTER);
        musicPlayerPanel.add(musicLabel, BorderLayout.NORTH);

        // Music player controls panel
        JPanel playerControlsPanel = new JPanel();
        playerControlsPanel.setLayout(new BoxLayout(playerControlsPanel, BoxLayout.Y_AXIS));
        playerControlsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Text field for user input
        JTextField answerField = new JTextField();
        answerField.setFont(new Font("Arial", Font.PLAIN, 20));
        answerField.setMaximumSize(new Dimension(Integer.MAX_VALUE, answerField.getPreferredSize().height));
        playerControlsPanel.add(answerField);

        musicPlayerPanel.add(playerControlsPanel, BorderLayout.CENTER);

        // Panel dolny z przyciskami
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Przycisk "Play"
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.PLAIN, 20));
        playButton.addActionListener(e -> musicPlayer.playMusic());
        bottomPanel.add(playButton, gbc);

        gbc.gridx = 1;
        JButton stopButton = new JButton("Stop");
        stopButton.setFont(new Font("Arial", Font.PLAIN, 20));
        stopButton.addActionListener(e -> musicPlayer.stopMusic());
        bottomPanel.add(stopButton, gbc);

        // Adding panels to targetPanel
        targetPanel.add(musicPlayerPanel, BorderLayout.NORTH);
        targetPanel.add(answerField, BorderLayout.CENTER);
        targetPanel.add(bottomPanel, BorderLayout.SOUTH);

        targetPanel.revalidate();
        targetPanel.repaint();
    }



    private ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
}
