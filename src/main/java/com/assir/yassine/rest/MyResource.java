package com.assir.yassine.rest;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;

@Path("test")
public class MyResource {

    @GET
    @Produces(value = {"text/shortdate", MediaType.TEXT_PLAIN})
    public Date testMethod() {
        return Calendar.getInstance().getTime();
    }

}
