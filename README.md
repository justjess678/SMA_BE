# SMA_BE
## Besoins initiaux
Dans ce système, l’utilisateur a besoin de suffisamment de lumière pour être confortable tout en consommant le moins d’électricité possible. Le système comportera les lumières (intelligentes) dont il a besoin, les dispositifs permettant de connaître la consommation d’électricité et des capteurs de luminosité à l’intérieur et à l’extérieur ainsi qu’un système de gestion de feedback des utilisateurs.


## Besoins fonctionnels
## Besoins non-fonctionnels
Gestion des lumières en fonction de la luminosité de la pièce et de la consommation
Minimisation de consommation d’électricité


Ne doit pas gêner les cours/personnes dans la salle (taille, bruit, encombrement, etc…)
Prise en compte des retours des utilisateurs
Minimiser les coûts
Caractérisation de l’environnement


Entités actives
Entités passives
Contraintes
Lumières
Volets
Capteurs de luminosité
Dispositif qui mesure l’énergie consommée
Les personnes dans la salle
Les lumières doivent compléter la lumière déjà présente pour allumer correctement la pièce (eg: si le soleil fournit 80% de luminosité “confortable”, les lumières fourniront le 20% restant)
-
Le système est accessible car la valeur de la luminosité de la pièce et la valeur de la quantité d’électricité sont partagées avec les autres agents dès qu’ils sont captés.
Le système est déterministe: si la luminosité baisse, les lumières augmentent leur luminosité, et inversement.
Le système est dynamique car l’environnement peut changer pendant que les lumières calculent leur luminosité (les cours pourraient finir, le soleil se lèvera, etc…)
Le système est continu car la luminosité émise est toujours en train de s’auto réguler en fonction de la luminosité entrante et sa consommation d’énergie.
## Identifiez les agents
### Caractéristiques des entités
#### Les lumières
Sont autonomes
Poursuivent un but local (allumer confortablement la pièce)
Doit interagir avec les autres entités (se sert des informations des capteurs divers pour faire ses choix, sa luminosité influe la valeur captée par les capteurs de luminosité)
Elles possèdent une vue partielle de l’environnement (ne connaît que les valeurs de la luminosité de la pièce des endroits où se trouvent les capteurs)
#### Les volets
Sont autonomes
Poursuivent un but local (allumer confortablement la pièce)
Doit interagir avec les autres entités (se sert des informations des capteurs divers pour faire ses choix, sa luminosité influe la valeur captée par les capteurs de luminosité)
Elles possèdent une vue partielle de l’environnement (ne connaît que les valeurs de la luminosité de la pièce des endroits où se trouvent les capteurs)
#### Les capteurs de luminosité
Ne sont pas autonomes
Ne poursuit pas de but local
Ne doit pas interagir directement avec les autres entités (envoie des valeurs captées)
Elles possèdent une vue partielle de l’environnement (elles ne connaissent que la valeur de la luminosité de là où elles se trouvent)
#### Dispositif qui mesure l’énergie consommée
Ne sont pas autonomes
Ne poursuit pas de but local
Ne doit pas interagir directement avec les autres entités (envoie des valeurs captées)
Il possède une vue partielle de l’environnement (ne perçoit que les informations sur l’énergie consommée)
Les utilisateurs (élèves, professeurs, etc…)
Sont autonomes
Ne poursuivent pas de but local (dans ce système)
N'interagit pas directement avec les autres entités
Possèdent une vue partielle de l’environnement
## Concevoir les agents
Les entités qui sont agents sont les lumières et les volets
### Les Lumières
Compétences: connaît la luminosité actuelle et la valeur de luminosité à maintenir
Aptitudes: Peut baisser ou augmenter sa luminosité en fonction de la luminosité présente et de sa consommation
Langage d'interaction: directe
Représentation du monde: construit autour de la luminosité et énergie consommée par les agents
Situations non coopératives
Perception
Incompréhension
Ambiguïté
Décision
Incompétence
Improductivité
Action
Concurrence
Conflit
Inutilité
### Les Volets
Compétences: connaît la luminosité actuelle et la valeur de luminosité à maintenir
Aptitudes: Peut se baisser ou se lever pour faire varier la luminosité en fonction de la luminosité présente et de la consommation
Langage d'interaction: directe
Représentation du monde: construit autour de la luminosité et énergie consommée par les agents
Situations non coopératives
Perception
Incompréhension
Ambiguïté
Décision
Incompétence
Improductivité
Action
Concurrence
Conflit
Inutilité
## Préparer la simulation
Cette simulation sera de type “Agent based” (centrée autour des agents), et les entités extérieurs à simuler sont les utilisateurs, les capteurs de lumière et d’électricité et le cycle jour/nuit. On pourra les simuler en leur associant tous des valeurs (valeur de la luminosité dans la pièce, valeur du feedback des utilisateurs etc…).
Je pense utiliser Java pour simuler ce système; l’approche centré-agent est favorable à une programmation orientée objet.
## Tests à faire:


## Métriques d’évaluation:
