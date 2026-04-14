/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.*;
import Vista.VistaColegio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.vista.btnListaEstudiantes.addActionListener(this);
        this.vista.btnListaProfesores.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == vista.btnRegistrar) {
                String tipo = vista.comboTipo.getSelectedItem().toString().toLowerCase();

                if (tipo.contains("estudiante")) {
                    Estudiante est = new Estudiante();
                    est.setNombre(vista.txtNombre.getText());
                    est.setDireccion(vista.txtDireccion.getText());
                    est.setTelefono(vista.txtTelefono.getText());
                    est.setFechaNacimiento(vista.txtFecha.getText());
                    est.setCodigo(vista.txtCodigo.getText());
                    est.setCarrera(vista.txtCarrera.getText());
                    modelo.agregarPersona(est);
                } else {
                    double salHora = Double.parseDouble(vista.txtSalarioHora.getText());
                    int horas = Integer.parseInt(vista.txtHoras.getText());
                    
                    Profesor prof = new Profesor(vista.txtCedula.getText(), vista.txtArea.getText(), salHora, horas);
                    prof.setNombre(vista.txtNombre.getText());
                    prof.setDireccion(vista.txtDireccion.getText());
                    prof.setTelefono(vista.txtTelefono.getText());
                    prof.setFechaNacimiento(vista.txtFecha.getText());
                    modelo.agregarPersona(prof);
                }
                JOptionPane.showMessageDialog(vista, "Registro guardado exitosamente");
            }

            if (e.getSource() == vista.btnListaEstudiantes) {
                vista.txtPantalla.setText(modelo.reporteEstudiantes());
            }

            if (e.getSource() == vista.btnListaProfesores) {
                vista.txtPantalla.setText(modelo.reporteProfesores());
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Error: Revisa que los campos de salario y horas sean numeros");
        }
    }

    public void iniciar() {
        vista.setTitle("Sistema Escolar - Evaluacion");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}