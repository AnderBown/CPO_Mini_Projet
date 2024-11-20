/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightoff_mingfu_version_console;

import java.util.Scanner;

/**
 *
 * @author AnderBown
 */
public class LightOff_MINGFU_version_console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        CelluleLumineuse cellule = new CelluleLumineuse();
        System.out.println(cellule); 
        
        cellule.activerCellule();
        System.out.println(cellule); 
        
        cellule.eteindreCellule();
        System.out.println(cellule);
        */
        
        /*
        GrilleDeJeu grille = new GrilleDeJeu(8, 8);
        System.out.println(grille);

        grille.activerLigneDeCellules(2);
        grille.activerColonneDeCellules(3);
        grille.activerDiagonaleDescendante();
        grille.activerDiagonaleMontante();
        System.out.println(grille);

        grille.melangerMatriceAleatoirement(10);
        System.out.println(grille);

        System.out.println("Toutes les cellules sont eteintes ? " + grille.cellulesToutesEteintes());
        
        /*
        Partie partie = new Partie();
        partie.x = 3;          // Position choisie par l'utilisateur (ligne)
        partie.y = 2;          // Position choisie par l'utilisateur (colonne)
        partie.grille = grille; // Association de la grille à la partie

        // Lancer la partie
        partie.lancerPartie();

        // Afficher l'état de la grille après activation
        System.out.println(grille);
        */
        // Demander à l'utilisateur la taille de la grille
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nombre de lignes de la grille : ");
        int nbLignes = scanner.nextInt();
        System.out.print("Entrez le nombre de colonnes de la grille : ");
        int nbColonnes = scanner.nextInt();

        // Créer une nouvelle partie avec la taille de grille donnée
        Partie partie = new Partie(nbLignes, nbColonnes);
        
        partie.lancerPartie();
        scanner.close();
    }
    
}
