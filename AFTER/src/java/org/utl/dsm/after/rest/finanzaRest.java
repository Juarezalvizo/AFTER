/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.after.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.cafter.core.ControllerFinanza;
import org.utl.dsm.mafter.model.Finanza;

/**
 *
 * @author Lenovo
 */
@Path("fi")
public class finanzaRest {
    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFinanzas() {
        String output = "";
        Gson gson = new Gson();
        try {
            ControllerFinanza objCF = new ControllerFinanza();
            List<Finanza> finanzas = objCF.getAll("1");
            output = gson.toJson(finanzas);
        } catch (Exception ex) {
            output = "{\"error\": \"" + ex.getMessage() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(output).build();
    }
}

    
    

