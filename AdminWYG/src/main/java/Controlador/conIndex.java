/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.CrearCuenta;
import Vista.Index;
import Vista.IndexAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class conIndex implements ActionListener {
    
    private Index i;
    private IndexAdmin ia;
    private CrearCuenta cc;
    
    public conIndex ( Index i, IndexAdmin ia, CrearCuenta cc){
        this.i = i;
        this.ia = ia;
        this.cc = cc;
        
        this.i.btnIngresar.addActionListener((ActionListener) this);
        this.i.btnCrearCuenta.addActionListener((ActionListener) this);
    }
    
   //Método o función de botones
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()== i.btnIngresar){
            ia.setVisible(true);
            i.dispose();
        } 
        if (e.getSource() == i.btnCrearCuenta){
        cc.setVisible(true);
        i.dispose();
    }
    }
}
