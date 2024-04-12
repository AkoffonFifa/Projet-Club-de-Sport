package model;

public class Utilisateur {
	    private int id;
	    private String nom;
	    private String prenom;
	    private String email;
	    private String motDePasse;
	    private String role;

	    // Constructeur avec paramètres
	    public Utilisateur(int id, String nom, String prenom, String email, String motDePasse, String role) {
	        this.id = id;
	        this.nom = nom;
	        this.prenom = prenom;
	        this.email = email;
	        this.motDePasse = motDePasse;
	        this.role = role;
	    }

	    // Getter pour l'ID de l'utilisateur
	    public int getId() {
	        return id;
	    }

	    // Setter pour l'ID de l'utilisateur
	    public void setId(int id) {
	        this.id = id;
	    }

	    // Getter pour le nom de l'utilisateur
	    public String getNom() {
	        return nom;
	    }

	    // Setter pour le nom de l'utilisateur
	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    // Getter pour le prénom de l'utilisateur
	    public String getPrenom() {
	        return prenom;
	    }

	    // Setter pour le prénom de l'utilisateur
	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }

	    // Getter pour l'email de l'utilisateur
	    public String getEmail() {
	        return email;
	    }

	    // Setter pour l'email de l'utilisateur
	    public void setEmail(String email) {
	        this.email = email;
	    }

	    // Getter pour le mot de passe de l'utilisateur
	    public String getMotDePasse() {
	        return motDePasse;
	    }

	    // Setter pour le mot de passe de l'utilisateur
	    public void setMotDePasse(String motDePasse) {
	        this.motDePasse = motDePasse;
	    }

	    // Getter pour le rôle de l'utilisateur
	    public String getRole() {
	        return role;
	    }

	    // Setter pour le rôle de l'utilisateur
	    public void setRole(String role) {
	        this.role = role;
	    }

	    // Méthode toString pour afficher les informations de l'utilisateur
	    @Override
	    public String toString() {
	        return "Utilisateur{" +
	                "id=" + id +
	                ", nom='" + nom + '\'' +
	                ", prenom='" + prenom + '\'' +
	                ", email='" + email + '\'' +
	                ", motDePasse='" + motDePasse + '\'' +
	                ", role='" + role + '\'' +
	                '}';
	    }

}
