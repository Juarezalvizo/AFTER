/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.cafter.core;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.dafter.db.ConexionMySQL;
import org.utl.dsm.mafter.model.Alumno;
import org.utl.dsm.mafter.model.Usuario;

/**
 *
 * @author Lenovo
 */
public class ControllerAlumno {

    public int insertAlumn(Alumno a) throws SQLException {
        String query = "call insertarAlumno(?,?,?,?,?,?,?,?,?,?,?,?);";

        int idUsuario = 0;
        int idAlumno = 0;

        ConexionMySQL conSQL = new ConexionMySQL();
        Connection conn = conSQL.open();

        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setString(1, a.getNombre());
        cstmt.setString(2, a.getApePaterno());
        cstmt.setString(3, a.getApeMaterno());
        cstmt.setString(4, a.getGenero());
        cstmt.setString(5, a.getNivelEstudio());
        cstmt.setFloat(6, a.getGanancias());
        cstmt.setString(7, a.getTelMovil());
        cstmt.setString(8, a.getEmail());

        cstmt.setString(9, a.getUsuario().getNombre());
        cstmt.setString(10, a.getUsuario().getContrasennia());

        cstmt.registerOutParameter(11, Types.INTEGER);
        cstmt.registerOutParameter(12, Types.INTEGER);

        cstmt.executeUpdate();

        idUsuario = cstmt.getInt(11);
        idAlumno = cstmt.getInt(12);

        a.setIdAlumno(idAlumno);
        a.getUsuario().setIdUsuario(idUsuario);

        cstmt.close();
        conn.close();
        conSQL.close();

        return idAlumno;
    }

    public int recuperarContraseña(Usuario u) throws SQLException {
        System.out.println(u);
        String query = "update usuario set contrasennia='" + u.getContrasennia() + "' where nombre='" + u.getNombre() + "';";
        ConexionMySQL objConMySQL = new ConexionMySQL();
        Connection conn = objConMySQL.open();

        PreparedStatement cstmt = conn.prepareCall(query);
        System.out.println(query);
        cstmt.execute();
        cstmt.close();
        conn.close();
        conn.close();

        return u.getIdUsuario();
    }
}
