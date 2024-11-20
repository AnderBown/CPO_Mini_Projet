/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightoff_mingfu_version_console;

/**
 *
 * @author AnderBown
 */
public class LightOff_MINGFU_version_console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CelluleLumineuse cellule = new CelluleLumineuse();
        System.out.println(cellule); 
        
        cellule.activerCellule();
        System.out.println(cellule); 
        
        cellule.eteindreCellule();
        System.out.println(cellule);
    }
    
}
