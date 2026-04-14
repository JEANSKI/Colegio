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
public class EstudianteTest {

    @Test
    public void testValidarSettersYGetters() {
        Estudiante est = new Estudiante();

        // 2. Ingresamos los datos usando SET
        est.setNombre("Jean Pierre");
        est.setCodigo("22502302");
        est.setCarrera("Mecatrónica");

        // 3. Validamos que los datos guardados sean exactamente los mismos usando GET
        Assert.assertEquals("Jean Pierre", est.getNombre());
        Assert.assertEquals("22502302", est.getCodigo());
        Assert.assertEquals("Mecatrónica", est.getCarrera());
    }
}