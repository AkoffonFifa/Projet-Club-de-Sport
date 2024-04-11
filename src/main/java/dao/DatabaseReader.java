package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseReader {

    public static void main(String[] args) throws IOException {
    	printEntireTable();
    }

    @SuppressWarnings("resource")
	private static void printEntireTable() throws IOException {
        try {
            // Establish JDBC connection
            Class.forName("com.mysql.cj.jdbc.Driver");

            BufferedReader reader = null;
    	        reader = new BufferedReader(new FileReader("clubs-data-2019.csv"));
    	        String mySQLURL = null;
	            String username = null;
	            String password = null;
	            String line;
	            int count = 0;
	            while ((line = reader.readLine()) != null && count < 3) {
	                if (count == 0) {
	                    mySQLURL = line.trim();
	                } else if (count == 1) {
	                    username = line.trim();
	                } else if (count == 2) {
	                    password = line.trim();
	                }
	                count++;
	            }
            Connection connection = DriverManager.getConnection(mySQLURL, username, password);

            // Create and execute SQL query
            String query = "SELECT * FROM club";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Print the table content
            System.out.println("Content of the 'Club' table:");
            System.out.println("=====================================");
            while (resultSet.next()) {
                String nom_commune = resultSet.getString("nom_commune");
                int total_epa_club = resultSet.getInt("total_epa_club");
                System.out.println("nom_commune: " + nom_commune );
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private static void printEntireTable0() {
        try {
            // Establish JDBC connection
            Class.forName("com.mysql.cj.jdbc.Driver");

            // JDBC connection parameters
            String mySQLURL = "jdbc:mysql://localhost/clubsdesport"; // database URL
            String username = "root"; // database username
            String password = "root"; // database password 
            Connection connection = DriverManager.getConnection(mySQLURL, username, password);

            // Create and execute SQL query
            String query = "SELECT * FROM irve";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Print the table content
            System.out.println("Content of the 'club' table:");
            System.out.println("=====================================");
            while (resultSet.next()) {
            	 String nom_commune = resultSet.getString("nom_commune");
                 int total_epa_club = resultSet.getInt("total_epa_club");
                System.out.println("nom_commune: " + nom_commune + ", total_epa_club: " + total_epa_club);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
}
