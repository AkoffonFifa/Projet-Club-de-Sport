package model;

public class Club {
    private int codeCommune;
    private String commune;
    private String codeQPV;
    private String nomQPV;
    private int departement;
    private String region;
    private String statutGeo;
    private String codeFede;
    private String nomFederation;
    private int nbrClubs;
    private int nbrEpa;
    private int totalEpaClubs;

    // Constructeur avec tous les paramètres
    public Club(int codeCommune, String commune, String codeQPV, String nomQPV, int departement, 
                String region, String statutGeo, String codeFede, String nomFederation, 
                int nbrClubs, int nbrEpa, int totalEpaClubs) {
        this.codeCommune = codeCommune;
        this.commune = commune;
        this.codeQPV = codeQPV;
        this.nomQPV = nomQPV;
        this.departement = departement;
        this.region = region;
        this.statutGeo = statutGeo;
        this.codeFede = codeFede;
        this.nomFederation = nomFederation;
        this.nbrClubs = nbrClubs;
        this.nbrEpa = nbrEpa;
        this.totalEpaClubs = totalEpaClubs;
    }

    // Setter et Getter pour codeCommune
    public int getCodeCommune() {
        return codeCommune;
    }

    public void setCodeCommune(int codeCommune) {
        this.codeCommune = codeCommune;
    }

    // Setter et Getter pour commune
    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    // Setter et Getter pour codeQPV
    public String getCodeQPV() {
        return codeQPV;
    }

    public void setCodeQPV(String codeQPV) {
        this.codeQPV = codeQPV;
    }

    // Setter et Getter pour nomQPV
    public String getNomQPV() {
        return nomQPV;
    }

    public void setNomQPV(String nomQPV) {
        this.nomQPV = nomQPV;
    }

    // Setter et Getter pour departement
    public int getDepartement() {
        return departement;
    }

    public void setDepartement(int departement) {
        this.departement = departement;
    }

    // Setter et Getter pour region
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    // Setter et Getter pour statutGeo
    public String getStatutGeo() {
        return statutGeo;
    }

    public void setStatutGeo(String statutGeo) {
        this.statutGeo = statutGeo;
    }

    // Setter et Getter pour codeFede
    public String getCodeFede() {
        return codeFede;
    }

    public void setCodeFede(String codeFede) {
        this.codeFede = codeFede;
    }

    // Setter et Getter pour nomFederation
    public String getNomFederation() {
        return nomFederation;
    }

    public void setNomFederation(String nomFederation) {
        this.nomFederation = nomFederation;
    }

    // Setter et Getter pour nbrClubs
    public int getNbrClubs() {
        return nbrClubs;
    }

    public void setNbrClubs(int nbrClubs) {
        this.nbrClubs = nbrClubs;
    }

    // Setter et Getter pour nbrEpa
    public int getNbrEpa() {
        return nbrEpa;
    }

    public void setNbrEpa(int nbrEpa) {
        this.nbrEpa = nbrEpa;
    }

    // Setter et Getter pour totalEpaClubs
    public int getTotalEpaClubs() {
        return totalEpaClubs;
    }

    public void setTotalEpaClubs(int totalEpaClubs) {
        this.totalEpaClubs = totalEpaClubs;
    }
}
