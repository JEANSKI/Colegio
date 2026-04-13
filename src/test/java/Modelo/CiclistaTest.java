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
public class CiclistaTest {
    
@Test
    public void testCalcularPuntosSimple() {
        Ciclista ciclista = new Ciclista("Nairo", "Colombia", 15);
        int resultado = ciclista.calcularPuntos(100); 

        assertEquals(110, resultado);
    }


    @Test
    public void testCalcularPuntosAnidadoOro() {

        Ciclista ciclista = new Ciclista("Kevin", "Colombia", 5);
        int resultado = ciclista.calcularPuntos(100, "Oro");

        assertEquals(250, resultado);
    }
}