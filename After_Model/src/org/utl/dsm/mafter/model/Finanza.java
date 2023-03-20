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
float cantidadCoste;
String costeTitulo ;
String costeDes ,fechaHoraCoste ;

    public Finanza() {
    }

    public Finanza(int idFinanza, float cantidadCoste, String costeTitulo, String costeDes, String fechaHoraCoste) {
        this.idFinanza = idFinanza;
        this.cantidadCoste = cantidadCoste;
        this.costeTitulo = costeTitulo;
        this.costeDes = costeDes;
        this.fechaHoraCoste = fechaHoraCoste;
    }

    public Finanza(float cantidadCoste, String costeTitulo, String costeDes, String fechaHoraCoste) {
        this.cantidadCoste = cantidadCoste;
        this.costeTitulo = costeTitulo;
        this.costeDes = costeDes;
        this.fechaHoraCoste = fechaHoraCoste;
    }

    public int getIdFinanza() {
        return idFinanza;
    }

    public void setIdFinanza(int idFinanza) {
        this.idFinanza = idFinanza;
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

    @Override
    public String toString() {
        return "Finanza{" + "idFinanza=" + idFinanza + ", cantidadCoste=" + cantidadCoste + ", costeTitulo=" + costeTitulo + ", costeDes=" + costeDes + ", fechaHoraCoste=" + fechaHoraCoste + '}';
    }


    
}
