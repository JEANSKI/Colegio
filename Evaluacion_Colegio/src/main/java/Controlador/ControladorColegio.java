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
                String fecha = vista.txtFecha.getText(); 

                String tipo = vista.comboTipo.getSelectedItem().toString();

                if (tipo.equalsIgnoreCase("Estudiante")) {

                    Estudiante est = new Estudiante();
                    est.setNombre(nom);
                    est.setDireccion(dir);
                    est.setTelefono(tel);
                    est.setFechaNacimiento(fecha);
                    est.setCodigo(vista.txtCodigo.getText());
                    est.setCarrera(vista.txtCarrera.getText());
                    modelo.agregarPersona(est);
                } else {
                    String ced = vista.txtCedula.getText();
                    String are = vista.txtArea.getText();
                    double sal = Double.parseDouble(vista.txtSalarioHora.getText());
                    int hrs = Integer.parseInt(vista.txtHoras.getText());
                    modelo.agregarPersona(new Profesor(nom, dir, tel, fecha, ced, are, sal, hrs));
                }
                JOptionPane.showMessageDialog(vista, "Persona registrada exitosamente");
                limpiarCampos();
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

    private void limpiarCampos() {
        vista.txtNombre.setText("");
        vista.txtDireccion.setText("");
        vista.txtTelefono.setText("");
        vista.txtFecha.setText("");
        vista.txtCodigo.setText("");
        vista.txtCarrera.setText("");
        vista.txtCedula.setText("");
        vista.txtArea.setText("");
        vista.txtSalarioHora.setText("0");
        vista.txtHoras.setText("0");
    }
}