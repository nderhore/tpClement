package com.tpjee.app.resources;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tpjee.app.ejb.Appli;
import com.tpjee.app.model.Vin;

/**
 * vin
 */
@Path("vin")
public class ChampRessource {

  static List<Vin> champ = new ArrayList<>();

@Inject
Appli appli;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get() {
    return Response.ok(appli.getAllVin()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response post(Vin vin) {
    appli.addVin(vin);
    return Response.ok().build();
  }

  @DELETE
  @Path("{name}")
  public Response delete(@PathParam("name") String name) {
      appli.deleteVinByName(name);
      return Response.ok().build();
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public Response update(Vin nomVin) {
    appli.update(nomVin);
    return Response.ok().build();
  }
}

