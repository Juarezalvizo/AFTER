/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.after.REST;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import org.utl.dsm.cafter.core.ControladorLogin;
import org.utl.dsm.cafter.core.ControllerAviso;
import org.utl.dsm.mafter.model.Alumno;
import org.utl.dsm.mafter.model.Aviso;
import org.utl.dsm.mafter.model.Usuario;

/**
 *
 * @author franc
 */
@Path("avisos")
public class AvisosREST {
    
    @Path("insertarAviso")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertar(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Aviso a = new Aviso();
        ControladorLogin conIn = new ControladorLogin();

        a = gson.fromJson(datos, Aviso.class);
        String out = "";

        ControllerAviso objCE = new ControllerAviso();
        
                try {
                    objCE.insert(a);
                    out = gson.toJson(a);
                } catch (JsonParseException jpe) {
                    out = "{\"error\":\"Error de formato\"}";
                } catch (SQLException ex) {
                    out = "{\"error\":\"" + ex.toString() + "\"}";
                }
            
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("actualizarAviso")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Aviso a = new Aviso();
        ControladorLogin conIn = new ControladorLogin();

        a = gson.fromJson(datos, Aviso.class);
        String out = "";
        
        System.out.println("tambien "+a);
        
        ControllerAviso objCE = new ControllerAviso();
        
                try {
                    objCE.actualizar(a);
                    out = gson.toJson(a);
                } catch (JsonParseException jpe) {
                    out = "{\"error\":\"Error de formato\"}";
                } catch (SQLException ex) {
                    out = "{\"error\":\"" + ex.toString() + "\"}";
                }
            
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("eliminarAviso")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar2(@FormParam("idAviso") @DefaultValue("0") int idAviso) {
        String out = "";
        Gson gson = new Gson();
        Aviso a = new Aviso();

        try {
           ControllerAviso cntAviso = new ControllerAviso();
                    int aviso = cntAviso.eliminarAviso(idAviso);
                    Gson gs = new Gson();//convierte un json a un objeto y bicebersa
                    out = gs.toJson(aviso);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            out = "(\"error\":\"" + ex.toString() + "\")";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("activarAviso")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response activar(@FormParam("idAviso") @DefaultValue("0") int idAviso) {
        String out = "";
        Gson gson = new Gson();
        Aviso a = new Aviso();
        System.out.println(idAviso);
        try {
           ControllerAviso cntAviso = new ControllerAviso();
                    int aviso = cntAviso.activarAviso(idAviso);
                    Gson gs = new Gson();//convierte un json a un objeto y bicebersa
                    out = gs.toJson(aviso);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            out = "(\"error\":\"" + ex.toString() + "\")";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("eliminarDB")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarDB(@FormParam("idAviso") @DefaultValue("0") int idAviso) {
        String out = "";
        Gson gson = new Gson();
        Aviso a = new Aviso();
        System.out.println(idAviso);
        try {
           ControllerAviso cntAviso = new ControllerAviso();
                    int aviso = cntAviso.elinarDB(idAviso);
                    Gson gs = new Gson();//convierte un json a un objeto y bicebersa
                    out = gs.toJson(aviso);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            out = "(\"error\":\"" + ex.toString() + "\")";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAll")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus,
                            @FormParam("id") @DefaultValue("0") String id){
        String out="";
        System.out.println(estatus);
        try {
                    ControllerAviso cmEmpleado = new ControllerAviso();
                    List<Aviso> empleado = cmEmpleado.getAll(estatus,id);
                    Gson gs = new Gson();
                    out = gs.toJson(empleado);
                    System.out.println(out);
                } catch (JsonParseException jpe) {
                    out = "{\"error\":\"Error de formato\"}";
                } catch (SQLException ex) {
                    out = "{\"error\":\"" + ex.toString() + "\"}";
                }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
}
