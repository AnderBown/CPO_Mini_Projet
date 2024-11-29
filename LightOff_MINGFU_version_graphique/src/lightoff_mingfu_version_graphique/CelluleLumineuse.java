/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_mingfu_version_graphique;


/**
 *
 * @author AnderBown
 */
public class CelluleLumineuse {
    
    private boolean etat;

    public CelluleLumineuse() {
        this.etat = false;
    }
    
    public void activerCellule() {
        this.etat = !this.etat;
        
    }
    
    public void eteindreCellule() {
        this.etat = false;
    }

    public boolean estEteint() {
        return !this.etat;
    }

    public boolean getEtat() {
        return this.etat;
    }

    @Override
    public String toString() {
        return this.etat ? "O" : "X";
    }

}