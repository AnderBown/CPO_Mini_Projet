/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_mingfu_version_graphique;

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
    public void lancerPartie(int nbLignes, int nbColonnes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez indiquer la difficulte souhaite ");
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
            
            // MODIF SELECTION 
            grille.activerEntourageCellules(grille, nbLignes, nbColonnes);
            
            // Incrémenter le compteur de coups
            nbCoups++;
            System.out.println("Nombre de coups joues : " + nbCoups);
        }

        // Toutes les cellules sont éteintes, le joueur a gagné
        System.out.println("Felicitations, vous avez eteint toutes les cellules !");
        System.out.println("Nombre total de coups necessaires : " + nbCoups);
        scanner.close();
    }
 }  
