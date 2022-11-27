package com.example.alumniupdate.controller;

import com.example.alumniupdate.DAO.AlumniLoginDAO;
import com.example.alumniupdate.DAO.DAOImplementation.AlumniLoginDAOImpl;
import com.example.alumniupdate.bean.Alumni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class AlumniLoginController {

    AlumniLoginDAO alumniLoginDAO = new AlumniLoginDAOImpl();

    @POST
    @Path("/alumni")
    @Produces(MediaType.APPLICATION_JSON) //return type

    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response adminLogin(Alumni alumni){
        System.out.printf(String.valueOf(alumni));
        Alumni a = alumniLoginDAO.verify(alumni);
        if(a!=null){
            return Response.status(200).entity(a).build();
        }
        return Response.status(400).entity(a).build();
    }
}