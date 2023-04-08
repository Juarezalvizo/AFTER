/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cafter.core;

import org.utl.dsm.dafter.db.ConexionMySQL;
import org.utl.dsm.mafter.model.Finanza;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.utl.dsm.mafter.model.Alumno;
import org.utl.dsm.mafter.model.Usuario;

/**
 *
 * @author Lenovo
 */
public class ControllerFinanza {
    
    
     public int insertarF(Finanza f) throws SQLException {
        //Definimos la consulta SQL que invoca al Stored Procedure:
        String query =  "{call insertarFinanza(?, ?, ?, ?, ?, ?,?)}";
        int idFinanza = 0;
        //3.Conectarse a la BD
        ConexionMySQL objConMySQL = new ConexionMySQL();
        Connection conn = objConMySQL.open();
        
        //4. generar el objetro que va a invocar el store produre
        CallableStatement cstmt = conn.prepareCall(query);
        
        //%. Asignar cada uno de los valores que se 
        cstmt.setString(1, f.getCosteTitulo());
        cstmt.setFloat(2, f.getCantidadCoste());
        cstmt.setString(3, f.getCosteDes());
        cstmt.setString(4, f.getFechaHoraCoste());
		cstmt.setInt(5, f.getAlumno().getIdAlumno());
       // cstmt.setInt(6, f.getUsuario().getIdUsuario());
        cstmt.execute();
        // 7. Recuperar los parametros de retorno 
        idFinanza = cstmt.getInt(7);
        
        //8.Colocar los valores recuperados dentro del objeto
        f.setIdFinanza(idFinanza);
        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConMySQL.close();
        
        //10. Devolver el id que se genero
        return idFinanza;
    }
    
        public List<Finanza> getAll(String filtro ) throws Exception {
    // La consulta SQL a ejecutar:
    String sql = "SELECT * FROM vista_finanza WHERE estatus='"+filtro+"';";
    ConexionMySQL objConMySQL = new ConexionMySQL();
    Connection conn = objConMySQL.open();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    List<Finanza> finanzas = new ArrayList<>();
    while (rs.next()) {
        finanzas.add(fill(rs));
    }
    rs.close();
    stmt.close();
    conn.close();
    objConMySQL.close();
    return finanzas;
}
private Finanza fill(ResultSet rs) throws Exception {
    Finanza f = new Finanza();
    Alumno a = new Alumno();
        
    a.setIdAlumno(rs.getInt("idAlumno"));
    a.setNombre(rs.getString("nombre"));
    a.setApePaterno(rs.getString("apePaterno"));
    a.setApeMaterno(rs.getString("apeMaterno"));
    a.setGenero(rs.getString("genero"));
    a.setNivelEstudio(rs.getString("nivelEstudio"));
    a.setGanancias(rs.getFloat("ganancias"));
    a.setTelMovil(rs.getString("telMovil"));
    a.setEmail(rs.getString("email"));
    a.setUsuario(new Usuario());
a.getUsuario().setIdUsuario(rs.getInt("idUsuario"));

  //  a.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
    a.getUsuario().setNombre(rs.getString("nombreUsuario"));
    a.getUsuario().setContrasennia(rs.getString("contrasennia"));
    
    f.setAlumno(a);
    f.setIdFinanza(rs.getInt("idFinanza"));
    f.setCosteTitulo(rs.getString("costeTitulo"));
    f.setCantidadCoste(rs.getFloat("cantidadCoste"));
    f.setFechaHoraCoste(rs.getString("fechaHoraCoste"));
    f.setCosteDes(rs.getString("costeDes"));
    f.setEstatus(rs.getInt("estatus"));
   
    return f;
}

    

}
