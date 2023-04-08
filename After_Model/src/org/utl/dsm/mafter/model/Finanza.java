/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.mafter.model;

/**
 *
 * @author Lenovo
 */
public class Finanza {
   int idFinanza;
   Alumno alumno;
   String costeTitulo ;
float cantidadCoste;
String fechaHoraCoste ; 
  String costeDes ;
int estatus;
    public Finanza() {
    }

    public Finanza(int idFinanza, Alumno alumno, String costeTitulo, float cantidadCoste, String fechaHoraCoste, String costeDes, int eestatus) {
        this.idFinanza = idFinanza;
        this.alumno = alumno;
        this.costeTitulo = costeTitulo;
        this.cantidadCoste = cantidadCoste;
        this.fechaHoraCoste = fechaHoraCoste;
        this.costeDes = costeDes;
        this.estatus= estatus;
    }

    public Finanza(Alumno alumno,  String costeTitulo, float cantidadCoste, String fechaHoraCoste, String costeDes, int estatus) {
        this.alumno = alumno;
        this.costeTitulo = costeTitulo;
        this.cantidadCoste = cantidadCoste;
        this.fechaHoraCoste = fechaHoraCoste;
        this.costeDes = costeDes;
        this.estatus= estatus;
    }

    

    public int getIdFinanza() {
        return idFinanza;
    }

    public void setIdFinanza(int idFinanza) {
        this.idFinanza = idFinanza;
    }

    

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public float getCantidadCoste() {
        return cantidadCoste;
    }

    public void setCantidadCoste(float cantidadCoste) {
        this.cantidadCoste = cantidadCoste;
    }

    public String getCosteTitulo() {
        return costeTitulo;
    }

    public void setCosteTitulo(String costeTitulo) {
        this.costeTitulo = costeTitulo;
    }

    public String getCosteDes() {
        return costeDes;
    }

    public void setCosteDes(String costeDes) {
        this.costeDes = costeDes;
    }

    public String getFechaHoraCoste() {
        return fechaHoraCoste;
    }

    public void setFechaHoraCoste(String fechaHoraCoste) {
        this.fechaHoraCoste = fechaHoraCoste;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    
    
    @Override
    public String toString() {
        return "Finanza{" + "idFinanza=" + idFinanza +  ", alumno=" + alumno + ", cantidadCoste=" + cantidadCoste + 
                ", costeTitulo=" + costeTitulo + ", costeDes=" + costeDes +
                ", fechaHoraCoste=" + fechaHoraCoste + ", estatus"+ estatus+ '}';
    }

    
}
