/*
Autor:Escobedo Gonzalez Emmanuel
Empresa: E-DDIT
Fecha:21/03/2023
Descripcion: 
    insert: Este método permite insertar una nueva actividad en la agenda.
            Toma como parámetro un objeto JSON que contiene los detalles de la actividad,
            lo convierte en un objeto Agenda y lo pasa al controlador para su inserción. 
            Retorna un objeto JSON con los detalles de la actividad insertada.

    getAllG: Este método retorna todas las actividades de la agenda en forma de una lista de 
            objetos Agenda. Retorna un objeto JSON con la lista de actividades o un objeto de error si ocurre
            una excepción durante la consulta.
 */
package org.utl.dsm.after.rest;
import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.cafter.core.ControllerAgenda;
import org.utl.dsm.mafter.model.Agenda;

@Path("agenda")
public class AgendarREST {
    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert (@FormParam("datos")@DefaultValue("")String datos){
        Gson gson = new Gson();
       Agenda a = new Agenda();
       
       a=gson.fromJson(datos, Agenda.class);
       String out = "";
        ControllerAgenda objCE =new ControllerAgenda();
        try {
            objCE.insertarG(a);
            out= gson.toJson(a);
        } catch (Exception ex) {
           out = "{result:"+ex.toString()+"}"; 
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAll")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus")@DefaultValue("1")String estatus){
        String out= "";
        try {
            ControllerAgenda objCE = new ControllerAgenda();
            List<Agenda> agenda = objCE.getAll(estatus);

            Gson gs= new Gson();
            out = gs.toJson(agenda);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            out = "{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllInactivos")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInactivos(@FormParam("estatus")@DefaultValue("0")String estatus){
        String out= "";
        try {
            ControllerAgenda objCE = new ControllerAgenda();
            List<Agenda> agenda = objCE.getAllInactivos(estatus);

            Gson gs= new Gson();
            out = gs.toJson(agenda);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            out = "{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar (@FormParam("idAgenda")@DefaultValue("0")int id){             
       
        String out = "";        
        try {
            ControllerAgenda objCE =new ControllerAgenda();
            int agenda = objCE.eliminar(id);
            Gson gson = new Gson();
            out = gson.toJson(agenda);
        } catch (Exception ex) {
            System.out.println(ex.toString());
           out = "{\"error\":\""+ex.toString()+"\"}"; 
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}

