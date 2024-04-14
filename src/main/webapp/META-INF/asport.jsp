<!DOCTYPE html>
<html>
<head>
    <title>Recherche de Clubs</title>
</head>
<body>
<header>
        <h1> Clubs Sportifs</h1>
        <nav>
            <ul>
                <li><a href="">Accueil</a></li>
                <li><a href="">Clubs</a></li>
                <li><a href="">Fédérations</a></li>
                <li><a href="contact.jsp">Contact</a></li>
                <li><a href="inscription.jsp">inscription</a></li>
                <li><a href="connexion.jsp">Connexion</a></li>
            </ul>
        </nav>
    </header>
    <h1>Recherche de Clubs</h1>
    <h2>Recherche par critères</h2>
    <form action="SearchClubsServlet" method="post">
        <label for="club_name">Nom du Club :</label><br>
        <input type="text" id="club_name" name="club_name"><br>
        <!-- Autres critères de recherche -->
        <input type="submit" value="Rechercher">
    </form>
</body>
</html>
