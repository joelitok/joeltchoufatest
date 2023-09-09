PARTIE THEORIQUE

1) Retourner tous les éléments book
- reponse : //book

2) Retourner tous les éléments title ayant comme parent un élément book avec un attribut type égal à roman
- reponse : //book[@type='roman']/title

3) Retourner le nombre d'éléments book ayant un attribut type égal à bd
- reponse : count(//book[@type='bd'])

4) Que renvoie la requête XPath suivante :  /library/library/ancestor-or-self::library
- reponse :
  La requête XPath /library/library/ancestor-or-self::library
  renverra tous les ancêtres de l'élément <library> actuel, y compris lui-même. Cependant, dans votre exemple XML, il y a seulement un élément <library> qui contient un autre élément <library>.

-<library>
<book type="roman">
<title>toto5</title>
<author>titi</author>
</book>
</library>

NB: Vous trouverez dans le dossier bd present dans ressource la collection postman.
Le jeux de donnée se trouvant dans le fichier personne.sql à importer dans la base une donnée SQL.
le port de l'application est : 2022

- endpoint du service
- pour ajouter: localhost:2022/personne/create
- pour recuperer la liste: http://localhost:2022/personnes