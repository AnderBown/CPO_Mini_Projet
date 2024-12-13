package lightoff_mingfu_version_graphique;

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
        
        if (ligne > 0) matriceCellules[ligne - 1][colonne].activerCellule(); 
        if (ligne < nbLignes - 1) matriceCellules[ligne + 1][colonne].activerCellule(); 
        if (colonne > 0) matriceCellules[ligne][colonne - 1].activerCellule(); 
        if (colonne < nbColonnes - 1) matriceCellules[ligne][colonne + 1].activerCellule(); 
    }
    
    public void activerEntourageCellules(GrilleDeJeu grille, int nbLignes, int nbColonnes) {
    // Activer la cellule sélectionnée et ses voisines
            for (int i = Math.max(0, nbLignes - 1); i <= Math.min(grille.nbLignes - 1, nbLignes + 1); i++) {
                grille.matriceCellules[i][nbColonnes].activerCellule();
            }
            for (int j = Math.max(0, nbColonnes - 1); j <= Math.min(grille.nbColonnes - 1, nbColonnes + 1); j++) {
                grille.matriceCellules[nbLignes][j].activerCellule();
            }
            grille.matriceCellules[nbLignes][nbColonnes].activerCellule();
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
        sb.append("  ");
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