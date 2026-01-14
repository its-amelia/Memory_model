# Memory Model - Simulation du Jeu de Memory

## Description

Simulation d'un jeu de memory avec modèle cognitif basé sur la trace mnésique et les différences liées à l'âge.

## Mécaniques

### Phase 1 : Mémorisation Initiale
- **Jeunes** : mémorisent 2 paires
- **Âgés** : mémorisent 1 paire

### Phase 2 : Jeu
- Retourner 2 cartes par tour
- Paire trouvée = cartes restent visibles
- Mauvaise paire = cartes retournées face cachée
- Fin du jeu : 9 paires trouvées

## Dégradation Mémoire

À chaque tour, la valeur mémorielle diminue :
- **Jeunes** : -0.1 par tour
- **Âgés** : -0.3 par tour

## Probabilité de Succès

```
traceMnesique = (valeur_carte1 + valeur_carte2) / 2
succès = traceMnesique × p_rappel
```

- **Jeunes** : p_rappel = 0.95
- **Âgés** : p_rappel = 0.45

## Structure

```
src/
├── Carte.java
├── Monstre.java
├── Grille.java
├── Participant.java
└── Simulation.java
```

## Utilisation

```bash
javac src/*.java
java -cp src Simulation
```

Génère un fichier CSV avec 1000 simulations par groupe.

Teyssandier Jeanne, Lama Adodo Joyce, Mahdjoub Amélia
L3 MIASHS

