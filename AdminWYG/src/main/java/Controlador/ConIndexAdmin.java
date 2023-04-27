/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Vista.AdminEjercicios;
import Vista.IndexAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConIndexAdmin implements ActionListener{
    
    private IndexAdmin ia;
    private AdminEjercicios ae;
    
    public ConIndexAdmin (IndexAdmin a, Ejercicios ej){
        
        this.ia = ia;
        this.ae = ae;
        
        this.ia.btnAdminEjercicios.addActionListener((ActionListener)this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()== ia.btnAdminEjercicios){
            ae.setVisible(true);
            ia.dispose();
        }
        
    }
    
    
    
}
