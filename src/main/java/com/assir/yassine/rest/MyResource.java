package com.assir.yassine.rest;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test")
public class MyResource {

    /*
    With @Singleton resource, this does not work.
    Because, singleton resources are instantiated during application startup.
    So, you can not inject request-specific information to their member variables.
     */

    @PathParam("pathParam") private String pathParamExample;
    @QueryParam("query") private String queryParamExample;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testMethod() {
        return "Test works! Path param used: " + pathParamExample +
                " and Query param used: " + queryParamExample;
    }
}
