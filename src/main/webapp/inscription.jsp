<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription - Plate-forme des Clubs Sportifs</title>
    <link rel="stylesheet" href="NewFile.css">
</head>
<body>
    <header>
        <h1>Inscription</h1>
        <nav>
            <ul>
                <li><a href="NewFile.jsp">Accueil</a></li> 
                <li><a href="#">Clubs</a></li>
                <li><a href="#">Fédérations</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section>
            <h2>Inscription</h2>
            <form action="traitement.php" method="post">
                <div>
                    <label for="nom">Nom :</label>
                    <input type="text" id="nom" name="nom" required>
                </div>
                <div>
                    <label for="prenom">Prénom :</label>
                    <input type="text" id="prenom" name="prenom" required>
                </div>
                <div>
                    <label for="email">Adresse email :</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div>
                    <label for="motdepasse">Mot de passe :</label>
                    <input type="password" id="motdepasse" name="motdepasse" required>
                </div>
                 <div>
                   <div>
                    <p>Statut :</p>
                    <label><input type="radio" name="statut" value="elu" required> Elu</label>
                    <label><input type="radio" name="statut" value="acteur" required> Acteur du monde sportif</label>
                </div>
                <button type="submit">S'inscrire</button>
            </form>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 Plate-forme des Clubs Sportifs. Tous droits réservés.</p>
    </footer>
</body>
</html>