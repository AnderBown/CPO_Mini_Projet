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
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author AnderBown
 */
public class FenetrePrincipale extends javax.swing.JFrame {

    // Variables de la grille
    int nbLignes = 10;
    int nbColonnes = 10;
    
    private boolean toutesLesLampesEteintes() {
    for (int i = 0; i < nbLignes; i++) {
        for (int j = 0; j < nbColonnes; j++) {
            if (grille.matriceCellules[i][j].getEtat()) {  // Check if any cell is on
                return false;  // Return false if at least one light is on
            }
        }
    }
    return true;  // All lights are off
}

    JButton[][] boutons;  // Tableau pour stocker les boutons représentant la grille

    GrilleDeJeu grille;
    int nbCoups = 0; 

    public FenetrePrincipale() {
        this(0); 
    }

    public FenetrePrincipale(int difficulty) {
    this.grille = new GrilleDeJeu(nbLignes, nbColonnes);
    
    
    grille.eteindreToutesLesCellules();
    grille.melangerMatriceAleatoirement(difficulty);
   
    
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
                        
                        nbCoups++;
                        labelNbCoups.setText(Integer.toString(nbCoups));
                        // Ajout dans l'écouteur d'événements
                        //Actualisation de toutes les cases du tableau                       
                            for (int i1=0; i1 < nbLignes; i1++) {
                                for (int j1=0; j1 < nbColonnes; j1++ )
                            if (grille.matriceCellules[i1][j1].getEtat()) {
                                boutons[i1][j1].setBackground(java.awt.Color.YELLOW);  // Changez la couleur en rouge si "X"
                            } else {
                                boutons[i1][j1].setBackground(java.awt.Color.BLACK);  // Couleur par défaut
                            }
                        }  /*                      
                        if (toutesLesLampesEteintes()) {
                            // Add a space between the number of moves and the congratulations message
                            String endtext = "Vous avez réussi! " + nbCoups + " coups. Félicitations!";
                            JOptionPane.showMessageDialog(null, endtext, "Fin de la partie", JOptionPane.INFORMATION_MESSAGE);
                            nbCoups = 0;
                        }*/
                        if (toutesLesLampesEteintes()) {
                            
                            JPanel endGamePanel = new JPanel(new GridLayout(2, 1));

                            
                            JLabel messageLabel = new JLabel("Vous avez réussi! " + nbCoups + " coups. Félicitations!");
                            messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                            endGamePanel.add(messageLabel);

                            
                            JButton backToMenuButton = new JButton("Recommencer");
                            backToMenuButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    
                                    dispose();
                                    
                                    new difficulte().setVisible(true);
                                }
                            });
                            endGamePanel.add(backToMenuButton);

                            
                            JOptionPane.showMessageDialog(
                                null, 
                                endGamePanel, 
                                "Fin de la partie", 
                                JOptionPane.INFORMATION_MESSAGE
                            );

                            nbCoups = 0; 
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Difficulty = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        labelNbCoups = new javax.swing.JLabel();
        PanneauGrille = new javax.swing.JPanel();

        btnLigne0.setText("jButton1");
        btnLigne0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLigne0ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(51, 255, 0));
        jLabel1.setText("                                                                                                 LIGHTS OFF");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(730, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre de tours");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        Difficulty.setMinimumSize(new java.awt.Dimension(100, 100));
        Difficulty.setPreferredSize(new java.awt.Dimension(100, 50));
        Difficulty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DifficultyActionPerformed(evt);
            }
        });
        jPanel1.add(Difficulty, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel4.setText("Randomizer");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));
        jPanel1.add(labelNbCoups, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        PanneauGrille.setBackground(new java.awt.Color(51, 204, 255));
        PanneauGrille.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        jPanel1.add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, 590));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLigne0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLigne0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLigne0ActionPerformed

    private void DifficultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DifficultyActionPerformed
        // Get the text from the input field (assumed to be named difficultyField)
        String inputText = Difficulty.getText();  // Corrected line

        try {
            int difficulty = Integer.parseInt(inputText); // Convert the input to an integer
            grille.melangerMatriceAleatoirement(difficulty); // Pass the difficulty to the method
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.");
        }
    }//GEN-LAST:event_DifficultyActionPerformed

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
            new difficulte().setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Difficulty;
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton btnLigne0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNbCoups;
    // End of variables declaration//GEN-END:variables
}
