/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_mingfu_version_console;

import java.util.Random;

/**
 *
 * @author AnderBown
 */
public class GrilleDeJeu {
    
    CelluleLumineuse[][] matriceCellules; // Grille de cellules lumineuses
    int nbLignes; // Nombre de lignes
    int nbColonnes; // Nombre de colonnes

    // Constructeur
    public GrilleDeJeu(int p_nbLignes, int p_nbColonnes) {
        this.nbLignes = p_nbLignes;
        this.nbColonnes = p_nbColonnes;
        this.matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];
        // Initialisation de chaque cellule
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }

    // Méthode pour éteindre toutes les cellules
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }

    // Méthode pour activer une ligne, une colonne ou une diagonale aléatoire
    public void activerLigneColonneOuDiagonaleAleatoire() {
        Random random = new Random();
        int choix = random.nextInt(3); // 0 = ligne, 1 = colonne, 2 = diagonale
        if (choix == 0) {
            int idLigne = random.nextInt(nbLignes);
            activerLigneDeCellules(idLigne);
        } else if (choix == 1) {
            int idColonne = random.nextInt(nbColonnes);
            activerColonneDeCellules(idColonne);
        } else {
            if (random.nextBoolean()) {
                activerDiagonaleDescendante();
            } else {
                activerDiagonaleMontante();
            }
        }
    }

    // Mélanger la grille aléatoirement

    public void melangerMatriceAleatoirement(int nbTours) {
        eteindreToutesLesCellules(); 
        Random random = new Random();
        for (int i = 0; i < nbTours; i++) {
            int ligne = random.nextInt(nbLignes);
            int colonne = random.nextInt(nbColonnes);
            declencherClique(ligne, colonne);
        }
    }

    
    private void declencherClique(int ligne, int colonne) {
        
        matriceCellules[ligne][colonne].activerCellule();
        
        if (ligne > 0) matriceCellules[ligne - 1][colonne].activerCellule(); // 上
        if (ligne < nbLignes - 1) matriceCellules[ligne + 1][colonne].activerCellule(); // 下
        if (colonne > 0) matriceCellules[ligne][colonne - 1].activerCellule(); // 左
        if (colonne < nbColonnes - 1) matriceCellules[ligne][colonne + 1].activerCellule(); // 右
    }

    // Activer une ligne spécifique
    public void activerLigneDeCellules(int idLigne) {
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[idLigne][j].activerCellule();
        }
    }

    // Activer une colonne spécifique
    public void activerColonneDeCellules(int idColonne) {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][idColonne].activerCellule();
        }
    }

    // Activer la diagonale descendante
    public void activerDiagonaleDescendante() {
        int taille = Math.min(nbLignes, nbColonnes);
        for (int i = 0; i < taille; i++) {
            matriceCellules[i][i].activerCellule();
        }
    }

    // Activer la diagonale montante
    public void activerDiagonaleMontante() {
        int taille = Math.min(nbLignes, nbColonnes);
        for (int i = 0; i < taille; i++) {
            matriceCellules[i][nbColonnes - 1 - i].activerCellule();
        }
    }

    // Vérifier si toutes les cellules sont éteintes
    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].estEteint()) {
                    return false;
                }
            }
        }
        return true;
    }

    // Redéfinition de toString pour afficher la grille
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (int j = 0; j < nbColonnes; j++) {
            sb.append("| ").append(j).append(" ");
        }
        sb.append("|\n");
        sb.append("-".repeat(4 * nbColonnes + 4)).append("\n");

        for (int i = 0; i < nbLignes; i++) {
            sb.append(i).append(" | ");
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(matriceCellules[i][j].toString()).append(" | ");
            }
            sb.append("\n");
            sb.append("-".repeat(4 * nbColonnes + 4)).append("\n");
        }
        return sb.toString();
    } 
}