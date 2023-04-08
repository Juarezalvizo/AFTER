/*
Autor: Barrientos Flores Angel Francisco
Empresa: E-DDIT
Fecha:20/03/2023
Descripcion: 
  - open(): establece una conexión a una base de datos MySQL utilizando las credenciales 
            de usuario y contraseña especificadas en la cadena de conexión. Devuelve un objeto de tipo Connection.
  - close(): cierra la conexión a la base de datos establecida por el método open().
 */
package org.utl.dsm.dafter.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionMySQL {
    Connection conn;
    
    public Connection open(){
     String usuario="root";
     String password="070312";
          //String url="jdbc:mysql://127.0.0.1:3306/db_escuela?useSSL=false&useUnicode=true&characterEncoding=utf-8";
String url="jdbc:mysql://127.0.0.1:3306/AFTER?useSSL=false&useUnicode=true&characterEncoding=utf-8";
     
     try
     {
     Class.forName("com.mysql.cj.jdbc.Driver");
     conn = DriverManager.getConnection(url, usuario, password);
     return conn;
     
     }
     catch(Exception ex)
     {
         throw new RuntimeException(ex);
     }
    }
    public void close(){
        try{
            conn.close();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
