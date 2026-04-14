/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Profesor extends Persona {

    private String cedula, area;
    private double salarioHora;
    private int horasMes;

    public Profesor(String n, String d, String t, String f, String ced, String are, double sal, int horas) {
        super(n, d, t, f);
        this.cedula = ced;
        this.area = are;
        this.salarioHora = sal;
        this.horasMes = horas;
    }

    public double calcularPagoMensual() {
        return (salarioHora * horasMes) * 1.30; // 30% adicional preparación 
    }

    public double calcularPagoMensual(double bonoExtra) {
        return calcularPagoMensual() + bonoExtra;
    }

    public double calcularPrestaciones() {
        return calcularPagoMensual() * 0.19; // 19% prestaciones 
    }

    @Override
    public String toString() {
        return "PROFESOR -> " + nombre + " | Pago Total: $" + calcularPagoMensual();
    }
}
