/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Entrenador extends Persona {
    private int aniosExperiencia;

    public Entrenador(String nombre, String pais, int aniosExperiencia) {
        super(nombre, pais);
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public String toString() {
        return "ENTRENADOR -> " + super.toString() + " | Experiencia: " + aniosExperiencia + " años";
    }

    public int getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }
}
