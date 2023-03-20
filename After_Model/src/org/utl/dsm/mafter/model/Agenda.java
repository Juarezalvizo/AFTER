/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.mafter.model;

/**
 *
 * @author Lenovo
 */
public class Agenda {

    int idAgenda;
    String materia, 
            actiTitulo ,
            actiDes ,
            fechaHoraReg ,
            fechaHoraVenci;

    public Agenda() {
    }

    public Agenda(int idAgenda, String materia, String actiTitulo, String actiDes, String fechaHoraReg, String fechaHoraVenci) {
        this.idAgenda = idAgenda;
        this.materia = materia;
        this.actiTitulo = actiTitulo;
        this.actiDes = actiDes;
        this.fechaHoraReg = fechaHoraReg;
        this.fechaHoraVenci = fechaHoraVenci;
    }

    public Agenda(String materia, String actiTitulo, String actiDes, String fechaHoraReg, String fechaHoraVenci) {
        this.materia = materia;
        this.actiTitulo = actiTitulo;
        this.actiDes = actiDes;
        this.fechaHoraReg = fechaHoraReg;
        this.fechaHoraVenci = fechaHoraVenci;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getActiTitulo() {
        return actiTitulo;
    }

    public void setActiTitulo(String actiTitulo) {
        this.actiTitulo = actiTitulo;
    }

    public String getActiDes() {
        return actiDes;
    }

    public void setActiDes(String actiDes) {
        this.actiDes = actiDes;
    }

    public String getFechaHoraReg() {
        return fechaHoraReg;
    }

    public void setFechaHoraReg(String fechaHoraReg) {
        this.fechaHoraReg = fechaHoraReg;
    }

    public String getFechaHoraVenci() {
        return fechaHoraVenci;
    }

    public void setFechaHoraVenci(String fechaHoraVenci) {
        this.fechaHoraVenci = fechaHoraVenci;
    }

    @Override
    public String toString() {
        return "Agenda{" + "idAgenda=" + idAgenda + ", materia=" + materia + ", actiTitulo=" + actiTitulo + ", actiDes=" + actiDes + ", fechaHoraReg=" + fechaHoraReg + ", fechaHoraVenci=" + fechaHoraVenci + '}';
    }
    
    
    
}
