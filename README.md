# tp-java
# TP9 - Programmation Réseau en Java (Sockets UDP, TCP & HTTP)

Ce dépôt contient les travaux pratiques de Java réalisés dans le cadre du module Réseaux & Télécoms à l'**IUT de Rouen**.

##   Structure du projet

Le projet est organisé dans un dossier `TP9` contenant les sources Java suivantes :

- **Partie 2 : Sockets UDP**
  - `ClientUDP.java` / `ServeurUDP.java` : Communication unidirectionnelle et bidirectionnelle en UDP.
- **Partie 3 : Sockets TCP**
  - `ClientTCP1.java` / `ServeurTCP1.java` : Communication TCP basique (unidirectionnelle).
  - `ClientTCP2.java` / `ServeurTCP2.java` : Serveur statique multi-clients séquentiel (`while(true)`).
  - `ClientTCP3.java` / `ServeurTCP3.java` : Communication TCP bidirectionnelle avec inversion de chaîne (`StringBuilder.reverse()`).
- **Partie 4 : Client HTTP**
  - `Clienthttp.java` : Client TCP connecté sur le port 80 pour effectuer une requête HTTP GET brute et récupérer le code HTML d'une page web.

---

## Instructions d'exécution

Se placer dans le dossier `TP9` pour compiler et exécuter les différents programmes.

### 1. Compilation générale
Pour compiler l'ensemble des fichiers source :
```bash
javac *.java
