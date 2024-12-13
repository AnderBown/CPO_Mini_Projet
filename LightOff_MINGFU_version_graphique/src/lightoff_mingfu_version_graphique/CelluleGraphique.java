package lightoff_mingfu_version_graphique;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author AnderBown
 */
public class CelluleGraphique extends JButton {
    int largeur; // largeur en pixel de la cellule
    int hauteur; // hauteur en pixel de la cellule
    CelluleLumineuse celluleLumineuseAssociee;

    // Constructeur (appelé depuis FenetrePrincipale)
    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int l, int h) {
        this.largeur = l;
        this.hauteur = h;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
    }

    // Méthode gérant le dessin de la cellule
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Définir la couleur de fond en fonction de l'état de la cellule
        if (celluleLumineuseAssociee.getEtat()) {
            // Si la cellule est allumée, fond vert
            this.setBackground(Color.ORANGE);
        } else {
            // Si la cellule est éteinte, fond noir
            this.setBackground(Color.BLACK);
        }

        // Mettre à jour le texte pour afficher l'état de la cellule ("O" pour allumée, "X" pour éteinte)
        this.setText(celluleLumineuseAssociee.toString());

        // Dessiner la cellule avec la couleur de fond mise à jour
        g.clearRect(0, 0, getWidth(), getHeight()); // Effacer l'ancienne couleur
        super.paintComponent(g); // Redessiner le bouton avec la nouvelle couleur
    }
}
