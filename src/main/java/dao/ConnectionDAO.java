package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entiter.Club;

public class ConnectionDAO {
    // Paramètres de connexion JDBC
    private Connection con = null;

    public ConnectionDAO() {
        // Charger le driver MySQL lors de la création d'une instance de cette classe
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Gérer l'erreur ici. Peut-être le journaliser et lancer une exception personnalisée
            e.printStackTrace();
        }
    }

    protected void dbConnect() throws SQLException {
        BufferedReader reader;
        try {
            // Lire le fichier database.txt pour obtenir les informations de connexion
            String mySQLURL = null;
            String username = null;
            String password = null;
            String line;
            int count = 0;
            reader = new BufferedReader(new FileReader("lib/clubs-data-2019.csv"));
            //Parcourir le fichier et extraire les informations de connexion
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
            // Établir une connexion à la base de données en utilisant les informations de connexion
            if (mySQLURL != null && username != null && password != null) {
                con = DriverManager.getConnection(mySQLURL, username, password);
                System.out.println("Connexion à la base de données établie avec succès !");
            } else {
                throw new SQLException("Paramètres de connexion JDBC manquants dans clubs-data-2019.csv");
            }
        } catch (IOException e) {
            throw new SQLException("Erreur lors de la lecture de database.txt: " + e.getMessage());
        }
    }

    protected void dbClose() throws SQLException {
        // Fermer la connexion à la base de données si elle est ouverte
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public Club getClubByCommune_n_Fede(int codeCommune, int codeFede) {
        Club club = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            dbConnect();
            String sql = "SELECT * FROM Club WHERE code_commune = ? AND code_fede = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, codeCommune);
            stmt.setInt(2, codeFede);
            rs = stmt.executeQuery();
            if (rs.next()) {
                // Créer une instance de Club en récupérant les données de la base de données
            	club = new Club(
                        rs.getInt("code_commune"),
                        rs.getString("commune"),
                        rs.getString("code_qpv"),
                        rs.getString("nom_qpv"),
                        rs.getInt("departement"),
                        rs.getString("region"),
                        rs.getString("statut_geo"),
                        rs.getString("code_fede"),
                        rs.getString("nom_federation"),
                        rs.getInt("nbr_clubs"),
                        rs.getInt("nbr_epa"),
                        rs.getInt("total_epa_clubs")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources ResultSet, PreparedStatement et la connexion à la base de données
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    dbClose();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return club;
    }

    public Club getClubByCodeFede(int codeFede) {
        Club club = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            dbConnect();
            String sql = "SELECT * FROM Club WHERE code_fede = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, codeFede);
            rs = stmt.executeQuery();
            if (rs.next()) {
            	
            	club = new Club(
                        rs.getInt("code_commune"),
                        rs.getString("commune"),
                        rs.getString("code_qpv"),
                        rs.getString("nom_qpv"),
                        rs.getInt("departement"),
                        rs.getString("region"),
                        rs.getString("statut_geo"),
                        rs.getString("code_fede"),
                        rs.getString("nom_federation"),
                        rs.getInt("nbr_clubs"),
                        rs.getInt("nbr_epa"),
                        rs.getInt("total_epa_clubs")
                        );    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    dbClose();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return club;
    }

    public Club getClubByRegion(Integer codeCommune, Integer codeFede, String region) {
        Club club = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            dbConnect();
            StringBuilder sqlBuilder = new StringBuilder(
                    "SELECT * FROM Club WHERE 1 = 1");

            if (codeCommune != null) {
                sqlBuilder.append(" AND codeCommune = ?");
            }
            if (codeFede != null) {
                sqlBuilder.append(" AND code_fede = ?");
            }
            if (region != null && !region.isEmpty()) {
                sqlBuilder.append(" AND region = ?");
            }

            stmt = con.prepareStatement(sqlBuilder.toString());

            int paramIndex = 1;
            if (codeCommune != null) {
                stmt.setInt(paramIndex++, codeCommune);
            }
            if (codeFede != null) {
                stmt.setInt(paramIndex++, codeFede);
            }
            if (region != null && !region.isEmpty()) {
                stmt.setString(paramIndex++, region);
            }

            rs = stmt.executeQuery();
            if (rs.next()) {
            	 club = new Club(
                         rs.getInt("code_commune"),
                         rs.getString("commune"),
                         rs.getString("code_qpv"),
                         rs.getString("nom_qpv"),
                         rs.getInt("departement"),
                         rs.getString("region"),
                         rs.getString("statut_geo"),
                         rs.getString("code_fede"),
                         rs.getString("nom_federation"),
                         rs.getInt("nbr_clubs"),
                         rs.getInt("nbr_epa"),
                         rs.getInt("total_epa_clubs")
                 );
            }
           } 
        catch (SQLException e) {
            e.printStackTrace();
     } finally {
         try {
             if (rs != null) rs.close();
             if (stmt != null) stmt.close();
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             try {
                 dbClose();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
        }
        return club;
    }
}
