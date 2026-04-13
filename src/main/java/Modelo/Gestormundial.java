/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class Gestormundial {

    private ArrayList<Persona> participantes;

        public Gestormundial() {
        this.participantes = new ArrayList<>();
    }

    public void registrarParticipante(Persona p) {
        participantes.add(p);
    }


    public String obtenerDatosParticipantes() {
        StringBuilder sb = new StringBuilder();
        for (Persona p : participantes) {

            sb.append(p.toString()).append("\n"); 
        }
        return sb.toString();
    }
}
