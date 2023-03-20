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
    
 int idAviso;
String nombre, hora, dia;
Agenda agenda;
Finanza finanza;

    public Aviso(int idAviso, String nombre, String hora, String dia, Agenda agenda, Finanza finanza) {
        this.idAviso = idAviso;
        this.nombre = nombre;
        this.hora = hora;
        this.dia = dia;
        this.agenda = agenda;
        this.finanza = finanza;
    }

    public Aviso() {
    }

    public Aviso(String nombre, String hora, String dia, Agenda agenda, Finanza finanza) {
        this.nombre = nombre;
        this.hora = hora;
        this.dia = dia;
        this.agenda = agenda;
        this.finanza = finanza;
    }

    public int getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(int idAviso) {
        this.idAviso = idAviso;
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

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Finanza getFinanza() {
        return finanza;
    }

    public void setFinanza(Finanza finanza) {
        this.finanza = finanza;
    }

    @Override
    public String toString() {
        return "Aviso{" + "idAviso=" + idAviso + ", nombre=" + nombre + ", hora=" + hora + ", dia=" + dia + ", agenda=" + agenda + ", finanza=" + finanza + '}';
    }
    

}
