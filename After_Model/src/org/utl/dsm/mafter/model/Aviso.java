/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.mafter.model;

/**
 *
 * @author Lenovo
 */
public class Aviso {
    
 int idAviso,estatus;
 Usuario usuario;
String nombre, hora, dia;

    public Aviso() {
    }

    public Aviso(int estatus, Usuario usuario, String nombre, String hora, String dia) {
        this.estatus = estatus;
        this.usuario = usuario;
        this.nombre = nombre;
        this.hora = hora;
        this.dia = dia;
    }

    public Aviso(int idAviso, int estatus, Usuario usuario, String nombre, String hora, String dia) {
        this.idAviso = idAviso;
        this.estatus = estatus;
        this.usuario = usuario;
        this.nombre = nombre;
        this.hora = hora;
        this.dia = dia;
    }

    public int getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(int idAviso) {
        this.idAviso = idAviso;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "Aviso{" + "idAviso=" + idAviso + ", estatus=" + estatus + ", usuario=" + usuario.toString() + ", nombre=" + nombre + ", hora=" + hora + ", dia=" + dia + '}';
    }

    
}
