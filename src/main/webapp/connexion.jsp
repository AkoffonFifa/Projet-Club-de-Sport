<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion - Plate-forme des Clubs Sportifs</title>
    <link rel="stylesheet" href="NewFile.css"> 
</head>
<body>
    
  <header>
    <h1>Clubs Sportifs</h1>
    <nav>
        <ul>
            <li><a href="NewFile.jsp">Accueil</a></li>
            <li><a href="">Clubs</a></li>
            <li><a href="">Fédérations</a></li>
            <li><a href="">Contact</a></li>
            <li><a href="inscription.jsp">Inscription</a></li>
          
        </ul>
    </nav>
</header>
   
    <main>
        <section>
            <h2>Connexion</h2>
            <form action="traitement_connexion.jsp" method="POST">
                <label for="username">Nom d'utilisateur :</label><br>
                <input type="text" id="username" name="username" required><br>
                <label for="password">Mot de passe :</label><br>
                <input type="password" id="password" name="password" required><br><br>
                <button type="submit">Se connecter</button>
            </form>
        </section>
    </main>

    

   
</body>
/* Inclusion du footer */
    <jsp:include page="footer.jsp" />
</html>
