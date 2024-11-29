/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lightoff_mingfu_version_graphique;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import lightoff_mingfu_version_graphique.GrilleDeJeu;
import lightoff_mingfu_version_graphique.Partie.*; // Importation de GrilleDeJeu


/**
 *
 * @author AnderBown
 */
public class FenetrePrincipale extends javax.swing.JFrame {

    // Variables de la grille
    int nbLignes = 10;
    int nbColonnes = 10;
    JButton[][] boutons;  // Tableau pour stocker les boutons représentant la grille

    GrilleDeJeu grille;
    int nbCoups; 

    
    public FenetrePrincipale() {
    this.grille = new GrilleDeJeu(nbLignes, nbColonnes);
    
    
    grille.eteindreToutesLesCellules();
    grille.melangerMatriceAleatoirement(10);
    
    
    boutons = new JButton[nbLignes][nbColonnes]; // Initialize the boutons array
        initComponents();
        PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));
        for (int i=0; i < nbLignes; i++) {
            for (int j=0; j < nbColonnes; j++ ) {
            CelluleGraphique bouton_cellule = new CelluleGraphique(grille.matriceCellules[i][j], 36, 36); // création d'un bouton
             boutons[i][j] = bouton_cellule; // Stockage du bouton dans le tableau
             // Ajout de l'écouteur d'événement pour chaque bouton
                final int ligne = i;
                final int colonne = j;
                bouton_cellule.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Appel de la méthode activerCases lorsqu'une case est sélectionnée
                        grille.activerEntourageCellules(grille, ligne, colonne);
                        // Ajout dans l'écouteur d'événements
                        //Actualisation de toutes les cases du tableau
                        for (int i1=0; i1 < nbLignes; i1++) {
                            for (int j1=0; j1 < nbColonnes; j1++ )
                        if (grille.matriceCellules[i1][j1].getEtat()) {
                            boutons[i1][j1].setBackground(java.awt.Color.YELLOW);  // Changez la couleur en rouge si "X"
                        } else {
                            boutons[i1][j1].setBackground(java.awt.Color.BLACK);  // Couleur par défaut
                        }
                        }
                    }
                });
            if (grille.matriceCellules[i][j].getEtat()) {
                    bouton_cellule.setBackground(java.awt.Color.GREEN);  // La couleur pour "X"
                } else {
                    bouton_cellule.setBackground(java.awt.Color.RED);  // Couleur par défaut
                }
            PanneauGrille.add(bouton_cellule); // ajout au Jpanel PanneauGrille
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLigne0 = new javax.swing.JButton();
        PanneauGrille = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        btnLigne0.setText("jButton1");
        btnLigne0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne0ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanneauGrille.setBackground(new java.awt.Color(51, 204, 255));
        PanneauGrille.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauGrille, java.awt.BorderLayout.LINE_END);

        jLabel1.setText("                                                            LIGHTS OFF");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre de tours");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLigne0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLigne0ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePrincipale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton btnLigne0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
