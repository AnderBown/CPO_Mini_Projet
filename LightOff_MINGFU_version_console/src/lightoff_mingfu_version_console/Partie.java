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
    private GrilleDeJeu grille; // Référence à la grille de jeu
    private int nbCoups;        // Nombre de coups joués

    // Constructeur
    public Partie(int nbLignes, int nbColonnes) {
        grille = new GrilleDeJeu(nbLignes, nbColonnes); // Crée la grille avec la taille donnée
        nbCoups = 0;
    }

    // Méthode pour initialiser la partie
    public void initialiserPartie(int difficulte) {
        System.out.println("Initialisation de la grille...");
        grille.melangerMatriceAleatoirement(difficulte); // Mélange la grille avec 10 tours
        System.out.println("Grille melangee !");
        System.out.println(grille);
    }

    // Méthode pour lancer la partie
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        

        // Créer une nouvelle grille avec INPUT user
        
        System.out.println("Bienvenue dans le jeu LightOff !");
        
        System.out.print("Veuillez indiquer les dimentions de la grille ");
        System.out.print("Entrez le nombre de lignes : ");
                int nbLignes = scanner.nextInt();
        System.out.print("Entrez le nombre de colonnes : ");
                int nbColonnes = scanner.nextInt();
        System.out.print("Veuillez indiquer la difficulte souhaite");
                int difficulte = scanner.nextInt();
        grille = new GrilleDeJeu(nbLignes, nbColonnes);
        initialiserPartie(difficulte);

        while (!grille.cellulesToutesEteintes()) {
            
            System.out.print("Entrez le numero de la ligne : ");
                nbLignes = scanner.nextInt();
            System.out.print("Entrez le numero de la colonne : ");
                nbColonnes = scanner.nextInt();

            // Vérifier si les coordonnées sont valides
            while (nbLignes < 0 || nbLignes >= grille.nbLignes || nbColonnes < 0 || nbColonnes >= grille.nbColonnes) 
            {
                System.out.println("Coordonnees invalides ! Veuillez reessayer.");
                // Demander au joueur une ligne et une colonne
                System.out.print("Entrez le numero de la ligne : ");
                nbLignes = scanner.nextInt();
                System.out.print("Entrez le numero de la colonne : ");
                nbColonnes = scanner.nextInt();
            }
            
            
            
            //fin generation grille et selection cellules
            
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