package org.example.Swing.ButtonFunction.ContentChangerFolder;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetWords {
    private JLabel label;
    private JTextField textField;
    private  JButton button1;
    private  JButton button2;
    private String sollution;
    private int help=0;

    public GetWords(JLabel label, JTextField textField,JButton button1,JButton button2) {
        this.label = label;
        this.textField = textField;
        this.button1=button1;
        this.button2=button2;
    }

    public void getRandomWord() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/linguospark", "root", "");

            String query = "SELECT c.id as category_id, c.name_category, w.id as word_id, w.ang, w.pol " +
                    "FROM category c " +
                    "JOIN words w ON c.id = w.category_id ";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            List<String[]> words = new ArrayList<>();
            long categoryId = 0;
            String categoryNameResult = null;

            while (resultSet.next()) {
                categoryId = resultSet.getLong("category_id");
                categoryNameResult = resultSet.getString("name_category");
                int wordId = resultSet.getInt("word_id");
                String english = resultSet.getString("ang");
                String polish = resultSet.getString("pol");
                words.add(new String[]{String.valueOf(wordId), english, polish});
            }

            Random random = new Random();

            if (!words.isEmpty()) {
                String[] randomWord = words.get(random.nextInt(words.size()));
                System.out.println("Category ID: " + categoryId);
                System.out.println("Category Name: " + categoryNameResult);
                System.out.println("Random Word ID: " + randomWord[0]);
                System.out.println("  English: " + randomWord[1]);
                sollution=randomWord[1];
                System.out.println("  Polish: " + randomWord[2]);
                System.out.println("---------------------------");
                label.setText(randomWord[2]);
                help=0;

            } else {
                System.out.println("Category ID: " + categoryId);
                System.out.println("Category Name: " + categoryNameResult);
                System.out.println("  No words found in this category.");
                System.out.println("---------------------------");
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
    }

    public void checkTranslation() {
        if(sollution.equals(textField.getText()))
        {
            System.out.println("nice");
            getRandomWord();
            button2.setBackground(Color.green);
            help=0;
        }else
        {
            button2.setBackground(Color.red);
        }
    }
    public void help()
    {
        String answer = "";
        help++;
        if(sollution.length()>=help)
        {
            for(int i =0;i<help;i++)
            {
                answer+=String.valueOf(sollution.charAt(i));
            }
        }else
        {
            getRandomWord();
        }

        textField.setText(answer);
        answer="";
    }
}
