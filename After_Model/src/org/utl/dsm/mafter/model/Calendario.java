/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.mafter.model;

/**
 *
 * @author Lenovo
 */
public class Calendario {
   int idCalendario;
   Agenda agenda;
   Finanza finanza;
   Aviso aviso;
   
    public Calendario() {
    }

    public Calendario(Agenda agenda, Finanza finanza, Aviso aviso) {
        this.agenda = agenda;
        this.finanza = finanza;
        this.aviso = aviso;
    }

    public Calendario(int idCalendario, Agenda agenda, Finanza finanza, Aviso aviso) {
        this.idCalendario = idCalendario;
        this.agenda = agenda;
        this.finanza = finanza;
        this.aviso = aviso;
    }

    public int getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(int idCalendario) {
        this.idCalendario = idCalendario;
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

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    @Override
    public String toString() {
        return "Calendario{" + "idCalendario=" + idCalendario + ", agenda=" + agenda + ", finanza=" + finanza + ", aviso=" + aviso + '}';
    }


    
   
   
}
