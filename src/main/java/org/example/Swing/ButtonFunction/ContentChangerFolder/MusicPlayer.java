package org.example.Swing.ButtonFunction.ContentChangerFolder;

import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class MusicPlayer {
    private Player player;
    private String currentTrackPath;
    private Thread playThread;

    public MusicPlayer(JPanel targetPanel) {
        this.currentTrackPath = getRandomMusicFile(); // Get a random music file path
        showMusicPlayer(targetPanel);
    }

    public void showMusicPlayer(JPanel targetPanel) {
        targetPanel.removeAll();
        targetPanel.setLayout(new BorderLayout());

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

        musicPlayerPanel.add(playerControlsPanel, BorderLayout.CENTER);

        // Panel dolny z przyciskami
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTH;

        // Text field for user input
        JTextField answerField = new JTextField();
        answerField.setFont(new Font("Arial", Font.PLAIN, 20));
        answerField.setPreferredSize(new Dimension(100,100)); // 90% width, max 30px height
        answerField.setMaximumSize(new Dimension(100,100)); // 90% width, max 30px height
        bottomPanel.add(answerField, gbc);

        // Przycisk "Play"
        gbc.gridy = 2;
        gbc.gridx = 0;
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.PLAIN, 20));
        playButton.addActionListener(e -> playMusic());
        bottomPanel.add(playButton, gbc);

        gbc.gridx = 1;
        JButton stopButton = new JButton("Stop");
        stopButton.setFont(new Font("Arial", Font.PLAIN, 20));
        stopButton.addActionListener(e -> stopMusic());
        bottomPanel.add(stopButton, gbc);

        // Dodanie paneli do targetPanel
        targetPanel.add(musicPlayerPanel, BorderLayout.NORTH);
        targetPanel.add(bottomPanel, BorderLayout.SOUTH);

        targetPanel.revalidate();
        targetPanel.repaint();
    }
    public void playMusic() {
        if (player != null) {
            stopMusic();
        }

        playThread = new Thread(() -> {
            try {
                InputStream is = new FileInputStream(currentTrackPath);
                player = new Player(is);
                player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        playThread.start();
    }

    public void stopMusic() {
        if (player != null) {
            player.close();
            player = null;
        }

        if (playThread != null) {
            playThread.interrupt();
            playThread = null;
        }
    }

    private String getRandomMusicFile() {
        String trackPath = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Random random = new Random();

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/linguospark", "root", "");
            String query = "SELECT name, answer FROM listening ORDER BY RAND() LIMIT 1";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                trackPath = "src/main/resources/img/" + resultSet.getString("name");
                String answer = resultSet.getString("answer");
                System.out.println("Answer: " + answer); // Display the answer
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return trackPath;
    }
}
