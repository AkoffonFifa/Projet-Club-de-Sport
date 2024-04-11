package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClubDataParser {

    public static void main(String[] args) {
        String csvFilePath = "lib/clubs-data-2019.csv";
        String outputFilePath = "Scripts SQL/Insert_Club.sql";
        parseClubData(csvFilePath, outputFilePath);
    }

    private static void parseClubData(String csvFilePath, String outputFilePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFilePath), StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, StandardCharsets.UTF_8))) {

            reader.lines().skip(1) // Skip the header line
                    .forEach(line -> {
                        // Remove quotes and invisible characters from the line
                        line = line.replaceAll("\"", "").replaceAll("\\p{C}", "");
                        String[] columns = line.split(";");

                        if (columns.length >= 12) {
                            String codeCommune = escapeSingleQuotes(columns[0].trim());
                            String commune = escapeSingleQuotes(columns[1].trim());
                            String codeQPV = escapeSingleQuotes(columns[2].trim());
                            String nomQPV = escapeSingleQuotes(columns[3].trim());
                            String departement = escapeSingleQuotes(columns[4].trim());
                            String region = escapeSingleQuotes(columns[5].trim());
                            String statutGeo = escapeSingleQuotes(columns[6].trim());
                            String code = escapeSingleQuotes(columns[7].trim());
                            String federation = escapeSingleQuotes(columns[8].trim());
                            int clubs = Integer.parseInt(columns[9].trim());
                            int epa = Integer.parseInt(columns[10].trim());
                            int total = Integer.parseInt(columns[11].trim());

                            try {
                                // Write the insertion query for the Club table
                                writer.write("INSERT INTO Club (code_commune, nom_commune, code_qpv, nom_qpv, deprtement, region, statut_geo, code_fede, nom_federation, nbr_clubs, nbr_epa, total_epa_clubs)\n");
                                writer.write("VALUES ('" + codeCommune + "', '" + commune + "', '" + codeQPV + "', '" + nomQPV + "', '" + departement + "', '" + region + "', '" + statutGeo + "', '" + code + "', '" + federation + "', " + clubs + ", " + epa + ", " + total + ");\n");

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Les requêtes INSERT pour les clubs ont bien été stockées dans le fichier Insert_Club.sql");
    }

    private static String escapeSingleQuotes(String str) {
        return str.replace("'", "''");
    }
}
