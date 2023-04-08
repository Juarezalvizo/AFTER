/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.utl.dsm.cafter.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm.dafter.db.ConexionMySQL;
import org.utl.dsm.mafter.model.Alumno;
import org.utl.dsm.mafter.model.Finanza;
import org.utl.dsm.mafter.model.Usuario;

/**
 *
 * @author Lenovo
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
       // probarConexion();
      //probarInsertarF();
      probarGetAllF();
    }
//     public static void probarConexion() {
//        try {
//            ConexionMySQL objConexion = new ConexionMySQL();
//            Connection conexion = objConexion.open();
//            System.out.println(conexion.toString());
//            conexion.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
     
//s
    public static void probarGetAllF() {
    try {
        ControllerFinanza objCF = new ControllerFinanza();
        List<Finanza> finanzas = objCF.getAll("1");
        for (int i = 0; i < finanzas.size(); i++) {
            // Imprimir los campos relevantes de cada Finanza en la consola
            System.out.println(finanzas.get(i).toString());
        }
    } catch (Exception ex) {
        System.out.println("Error al obtener las finanzas: " + ex.toString());
    }
}

}
//    public static void probarGetAll(){
//        try {
//            ControllerEmpleado objCE = new ControllerEmpleado();
//            List<Empleado> empleados = objCE.getAll("1");
//            for (int i = 0; i < empleados.size(); i++) {
//                System.out.println(empleados.get(i).toString());
//            }
//        } catch (Exception ex) {
//            System.out.println(ex.toString());
//           
//        }
//    }



