package com.assir.yassine.rest;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;

@Path("test")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Date testMethod() {
        return Calendar.getInstance().getTime();
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public MyDate getDate(MyDate date) {
        System.out.println(date);
        return date;
    }
}
