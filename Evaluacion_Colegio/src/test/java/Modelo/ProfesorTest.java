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
public class ProfesorTest {
    
@Test
    public void testCalculosProfesor() {

        Profesor p = new Profesor("111", "Matematicas", 100.0, 10);
        p.setNombre("Edwin Gallego");
        
        assertEquals("El nombre debe ser el asignado", "Edwin Gallego", p.getNombre());
        assertEquals(1300.0, p.calcularPagoMensual(), 0.01);
        assertEquals(247.0, p.calcularPrestaciones(), 0.01);
    }
    
    @Test
    public void testSobrecargaBono() {
        Profesor p = new Profesor("222", "Fisica", 100.0, 10);
        assertEquals(1500.0, p.calcularPagoMensual(200.0), 0.01);
    }
}
