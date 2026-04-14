/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author User
 */
public class GestorColegio {
    private ArrayList<Persona> personas;

    public GestorColegio() {
        personas = new ArrayList<>();
    }

    public void agregarPersona(Persona p) {
        personas.add(p);
    }

    public String reporteEstudiantes() {
        String lista = "--- LISTA DE ESTUDIANTES ---\n";
        for (Persona p : personas) {
            if (p instanceof Estudiante) {
                lista += p.toString() + "\n";
            }
        }
        return lista;
    }

    public String reporteProfesores() {
        ArrayList<Profesor> profes = new ArrayList<>();
        double totalPrestaciones = 0;

        for (Persona p : personas) {
            if (p instanceof Profesor) {
                Profesor prof = (Profesor) p;
                profes.add(prof);
                totalPrestaciones += prof.calcularPrestaciones();
            }
        }

        Collections.sort(profes, (p1, p2) -> Double.compare(p2.calcularPagoMensual(), p1.calcularPagoMensual()));

        String lista = "--- LISTA DE PROFESORES (Mayor a Menor Salario) ---\n";
        for (Profesor prof : profes) {
            lista += prof.toString() + "\n";
        }
        lista += "\nTOTAL PRESTACIONES COLEGIO: $" + totalPrestaciones;
        return lista;
    }
}