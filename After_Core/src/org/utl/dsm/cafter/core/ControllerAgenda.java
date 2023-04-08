/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cafter.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.dafter.db.ConexionMySQL;
import org.utl.dsm.mafter.model.Agenda;
import org.utl.dsm.mafter.model.Usuario;

/**
 *
 * @author Lenovo
 */
public class ControllerAgenda {
    public int insertarG(Agenda g) throws SQLException {
        String query = "{call insertarAgenda(?,?,?,?,?,?,?,?,?)}";

    //Preparar las variables para recibir os valores de retorno
    int idAgenda = 0;  
    int idUsuario = 0;
    //3.Conectarse a la BD
    ConexionMySQL objConMySQL = new ConexionMySQL();
    Connection conn = (Connection) objConMySQL.open();
    //4. generar el objeto que va a invocar el store procedure
    CallableStatement cstmt = conn.prepareCall(query);
    //5. Asignar cada uno de los valores que se 
    cstmt.setString(1, g.getMateria());
    cstmt.setString(2, g.getActiTitulo());
    cstmt.setString(3, g.getActiDes());
    cstmt.setString(4, g.getFechaHoraReg());
    cstmt.setString(5, g.getFechaHoraVenci());
    
    cstmt.setString(6, g.getUsuario().getNombre());
    cstmt.setString(7, g.getUsuario().getContrasennia());
    
    cstmt.registerOutParameter(8, Types.INTEGER);
    cstmt.registerOutParameter(9, Types.INTEGER);
    //6. ejecutar la instrucción       
    cstmt.executeUpdate(); 
    // 7. Recuperar los parametros de retorno 
    idUsuario =cstmt.getInt(8);
    idAgenda = cstmt.getInt(9);    
    //8. Colocar los valores recuperados dentro del objeto 
    g.setIdAgenda(idAgenda);        
    g.getUsuario().setIdUsuario(idUsuario);
    //9. Cerrar los objetos de uso de BD
    cstmt.close();
    conn.close();
    objConMySQL.close();
    //10. Devolver el id que se generó
    return idAgenda;
}
    public List <Agenda> getAll(String filtro) throws SQLException{
       //La consulta SQL a ejecutar 
       String sql = "SELECT * FROM vistaAgenda  WHERE estatus="+filtro+"; ";
       //Con este objeto nos vamos a conectar a la base de datos:
       ConexionMySQL connMySQL = new ConexionMySQL();
       //Abrimos con la conexion a base de datos
       Connection conn = connMySQL.open();
       //Con este objeto ejecutaremos la consulta
       PreparedStatement pstmt = conn.prepareStatement(sql);
       //Aqui guardaremos los resultados de la consulta 
       ResultSet rs = pstmt.executeQuery();
       List<Agenda> empleados = new ArrayList<>();
       
       while(rs.next())
           empleados.add(fill(rs));
       rs.close();
       pstmt.close();
       connMySQL.close();
       return empleados;
   }
    
    private Agenda fill(ResultSet rs) throws SQLException{       
   Agenda a = new Agenda();
   Usuario u = new Usuario();
   //u.setIdUsuario(rs.getInt("idUsuario"));
   //u.setNombre(rs.getString("nombre"));
   //u.setContrasennia(rs.getString("contrasennia"));
   a.setMateria(rs.getString("materia"));
   a.setActiTitulo(rs.getString("actiTitulo"));
   a.setActiDes(rs.getString("actiDes"));
   a.setFechaHoraReg(rs.getString("fechaHoraReg"));
   a.setEstatus(rs.getInt("estatus"));
   a.setFechaHoraVenci(rs.getString("fechaHoraVenci"));
   a.setUsuario(u);
   
   return a;
    }
   
    public List <Agenda> getAllInactivos(String filtro) throws SQLException{
       //La consulta SQL a ejecutar 
       String sql = "SELECT * FROM vistaAgenda  WHERE estatus="+filtro+"; ";
       //Con este objeto nos vamos a conectar a la base de datos:
       ConexionMySQL connMySQL = new ConexionMySQL();
       //Abrimos con la conexion a base de datos
       Connection conn = connMySQL.open();
       //Con este objeto ejecutaremos la consulta
       PreparedStatement pstmt = conn.prepareStatement(sql);
       //Aqui guardaremos los resultados de la consulta 
       ResultSet rs = pstmt.executeQuery();
       List<Agenda> agenda = new ArrayList<>();
       
       while(rs.next())
           agenda.add(fill(rs));
       rs.close();
       pstmt.close();
       connMySQL.close();
       return agenda;
   }
    
    public int eliminar(int filtro) throws SQLException{
       String query = "UPDATE agenda SET estatus=0 Where idAgenda = "+filtro+";";
       ConexionMySQL objCEMySQL = new ConexionMySQL();
       Connection conn = (Connection) objCEMySQL.open();
        //4. generar el objetro que va a invocar el store produre
        PreparedStatement pstmt = conn.prepareCall(query);
        pstmt.execute();
        pstmt.close();
        conn.close();
        objCEMySQL.close();
        return filtro;
   }
}

