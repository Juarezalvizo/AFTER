/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.mafter.model;

import java.util.Date;
import java.util.Date;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author Lenovo
 */
public class Usuario {
  int idUsuario;
    String nombre;
    String contrasennia;
    String lastToken;
    String dateLastToken;

    public Usuario() {
    }

    
    public Usuario(int idUsuario, String nombre, String contrasennia, String lastToken, String dateLastToken) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasennia = contrasennia;
        this.lastToken = lastToken;
        this.dateLastToken = dateLastToken;
    }

    public Usuario(String nombre, String contrasennia, String lastToken, String dateLastToken) {
        this.nombre = nombre;
        this.contrasennia = contrasennia;
        this.lastToken = lastToken;
        this.dateLastToken = dateLastToken;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasennia() {
        return contrasennia;
    }

    public String getLastToken() {
        return lastToken;
    }

    public String getDateLastToken() {
        return dateLastToken;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasennia(String contrasennia) {
        this.contrasennia = contrasennia;
    }

    public void setLastToken(String lastToken) {
        this.lastToken = lastToken;
    }

    public void setDateLastToken(String dateLastToken) {
        this.dateLastToken = dateLastToken;
    }
//
//    public void setLastToken(){
//        String u=this.getNombre();
//        String p=this.getContrasennia();
//        String k=new Date().toString();
//        String x=(DigestUtils.sha256Hex(u + ";" + p + ";" + k));
//        this.lastToken=x;
//    }
    
    public void setLastToken(){
        String u=this.getNombre();
        String p=this.getContrasennia();
        String k=new Date().toString();
//        String x=(DigestUtils.sha256Hex(u + ";" + p + ";" + k));
//        this.lastToken=x;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", contrasennia=" + contrasennia + " , lastToken=" + lastToken + ", dateLastToken=" + dateLastToken + '}';
    }
    
    
}

