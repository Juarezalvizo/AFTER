/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cafter.core;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm.dafter.db.ConexionMySQL;
import org.utl.dsm.mafter.model.Aviso;
import org.utl.dsm.mafter.model.Usuario;

/**
 *
 * @author Lenovo
 */
public class ControllerAviso {

    public int insert(Aviso a) throws SQLException {
        String query = "insert into aviso value(0," + a.getUsuario().getIdUsuario() + ",'" + a.getNombre() + "','" + a.getHora() + "','" + a.getDia() + "',1);";

        ConexionMySQL objConMySQL = new ConexionMySQL();
        Connection conn = objConMySQL.open();

        PreparedStatement cstmt = conn.prepareCall(query);
        System.out.println(query);
        cstmt.execute();
        cstmt.close();
        conn.close();
        conn.close();

        return 1;
    }
    
    public int actualizar(Aviso a) throws SQLException {
        System.out.println("El aviso es "+a);
        String query = "update aviso set nombre='"+a.getNombre()+"',hora='"+a.getHora()+"',dia='"+a.getDia()+"' where idAviso="+a.getIdAviso()+";";
                
        ConexionMySQL objConMySQL = new ConexionMySQL();
        Connection conn = objConMySQL.open();

        PreparedStatement cstmt = conn.prepareCall(query);
        System.out.println(query);
        cstmt.execute();
        cstmt.close();
        conn.close();
        conn.close();

        return a.getUsuario().getIdUsuario();
    }
    
    public int eliminarAviso(int id) throws SQLException {
        String sql = "update aviso set estatus=0 where idAviso="+id+";";
        
         ConexionMySQL connSQL = new ConexionMySQL();
        Connection conn = connSQL.open();
        
        PreparedStatement cstmt = conn.prepareCall(sql);
                
        cstmt.execute();
        cstmt.close();
        conn.close();
        connSQL.close();
        
        return id;
    }
    
    public int activarAviso(int id) throws SQLException {
        String sql = "update aviso set estatus=1 where idAviso="+id+";";
        
         ConexionMySQL connSQL = new ConexionMySQL();
        Connection conn = connSQL.open();
        
        PreparedStatement cstmt = conn.prepareCall(sql);
                
        cstmt.execute();
        cstmt.close();
        conn.close();
        connSQL.close();
        
        return id;
    }
    
    public int elinarDB(int id) throws SQLException {
        String sql = "DELETE FROM aviso WHERE idAviso="+id+";";
        
         ConexionMySQL connSQL = new ConexionMySQL();
        Connection conn = connSQL.open();
        
        PreparedStatement cstmt = conn.prepareCall(sql);
                
        cstmt.execute();
        cstmt.close();
        conn.close();
        connSQL.close();
        
        return id;
    }
    
    public List<Aviso> getAll(String filtro,String id) throws SQLException{
        String sql = "select*from avisoView Where estatus =" + filtro + " && idUsuario="+id+";";
        System.out.println(sql);
        ConexionMySQL connSQL = new ConexionMySQL();
        Connection conn = connSQL.open();
        PreparedStatement pstms = conn.prepareStatement(sql);
        ResultSet rs = pstms.executeQuery();
        List<Aviso> aviso = new ArrayList<>();
        while (rs.next()) {
            aviso.add(fill(rs));
        }
        rs.close();
        pstms.close();
        connSQL.close();
        return aviso;
    }
    
    private Aviso fill(ResultSet rs) throws SQLException{
        Aviso a = new Aviso();
        Usuario u = new Usuario();
        
        u.setIdUsuario(rs.getInt("idUsuario"));
        u.setNombre(rs.getString("nomUsu"));
        u.setContrasennia(rs.getString("contrasennia"));
        u.setLastToken(rs.getString("lastToken"));
        u.setDateLastToken(rs.getString("dateLastToken"));
        
        a.setUsuario(u);
        a.setIdAviso(rs.getInt("idAviso"));
        a.setNombre(rs.getString("nombre"));
        a.setHora(rs.getString("hora"));
        a.setDia(rs.getString("dia"));
        a.setEstatus(rs.getInt("estatus"));
        
        return a;
    }
}
