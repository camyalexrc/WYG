/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Ejercicio;
import Modelo.EjerciciosConsultas;
import Vista.AdminEjercicios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JOptionPane;

public class Ejercicios implements ActionListener{
    
    private final Ejercicio ej;
    private final EjerciciosConsultas ejc;
    private final AdminEjercicios aej;

    //Recibe modelo y vista
    public Ejercicios(Ejercicio ej, EjerciciosConsultas ejc, AdminEjercicios aej) {

        this.ej = ej;
        this.ejc = ejc;
        this.aej = aej;

        this.aej.btnAgregar.addActionListener(this);
        this.aej.btnModificar.addActionListener(this);
        this.aej.btnEliminar.addActionListener(this);
        this.aej.btnMostrar.addActionListener(this);
        this.aej.btnLimpiar.addActionListener(this);
        this.aej.btnLimpiar.addActionListener(this);
    }

    public void iniciar() {
        aej.setTitle("Ejercicios");
        aej.setLocationRelativeTo(null);
        aej.txtId.setVisible(false);
    }
    // funciones o eventos de botones

    @Override
    public void actionPerformed(ActionEvent e) {

        //Boton para agregar ejercicios
        if (e.getSource() == aej.btnAgregar) {
            ej.setId(Integer.parseInt(aej.txtId.getText()));
            ej.setNivel(aej.txtNivel.getText());
            ej.setNombre(aej.txtNombre.getText());
            ej.setDescripcion(aej.txtDescripcion.getText());
            ej.setSeries(Integer.parseInt(aej.txtSeries.getText()));
            ej.setRepeticiones(Integer.parseInt(aej.txtRepeticiones.getText()));

            if (ejc.agregar(ej)) {
                JOptionPane.showMessageDialog(null, "Ejercicio guardado correctamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar, intente nuevamente");
                limpiar();
            }
        }

        // Boton para modificar ejercicios
        if (e.getSource() == aej.btnModificar) {
            ej.setId(Integer.parseInt(aej.txtId.getText()));
            ej.setNivel(aej.txtNivel.getText());
            ej.setNombre(aej.txtNombre.getText());
            ej.setDescripcion(aej.txtDescripcion.getText());
            ej.setSeries(Integer.parseInt(aej.txtSeries.getText()));
            ej.setRepeticiones(Integer.parseInt(aej.txtRepeticiones.getText()));

            if (ejc.modificar(ej)) {
                JOptionPane.showMessageDialog(null, "Ejercicio modificado correctamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar, intente nuevamente");
                limpiar();
            }
        }

        //Botón para eliminar un ejercicio
        if (e.getSource() == aej.btnEliminar) {
            ej.setNombre(aej.txtNombre.getText());

            if (ejc.eliminar(ej)) {
                JOptionPane.showMessageDialog(null, "Ejercicio eliminado correctamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar, intente nuevamente");
                limpiar();
            }
        }

        //Botón para mostrar un ejercicio
        if (e.getSource() == aej.btnMostrar) {
            ej.setNombre(aej.txtNombre.getText());

            if (ejc.mostrar(ej)) {

                aej.txtId.setText(String.valueOf(ej.getId()));
                aej.txtNivel.setText(ej.getNivel());
                aej.txtNombre.setText(ej.getNombre());
                aej.txtDescripcion.setText(ej.getDescripcion());
                aej.txtSeries.setText(String.valueOf(ej.getSeries()));
                aej.txtRepeticiones.setText(String.valueOf(ej.getRepeticiones()));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro un ejercicio, intente nuevamente");
                limpiar();
            }
        }

        //boton limpiar
        if (e.getSource() == aej.btnLimpiar) {
            limpiar();
        }
         
    }
    //Metodo que limpiara los campos de texto
    public void limpiar() {
        aej.txtId.setText(null);
        aej.txtNivel.setText(null);
        aej.txtNombre.setText(null);
        aej.txtDescripcion.setText(null);
        aej.txtSeries.setText(null);
        aej.txtRepeticiones.setText(null);
    }  


}
