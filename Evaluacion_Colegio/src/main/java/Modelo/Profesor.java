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
    
private String cedula;
    private String area;
    private double salarioHora;
    private int horasMes;

    public Profesor(String cedula, String area, double salarioHora, int horasMes) {
        this.cedula = cedula;
        this.area = area;
        this.salarioHora = salarioHora;
        this.horasMes = horasMes;
    }

    public double calcularPagoMensual() {
        double pagoBase = salarioHora * horasMes;
        return pagoBase + (pagoBase * 0.30); 
    }

    public double calcularPagoMensual(double bonoExtra) {
        return calcularPagoMensual() + bonoExtra;
    }

    public double calcularPrestaciones() {
        return calcularPagoMensual() * 0.19; 
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    @Override
    public String toString() {
        return "Profesor -> " + getNombre() + " | Area: " + area + " | Salario Total: $" + calcularPagoMensual() + " | Prestaciones: $" + calcularPrestaciones();
    }
}
