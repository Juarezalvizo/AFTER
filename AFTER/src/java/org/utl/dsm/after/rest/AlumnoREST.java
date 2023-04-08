/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.after.rest;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import org.utl.dsm.cafter.core.ControllerAlumno;
import org.utl.dsm.mafter.model.Alumno;
import org.utl.dsm.mafter.model.Usuario;

/**
 *
 * @author franc
 */
@Path("alumno")
public class AlumnoREST {

    @Path("insertAlum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertAlumno(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        String out = "";
        ControllerAlumno conAl = new ControllerAlumno();
        Alumno a = new Alumno();
        a = gson.fromJson(datos, Alumno.class);
        try {
            conAl.insertAlumn(a);
            out = gson.toJson(a);
            System.out.println(a);
        } catch (JsonParseException jpe) {
            out = "{\"error\":\"Error de formato\"}";
        } catch (SQLException ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("recuperar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertar(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Usuario u = new Usuario();

        u = gson.fromJson(datos, Usuario.class);
        String out = "";

        ControllerAlumno conAl = new ControllerAlumno();
        System.out.println(u);
                try {
                    conAl.recuperarContraseña(u);
                    out = gson.toJson(u);
                } catch (JsonParseException jpe) {
                    out = "{\"error\":\"Error de formato\"}";
                } catch (SQLException ex) {
                    out = "{\"error\":\"" + ex.toString() + "\"}";
                }
            
        return Response.status(Response.Status.OK).entity(out).build();
    }
}