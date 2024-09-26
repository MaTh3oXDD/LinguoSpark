package org.example.Swing.ButtonFunction.ContentChangerFolder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private static String solution;
    private static int numberOfGuesses = 0;
    private static int maxGuesses = 6;
    private static JPanel drawingPanel;

    public Game(JPanel drawingPanel) {
        Game.drawingPanel = drawingPanel;
    }

    public static String getRandomWord() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> data = new ArrayList<>();
        Random random = new Random();

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/linguospark", "root", "");
            String query = "SELECT ang FROM words;";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                data.add(resultSet.getString("ang"));
            }

            if (!data.isEmpty()) {
                int randomIndex = random.nextInt(data.size());
                return data.get(randomIndex).toUpperCase();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static void setSolution(String solution) {
        Game.solution = solution;
    }

    public static int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public static void isRight(JButton button, JLabel label) {
        char guessedLetter = button.getText().charAt(0);
        boolean found = false;
        StringBuilder newDisplay = new StringBuilder(label.getText());

        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guessedLetter) {
                newDisplay.setCharAt(i * 2, guessedLetter);
                found = true;
            }
        }

        label.setText(newDisplay.toString());

        if (!found) {
            numberOfGuesses++;
            System.out.println("Litera '" + guessedLetter + "' nie znajduje się w słowie. Próby: " + numberOfGuesses);
        } else {
            System.out.println("Litera '" + guessedLetter + "' znajduje się w słowie.");
        }


        if (newDisplay.indexOf("_") == -1) {
            label.setText("Wygrałeś!");
            endGameWithMessage(label, "Wygrałeś!");
        } else if (numberOfGuesses >= maxGuesses) {
            label.setText("Przegrałeś");
            endGameWithMessage(label, "Przegrałeś!");
        }
    }

    private static void endGameWithMessage(JLabel label, String message) {
        label.setText(message);


        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame(label);
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    private static void resetGame(JLabel label) {
        numberOfGuesses = 0;
        String newWord = getRandomWord();
        setSolution(newWord);
        label.setText("_ ".repeat(newWord.length()).trim());

    }

    public static void updateHangmanDrawing() {
        if (drawingPanel != null) {
            drawingPanel.repaint();
        }
    }
}
