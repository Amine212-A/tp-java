# Compte-Rendu TP9 - Programmation Réseau en Java (Sockets UDP, TCP & HTTP)

Ce document présente les travaux pratiques de Java réalisés dans le cadre du module Réseaux & Télécoms à l'**IUT de Rouen**.

---

## 1. Structure du Projet et Instructions

Le projet est organisé dans un dossier `TP9` contenant les sources Java suivantes :

- **Partie 2 : Sockets UDP** (`ClientUDP.java`, `ServeurUDP.java`)
- **Partie 3 : Sockets TCP** 
  - `ClientTCP1.java` / `ServeurTCP1.java` (Communication basique)
  - `ClientTCP2.java` / `ServeurTCP2.java` (Serveur statique / séquentiel avec `while(true)`)
  - `ClientTCP3.java` / `ServeurTCP3.java` (Communication bidirectionnelle avec inversion)
- **Partie 4 : Client HTTP** (`Clienthttp.java`)

### Commandes d'exécution
Se placer dans le dossier `TP9` :
* **Compilation :** `javac *.java`
* **UDP :** `java ServeurUDP` (puis `java ClientUDP` dans un autre terminal)
* **TCP 3 :** `java ServeurTCP3` (puis `java ClientTCP3 "bonjour"` dans un autre terminal)
* **Client HTTP :** `java Clienthttp www.univ-rouen.fr`

---

## 2. Annexe / Compréhension du TP : Questions & Réponses

### Sockets UDP (Partie 2)
* **Quel est le principe des sockets UDP ?**
  L'UDP (User Datagram Protocol) est un protocole non orienté connexion. Aucun lien permanent n'est établi entre le client et le serveur. Les échanges se font via des paquets indépendants appelés datagrammes (`DatagramPacket`) transportés par une `DatagramSocket`.
* **Comment le serveur récupère-t-il l'adresse et le port du client en UDP ?**
  Lors de la réception d'un paquet via `socket.receive(paquet)`, l'objet paquet contient automatiquement l'adresse IP et le port de l'expéditeur. Le serveur peut ainsi utiliser ces informations pour renvoyer une réponse au bon destinataire.

### Sockets TCP (Partie 3)
* **Quelle est la différence entre le TCP unidirectionnel (`TCP1`) et le serveur statique (`TCP2`) ?**
  - `TCP1` traite un unique client, après quoi le serveur s'arrête.
  - `TCP2` intègre une boucle infinie (`while(true)`) autour de la méthode `accept()`, permettant au serveur de rester actif en permanence et d'accepter des clients de manière séquentielle. De plus, le message transmis par le client devient dynamique via les arguments de la ligne de commande (`args[0]`).
* **Comment fonctionne la communication bidirectionnelle (`TCP3`) ?**
  La communication bidirectionnelle permet un échange dans les deux sens :
  1. Le client envoie une chaîne de caractères au serveur.
  2. Le serveur la lit (`readUTF()`), la modifie (par exemple en l'inversant avec `StringBuilder.reverse()`), puis la renvoie au client via un `DataOutputStream`.
  3. Le client récupère la réponse du serveur et l'affiche à l'écran.

### Client HTTP via Socket TCP (Partie 4)
* **Comment un client Java peut-il interagir avec un serveur Web (HTTP) ?**
  Le protocole HTTP s'appuyant sur TCP, le client ouvre une `Socket` standard connectée au **port 80** (le port par défaut du web) de la machine cible (ex: `www.univ-rouen.fr`).
* **Que doit-on envoyer au serveur pour obtenir une page web ?**
  On transmet une requête textuelle brute respectant la syntaxe HTTP, telle que :
  ```text
  GET / HTTP/1.1
  Host: www.univ-rouen.fr
  Connection: close
  <ligne vide obligatoire>






