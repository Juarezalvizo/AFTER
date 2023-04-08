/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cafter.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.utl.dsm.dafter.db.ConexionMySQL;
import org.utl.dsm.mafter.model.Alumno;
import org.utl.dsm.mafter.model.Usuario;

/**
 *
 * @author franc
 */
public class ControladorLogin {
    
    public boolean validarToken(String t) throws Exception
    {
        boolean r = false;
        String query = "SELECT * from alumnoView where lastToken = '"+t+"'";
        ConexionMySQL conexionMySQL = new ConexionMySQL();
        Connection connection = conexionMySQL.open();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if(rs.next())
            r=true;
        stmt.close();
        connection.close();
        conexionMySQL.close();
        
        return r;
    }

    public Alumno entrar(Usuario u) throws Exception {
        String qr = "SELECT * FROM alumnoView WHERE nomUsu ='" + u.getNombre() + "'  AND contrasennia='" + u.getContrasennia() + "';";

        ConexionMySQL mysql = new ConexionMySQL();
        Connection conn = mysql.open();
        Statement stmt = conn.createStatement();
        System.out.println(qr);
        ResultSet rs = stmt.executeQuery(qr);

        Alumno a = null;
        if (rs.next()) {
            a = fill(rs);
        }
        rs.close();
        stmt.close();
        conn.close();
        mysql.close();
        return a;
    }

    private Alumno fill(ResultSet rs) throws SQLException {
        Alumno a = new Alumno();
        Usuario u = new Usuario();

        u.setIdUsuario(rs.getInt("idUsuario"));
        u.setNombre(rs.getString("nomUsu"));
        u.setContrasennia(rs.getString("contrasennia"));
        u.setLastToken(rs.getString("lastToken"));
        u.setDateLastToken(rs.getString("dateLastToken"));

        a.setIdAlumno(rs.getInt("idAlumno"));
        a.setNombre(rs.getString("nomAlum"));
        a.setApePaterno(rs.getString("apePaterno"));
        a.setApeMaterno(rs.getString("apeMaterno"));
        a.setGenero(rs.getString("genero"));
        a.setNivelEstudio(rs.getString("nivelEstudio"));
        a.setGanancias(rs.getFloat("ganancias"));
        a.setTelMovil(rs.getString("telMovil"));
        a.setEmail(rs.getString("email"));
        a.setEstatus(rs.getInt("estatus"));
        a.setUsuario(u);

        return a;
    }
    
    public void guardarToken(Alumno a) throws SQLException{
        String query ="UPDATE usuario SET lastToken=?,dateLastToken=NOW() WHERE idUsuario=?";
        
        ConexionMySQL mysql =new ConexionMySQL();
        Connection conn =mysql.open();
        
        PreparedStatement ppst=conn.prepareCall(query);
        ppst.setString(1,a.getUsuario().getLastToken());
        ppst.setInt(2, a.getUsuario().getIdUsuario());
        
        ppst.execute();
        
        ppst.close();
        conn.close();
        mysql.close();
    }
    
    public boolean eliminarToken(Alumno a) throws Exception
    {
        boolean r=false;
        String query = "UPDATE usuario SET lastToken='' where idUsuario=?";
        
        ConexionMySQL conMySQL = new ConexionMySQL();
        
        Connection conn = conMySQL.open();
        
        PreparedStatement ppstt = conn.prepareCall(query);
        
        ppstt.setInt(1, a.getUsuario().getIdUsuario());
        ppstt.execute();
        r=true;
        
        ppstt.close();
        conn.close();
        conMySQL.close();
        
        return r;
    }
}
