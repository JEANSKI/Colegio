/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author User
 */
public class ProfesorTest {

    @Test
    public void testValidarAtributosYCalculos() {
        // 1. Preparar los datos de prueba (10000 por hora, 10 horas)
        Profesor prof = new Profesor("Edwin", "Cali", "123", "01/01/1980", "111", "Poo", 10000.0, 10);

        // 2. Validar que los atributos se recibieron correctamente (Test de Integración de datos)
        Assert.assertEquals("Edwin", prof.getNombre());
        Assert.assertEquals("111", prof.getCedula());
        Assert.assertEquals("Poo", prof.getArea());

        // 3. Validar el cálculo del Pago Mensual
        // Fórmula esperada: (10000 * 10) + 30% = 100000 + 30000 = 130000
        double pagoEsperado = 130000.0;
        double pagoCalculado = prof.calcularPagoMensual();
        
        // El tercer parámetro (0.01) es la margen de error aceptada para decimales
        Assert.assertEquals(pagoEsperado, pagoCalculado, 0.01);

        // 4. Validar el cálculo de Prestaciones
        // Fórmula esperada: 19% de 130000 = 24700
        double prestacionesEsperadas = 24700.0;
        double prestacionesCalculadas = prof.calcularPrestaciones();
        
        Assert.assertEquals(prestacionesEsperadas, prestacionesCalculadas, 0.01);
    }
    
    @Test
    public void testPolimorfismoSobrecargaBono() {
        Profesor prof = new Profesor("Ana", "Cali", "456", "01/01/1990", "222", "Matemáticas", 10000.0, 10);
        
        // El pago base es 130000. Si le sumamos un bono de 50000 debe dar 180000
        double pagoConBonoEsperado = 180000.0;
        double pagoConBonoCalculado = prof.calcularPagoMensual(50000.0);
        
        Assert.assertEquals(pagoConBonoEsperado, pagoConBonoCalculado, 0.01);
    }
}