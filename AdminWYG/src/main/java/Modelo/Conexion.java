/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {
   
    Connection conexion ;
    //Método para obtener conexión
    public Connection obtenerConexion (){
        String correo = "root";
        String contrasena = "";
        String bd = "adminwyg";
        String ip = "localhost";
        String puerto = "3306";

        String url = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, correo, contrasena);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Problemas de conexion"+ e.toString());
        }
        return conexion;
    }
}
