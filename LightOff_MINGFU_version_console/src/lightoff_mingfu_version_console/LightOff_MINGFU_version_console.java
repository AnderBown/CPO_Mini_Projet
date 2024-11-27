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