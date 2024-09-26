package org.example.Swing.ButtonFunction.ContentChangerFolder;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class Statistic {
    private JTable table;
    private String username;

    public Statistic(JTable table, String username) {
        this.table = table;
        this.username = username;
    }

    public void setData() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/linguospark", "root", "");

            String query = "SELECT c.username, cat.name_category, SUM(e.error_count) AS total_errors " +
                    "FROM client c " +
                    "INNER JOIN errors e ON c.id = e.client_id " +
                    "INNER JOIN words w ON e.word_id = w.id " +
                    "INNER JOIN category cat ON w.category_id = cat.id " +
                    "WHERE c.username = ? " +
                    "GROUP BY c.username, cat.name_category " +
                    "ORDER BY c.username, cat.name_category";

            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            ArrayList<Object[]> data = new ArrayList<>();
            while (resultSet.next()) {
                String user = resultSet.getString("username");
                String category = resultSet.getString("name_category");
                int totalErrors = resultSet.getInt("total_errors");

                data.add(new Object[]{user, category, totalErrors});
            }

            String[] columnNames = {"Username", "Category", "Total Errors"};
            Object[][] tableData = data.toArray(new Object[0][]);
            table.setModel(new javax.swing.table.DefaultTableModel(tableData, columnNames));

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
}
