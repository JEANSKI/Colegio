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
    public void testCalculoSalarioYPrestaciones() {
        // Datos de prueba: $10,000 por hora, 100 horas al mes.
        // Pago Base = 1,000,000.
        // Pago Final (+30%) = 1,300,000.
        // Prestaciones (19% de 1,300,000) = 247,000.
        
        Profesor prof = new Profesor("Pepe", "Calle 1", "123", "1990", "111", "Sistemas", 10000, 100);
        
        assertEquals(1300000.0, prof.calcularPagoMensual(), 0.01);
        assertEquals(247000.0, prof.calcularPrestaciones(), 0.01);
    }

    @Test
    public void testIntegracionGestor() {
        GestorColegio gestor = new GestorColegio();
        Profesor prof = new Profesor("Ana", "Cali", "444", "1985", "222", "Artes", 20000, 50);
        
        gestor.agregarPersona(prof);
        
        // Validar que el reporte no este vacío y contenga al profesor
        String reporte = gestor.reporteProfesores();
        assertTrue(reporte.contains("Ana"));
        assertTrue(reporte.contains("Artes"));
    }
}
