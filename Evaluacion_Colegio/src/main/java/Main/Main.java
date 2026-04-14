/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import Modelo.GestorColegio;
import Vista.VistaColegio;
import Controlador.ControladorColegio;
/**
 *
 * @author User
 */
public class Main {
    
public static void main(String[] args) {
        GestorColegio modelo = new GestorColegio();
        VistaColegio vista = new VistaColegio();
        ControladorColegio controlador = new ControladorColegio(vista, modelo);
        
        vista.setTitle("Registro de Colegio - UAO");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
