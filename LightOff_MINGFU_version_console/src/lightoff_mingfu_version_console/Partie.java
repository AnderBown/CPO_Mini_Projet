/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_mingfu_version_console;

import java.util.Scanner;

/**
 *
 * @author AnderBown
 */
public class Partie {
    /** DEMANDE LES VARIABLES UTILISATEURS LIGNE: x COL: J
     * 
     */
/*int x;  //choix de lutiilsateur 
int y;  //choix de lutiilsateur 
int maxX;   // choix de lutiilsateur Valeur maximale de x/ ou encore valeur max de la taille du tableau
int maxY;   // choix de lutiilsateur Valeur maximale de x/ ou encore valeur max de la taille du tableau
GrilleDeJeu grille;

// Vérification des bornes de x
    public void lancerPartie(){
    if (x >= 2 && x <= maxX ) {
        for (int i = x - 1; i <= x + 1; i++) { //boucle pour les changements
            for (int j = y - 1; j <= y + 1; j++) {
                grille.matriceCellules[i][j].activerCellule(); //active la cellule demandee
                System.out.println("Valeur de i : " + i); //sert a rien
            }
        }
    } else {
        System.out.println("x est hors des limites autorisees (2 < x < " + maxX + ").");
    }
    }
    */
    private GrilleDeJeu grille; // Référence à la grille de jeu
    private int nbCoups;        // Nombre de coups joués

    // Constructeur
    public Partie(int nbLignes, int nbColonnes) {
        grille = new GrilleDeJeu(nbLignes, nbColonnes); // Crée la grille avec la taille donnée
        nbCoups = 0;
    }

    // Méthode pour initialiser la partie
    public void initialiserPartie() {
        System.out.println("Initialisation de la grille...");
        grille.melangerMatriceAleatoirement(10); // Mélange la grille avec 10 tours
        System.out.println("Grille initialisee !");
        System.out.println(grille);
    }

    // Méthode pour lancer la partie
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        

        // Créer une nouvelle grille avec les dimensions données
        
        System.out.println("Bienvenue dans le jeu LightOff !");
        initialiserPartie();

        while (!grille.cellulesToutesEteintes()) {
            // Afficher l'état actuel de la grille
            System.out.println("Etat actuel de la grille :");
            System.out.println(grille);
            
            System.out.print("Entrez le numero de la ligne : ");
                int ligne = scanner.nextInt();
            System.out.print("Entrez le numero de la colonne : ");
                int colonne = scanner.nextInt();

            // Vérifier si les coordonnées sont valides
            do  
            {
                System.out.println("Coordonnees invalides ! Veuillez reessayer.");
                // Demander au joueur une ligne et une colonne
                System.out.print("Entrez le numero de la ligne : ");
                ligne = scanner.nextInt();
                System.out.print("Entrez le numero de la colonne : ");
                colonne = scanner.nextInt();
            } while (ligne < 0 || ligne >= grille.nbLignes || colonne < 0 || colonne >= grille.nbColonnes);
            
            grille = new GrilleDeJeu(ligne, colonne);
            
            // Activer la cellule sélectionnée et ses voisines
            System.out.println("Activation de la cellule et de ses voisines...");
            
            /*
            for (int i = Math.max(0, ligne - 1); i <= Math.min(grille.nbLignes - 1, ligne + 1); i++) {
                for (int j = Math.max(0, colonne - 1); j <= Math.min(grille.nbColonnes - 1, colonne + 1); j++) {
                    grille.matriceCellules[i][j].activerCellule();
                }
            }
            */
            for (int i = Math.max(0, ligne - 1); i <= Math.min(grille.nbLignes - 1, ligne + 1); i++) {
                grille.matriceCellules[i][colonne].activerCellule();
            }
            for (int j = Math.max(0, colonne - 1); j <= Math.min(grille.nbColonnes - 1, colonne + 1); j++) {
                grille.matriceCellules[ligne][j].activerCellule();
            }
            
            grille.matriceCellules[ligne][colonne].activerCellule();
            
            
            // Incrémenter le compteur de coups
            nbCoups++;
            System.out.println("Nombre de coups joues : " + nbCoups + 1);
        }

        // Toutes les cellules sont éteintes, le joueur a gagné
        System.out.println("Felicitations, vous avez eteint toutes les cellules !");
        System.out.println("Nombre total de coups necessaires : " + nbCoups);
        scanner.close();
    }
 }  
