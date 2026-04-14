/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.*;
import Vista.VistaColegio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class ControladorColegio implements ActionListener {

    private VistaColegio vista;
    private GestorColegio modelo;

    public ControladorColegio(VistaColegio vista, GestorColegio modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnListarEstudiantes.addActionListener(this);
        this.vista.btnListarProfesores.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == vista.btnRegistrar) {
                String nom = vista.txtNombre.getText();
                String dir = vista.txtDireccion.getText();
                String tel = vista.txtTelefono.getText();
                String fechaTexto = vista.txtFecha.getText(); 

                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fechaNac;
                
                try {
                    fechaNac = LocalDate.parse(fechaTexto, formato);
                    int edad = Period.between(fechaNac, LocalDate.now()).getYears();
                    
                    if (fechaNac.isAfter(LocalDate.now()) || edad > 120) {
                        throw new Exception("Fecha no realista");
                    }
                    
                    System.out.println("Edad calculada para " + nom + ": " + edad + " años.");
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vista, "Error: La fecha '" + fechaTexto + "' no es válida.\nUse el formato: DD/MM/AAAA (ej: 15/05/2000)");
                    return;
                }

                String tipo = vista.comboTipo.getSelectedItem().toString();

                if (tipo.equalsIgnoreCase("Estudiante")) {
                    Estudiante est = new Estudiante(); 

                    est.setNombre(nom);
                    est.setDireccion(dir);
                    est.setTelefono(tel);
                    est.setFechaNacimiento(fechaTexto);
                    est.setCodigo(vista.txtCodigo.getText());
                    est.setCarrera(vista.txtCarrera.getText());

                    modelo.agregarPersona(est);
                } else {
                    String ced = vista.txtCedula.getText();
                    String are = vista.txtArea.getText();
                    double sal = Double.parseDouble(vista.txtSalarioHora.getText());
                    int hrs = Integer.parseInt(vista.txtHoras.getText());
                    modelo.agregarPersona(new Profesor(nom, dir, tel, fechaTexto, ced, are, sal, hrs));
                }
            }

            if (e.getSource() == vista.btnListarEstudiantes) {
                vista.txtPantalla.setText(modelo.reporteEstudiantes());
            }

            if (e.getSource() == vista.btnListarProfesores) {
                vista.txtPantalla.setText(modelo.reporteProfesores());
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(vista, "Error: Revisa los campos numéricos (Salario/Horas)");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error inesperado: " + ex.getMessage());
        }
     }
}