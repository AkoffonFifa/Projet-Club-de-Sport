package dao ;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SendCommuneData {

    public static void main(String[] args) {
        String csvFile = "votre_fichier.csv";
        String line;
        String cvsSplitBy = ",";
        
        // Connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/votre_base_de_donnees";
        String username = "votre_utilisateur";
        String password = "votre_mot_de_passe";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                // Ignorer la première ligne (entêtes)
                br.readLine();
                // Lecture du fichier ligne par ligne
                while ((line = br.readLine()) != null) {
                    // Séparation des valeurs par la virgule
                    String[] data = line.split(cvsSplitBy);
                    String codeCommune = data[0];
                    // Vérification si le code de commune existe déjà dans la base de données
                    if (!codeCommuneExists(conn, codeCommune)) {
                        // Insertion des données dans la base de données
                        String sql = "INSERT INTO Commune (code_commune, nom_commune, code_postal) VALUES (?, ?, ?)";
                        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                            pstmt.setString(1, codeCommune); // Code_commune
                            pstmt.setString(2, data[1]); // Nom_commune
                            pstmt.setString(3, data[2]); // Region
                            pstmt.executeUpdate();
                        }
                    } else {
                        System.out.println("Le code de commune " + codeCommune + " existe déjà dans la base de données. Ignoré.");
                    }
                }
                System.out.println("Données insérées avec succès dans la base de données !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean codeCommuneExists(Connection conn, String codeCommune) throws Exception {
        String sql = "SELECT Code_commune FROM Commune WHERE Code_commune = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codeCommune);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Retourne true si le code de commune existe déjà, sinon false
            }
        } 
    }
}
