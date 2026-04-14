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

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public double getSalarioHora() { return salarioHora; }
    public void setSalarioHora(double salarioHora) { this.salarioHora = salarioHora; }

    public int getHorasMes() { return horasMes; }
    public void setHorasMes(int horasMes) { this.horasMes = horasMes; }

    public double calcularPagoMensual() {
        double base = salarioHora * horasMes;
        return base * 1.30; // 30% por preparación
    }

    public double calcularPrestaciones() {
        return calcularPagoMensual() * 0.19; // 19% de prestaciones
    }
    
    public double calcularPagoMensual(double bono) {
        return calcularPagoMensual() + bono;
    }

    @Override
    public String toString() {
        return "PROFESOR -> " + nombre + " | Área: " + area + " | Pago Total: $" + calcularPagoMensual();
    }
}
