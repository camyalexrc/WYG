/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Ejercicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class EjerciciosConsultas extends Conexion{
    
    //Agregar ejercicio 
    public boolean agregar(Ejercicio ej){
        
        PreparedStatement ps = null;
            
        Modelo.Conexion con = new Modelo.Conexion();
        
        //consulta a la base de datos
        String consulta = " insert into ejercicios (id, nivel, nombre, descripcion, series, repeticiones) values (?,?,?,?,?,?)";
        
        try {
            ps = con.obtenerConexion().prepareStatement(consulta);
            ps.setInt(1, (ej.getId()));
            ps.setString(2, ej.getNivel());
            ps.setString(3, ej.getNombre());
            ps.setString(4, ej.getDescripcion());
            ps.setInt(5,ej.getSeries());
            ps.setInt(6,ej.getRepeticiones());
            ps.execute();
            return true;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
            return false;
        }
        
    }
    //Modificación de ejercicio
    public boolean modificar(Ejercicio ej){
        
        PreparedStatement ps = null;
            
        Modelo.Conexion con = new Modelo.Conexion();
        
        //consulta a la base de datos
        String consulta = " update ejercicios set nivel=?, descripcion=?, series=?, repeticiones=? where nombre=?";
        
        try {
            ps = con.obtenerConexion().prepareStatement(consulta);
            ps.setInt(1, (ej.getId()));
            ps.setString(2, ej.getNivel());
            ps.setString(3, ej.getNombre());
            ps.setString(4, ej.getDescripcion());
            ps.setInt(5,ej.getSeries());
            ps.setInt(6,ej.getRepeticiones());
            ps.execute();
            return true;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
            return false;
        }
        
    }
     //Eliminación de ejercicio
    public boolean eliminar(Ejercicio ej){
        
        PreparedStatement ps = null;
            
        Modelo.Conexion con = new Modelo.Conexion();
        
        //consulta a la base de datos
        String consulta = "delete from ejercicios where nombre=?";
        
        try {
            ps = con.obtenerConexion().prepareStatement(consulta);
            ps.setString(1, ej.getNombre());
            ps.execute();
            return true;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
            return false;
        }
        
    }
      //Mostrar de ejercicio
    public boolean mostrar(Ejercicio ej){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Modelo.Conexion con = new Modelo.Conexion();
        
        //consulta a la base de datos
        String consulta = "select * from ejercicios where nombre=?";
        
        try {
            ps = con.obtenerConexion().prepareStatement(consulta);
            ps.setString(1, ej.getNombre());
            //nos regresa el resultado de la query con toda la informacion de la consulta
            rs = ps.executeQuery();
            
            if (rs.next ()){
                ej.setId(Integer.parseInt(rs.getString("id")));
                ej.setNivel(rs.getString("nivel"));
                ej.setNombre(rs.getString("nombre"));
                ej.setDescripcion(rs.getString("descripcion"));
                ej.setSeries(Integer.parseInt(rs.getString("series")));
                ej.setRepeticiones(Integer.parseInt(rs.getString("repeticiones")));
                return(true);
            }
            return false;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
            return false;
        }
        
    }
    
    
    
}
