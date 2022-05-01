# INF600E - Travail de Session - Leia

Le langage, qui se nomme Leia, sert à dessiner des traits et donc, des formes pour pouvoir dessiner.

## Description

Ce langage sert à dessiner des traits de la grosseur souhaitée et de la couleurs souhaitée à la position souhaité.
Leia sert à dessiner des formes à l'écran.

## Commencement

### Dépendances

Voici les prérequis et les librairies à installer :
* Java
* SableCC
* Java Swing
* Java Awt

### Installation

Premièrement, il faut [télécharger](https://sablecc.org/downloads) la dernière version stable de SableCC (sablecc-3.7). Vous pouvez suivre la [documentation](https://sablecc.org/documentation) de SableCC.

Il faut aussi s'assurer d'avoir Java à jour sur son poste de travail.

Après le téléchargement de SableCC et après avoir dézippé le dossier, vous vous retrouver avec le répertoire contenant le projet SableCC. Ensuite vous prenez le fichier `sablecc.jar` qui se trouve à cet endroit : `sablecc-3.7/lib/sablecc.jar` et vous le mettez à la racine du Projet, sous le répertoire `INF600E-TravailleSession/Projet/`.

Ensuite, dans un terminal, dans le répertoire de notre projet, vous faite la commande suivante pour générer les fichiers nécéssaire à la grammaire de ce projet :

```
java -jar sablecc.jar projet.sablecc
```

Il faut que la syntaxe de ce projet, le répertoire `syntax`, soit à cet endroit : `INF600ETravailleSession/Projet/src/projet`.


### Exécution du programme

Pour faire rouler le programme, veuillez faire la commande qui suit : 

```
java
```

Aussi, vous pouvez remplacer le fichier `drapeau.logo` par un des autres fichiers avec l'extension logo qui se trouve dans notre projet.

Les fichiers de tests sont `etoile.logo`, `drapeau.logo`, `carree.logo` et `pyramide.logo`.

## Aide

Si le programme plante, recommancer l'éxécution du programme.
Si un problème innatendu perisite, veuillez contacter l'un des autheurs.

## Autheurs

Les autheurs et leurs courriel : 

Jérémy Dionne-Nadeau  
[Courriel de Jérémy](mailto:jeremydionnenadeau@gmail.com)

César Augusto Moreno Agudelo  
[Courriel de César](mailto:ceaumo.1@gmail.com)

## License

Voir LICENSE.md pour plus de détails.
