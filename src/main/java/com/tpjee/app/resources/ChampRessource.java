package com.lol.app.resources;

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

import com.lol.app.ejb.Appli;
import com.lol.app.model.*;

/**
 * champion de lol
 */
@Path("range")
public class ChampRessource {

  static List<Range> champ = new ArrayList<>();

@Inject
Appli appli;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get() {
    return Response.ok(appli.getCrewMembers()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response post(Range champion) {
    appli.addCrewMember(champion);
    return Response.ok().build();
  }

  @DELETE
  @Path("{name}")
  public Response delete(@PathParam("name") String name) {
      appli.deleteCrewMemberByName(name);
      return Response.ok().build();
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public Response update(Range champ) {
  appli.update(champ);
  return Response.ok().build();
  }
}

