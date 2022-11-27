package com.example.alumniupdate.controller;

import com.example.alumniupdate.DAO.AlumniDAO;
import com.example.alumniupdate.DAO.AlumniLoginDAO;
import com.example.alumniupdate.DAO.DAOImplementation.AlumniDAOImpl;
import com.example.alumniupdate.DAO.DAOImplementation.AlumniLoginDAOImpl;
import com.example.alumniupdate.bean.Alumni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/dashboard")
public class AlumniController {
    AlumniDAO alumniDAO = new AlumniDAOImpl();

    @GET
    @Path("/alumni/{id}")
    @Produces(MediaType.APPLICATION_JSON) //return type
    public Response getAlumniById(@PathParam("id") int alumniId){
        Alumni a = alumniDAO.getAlumniById(alumniId);
        if(a!=null){
            return Response.status(200).entity(a).build();
        }
        return Response.status(400).entity(a).build();
    }

}
