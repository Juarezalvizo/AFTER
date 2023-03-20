/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.mafter.model;

/**
 *
 * @author Lenovo
 */
public class Alumno {
    int idAlumno;
    String nombre, apePaterno, apeMaterno, genero, nivelEstudio, ganancias, telMovil, email; 

    public Alumno() {
    }

    public Alumno(int idAlumno, String nombre, String apePaterno, String apeMaterno, String genero, String nivelEstudio, String ganancias, String telMovil, String email) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.genero = genero;
        this.nivelEstudio = nivelEstudio;
        this.ganancias = ganancias;
        this.telMovil = telMovil;
        this.email = email;
    }

    public Alumno(String nombre, String apePaterno, String apeMaterno, String genero, String nivelEstudio, String ganancias, String telMovil, String email) {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.genero = genero;
        this.nivelEstudio = nivelEstudio;
        this.ganancias = ganancias;
        this.telMovil = telMovil;
        this.email = email;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public String getGanancias() {
        return ganancias;
    }

    public void setGanancias(String ganancias) {
        this.ganancias = ganancias;
    }

    public String getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(String telMovil) {
        this.telMovil = telMovil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apePaterno=" + apePaterno + ", apeMaterno=" + apeMaterno + ", genero=" + genero + ", nivelEstudio=" + nivelEstudio + ", ganancias=" + ganancias + ", telMovil=" + telMovil + ", email=" + email + '}';
    }
    
    
    
}
