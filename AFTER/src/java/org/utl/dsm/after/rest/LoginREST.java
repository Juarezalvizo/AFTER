/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.after.rest;

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
import org.utl.dsm.cafter.core.ControladorLogin;
import org.utl.dsm.mafter.model.Alumno;
import org.utl.dsm.mafter.model.Usuario;

/**
 *
 * @author franc
 */
@Path("login")
public class LoginREST {
    
    @Path("log")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response entrar(@FormParam("usuario") @DefaultValue("") String u) {
        String out = null;
        Alumno alumno = null;
        Usuario usuario = null;
        ControladorLogin cl = null;
        Gson gson = new Gson();
        //Aqui se resive el parametro;
        try {
            usuario = gson.fromJson(u, Usuario.class);
            System.out.println("este usu: "+usuario);
            cl = new ControladorLogin();
            alumno = cl.entrar(usuario);

            if (alumno != null) {
                alumno.getUsuario().setLastToken();
                cl.guardarToken(alumno);
                out = gson.toJson(alumno);
            } else {
                out = "{\"error\":\"Acceso no consedido...\"}\n";
            }

        } catch (JsonParseException jpe) {
            out = "{\"error\":\"Forma de datos no valida...\"}\n";
            jpe.printStackTrace();
        } catch (Exception e) {
            out = "{\"error\":\"Acceso no consedidOo...\"}\n";
            e.printStackTrace();
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("salire")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response logOuta(@FormParam("empleado") @DefaultValue("") String e) {
        Gson gson = new Gson();
        Alumno alumno =  null;
        String out = null;
        ControladorLogin cA = null;

        try {
            alumno = gson.fromJson(e, Alumno.class);
            cA = new ControladorLogin();
//            System.out.println(empleado);
//            System.out.println("------------------------");
            if(cA.eliminarToken(alumno)){
                out = "{\"OK\":\"Se elimino correctamente...\"}\n";
            }else{
                out = "{\"error\":\"Error al eliminarlo...\"}\n";
            }
        } catch (JsonParseException jpe) {
            out = "{\"error\":\"Error de formato...\"}\n";
            
            jpe.printStackTrace();
            
        }catch (SQLException ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }catch(Exception ex){
            out = "{\"error\":\"Acceso no concedido...\"}\n";
            ex.printStackTrace();
        }
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
}
