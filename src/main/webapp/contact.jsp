<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact - Plate-forme des Clubs Sportifs</title>
    <link rel="stylesheet" href="NewFile.css"> <!-- Lien vers votre fichier de styles CSS -->
</head>
<body>
  <header>
    <h1>Clubs Sportifs</h1>
    <nav>
        <ul>
            <li><a href="NewFile.jsp">Accueil</a></li>
            <li><a href="">Clubs</a></li>
            <li><a href="">Fédérations</a></li>
            <li><a href="inscription.jsp">Inscription</a></li>
            <li><a href="connexion">Connexion</a></li>
        </ul>
    </nav>
</header>

    <main>
        <section>
            <h2>Contactez-nous</h2>
            <form action="traitement_contact.php" method="post">
                <div>
                    <label for="nom">Nom :</label>
                    <input type="text" id="nom" name="nom" required>
                </div>
                <div>
                    <label for="email">Adresse email :</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div>
                    <label for="message">Message :</label>
                    <textarea id="message" name="message" required></textarea>
                </div>
                <button type="submit">Envoyer</button>
            </form>
        </section>
          <section>
            <h2>Pas de réponse? </h2>
            <p>appelez le 00000000000  Merci</p>
            
        </section>
    </main>

      <jsp:include page="footer.jsp" />

    <script src="script.js"></script> <!-- Lien vers votre fichier JavaScript -->
</body>
</html>
