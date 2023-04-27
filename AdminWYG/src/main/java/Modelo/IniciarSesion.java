/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.Index;
import Vista.IndexUsuario;
import Modelo.Conexion;
import Vista.IndexAdmin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class IniciarSesion {
    
    //Método de validar el usuario que está ingresando
    public void validarUsuario(JTextField correo, JPasswordField contrasena) {
        
        try {
            ResultSet rs = null;
            PreparedStatement ps = null;
            
            Modelo.Conexion con = new Modelo.Conexion();
            
            String consulta = "select * from usuarios where usuarios.correo = (?) and usuarios.contrasena = (?);";
            ps = con.obtenerConexion().prepareStatement(consulta);
            //se transforma contraseña a cadena de texto
            String pass = String.valueOf(contrasena.getPassword());
            
            ps.setString(1, correo.getText());
            ps.setString(2, pass);
            
            //ejecutamos la consulta
            rs = ps.executeQuery();
            
            //Validamos los campos si a de ser correctos
            if(rs.next()){
                IndexAdmin objetoSesion = new IndexAdmin();
                objetoSesion.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null,"Correo o contraseña incorrecta, intentelo nuevamente");
                
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
}
