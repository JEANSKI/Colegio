/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author User
 */
public class GestormundialTest {
    
    @Test
    public void testIntegracionRegistroYPolimorfismo() {

        Gestormundial gestor = new Gestormundial();
        Ciclista ciclista = new Ciclista("Mariana Pajon", "Colombia", 1);
        Entrenador entrenador = new Entrenador("Carlos Mario", "Colombia", 15);

        gestor.registrarParticipante(ciclista);
        gestor.registrarParticipante(entrenador);
        

        String cadenaFinal = gestor.obtenerDatosParticipantes();
        

        assertTrue(cadenaFinal.contains("CICLISTA"));
        assertTrue(cadenaFinal.contains("Mariana Pajon"));
        assertTrue(cadenaFinal.contains("ENTRENADOR"));
        assertTrue(cadenaFinal.contains("Carlos Mario"));
    }
}
