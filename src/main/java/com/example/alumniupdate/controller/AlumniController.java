package com.example.alumniupdate.controller;

import com.example.alumniupdate.DAO.AlumniDAO;
import com.example.alumniupdate.DAO.AlumniLoginDAO;
import com.example.alumniupdate.DAO.DAOImplementation.AlumniDAOImpl;
import com.example.alumniupdate.DAO.DAOImplementation.AlumniLoginDAOImpl;
import com.example.alumniupdate.bean.Alumni;
import com.example.alumniupdate.bean.Alumni_Organisation;
import com.example.alumniupdate.bean.Alumni_education;
import com.example.alumniupdate.bean.Organisation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/dashboard")
public class AlumniController {
    AlumniDAO alumniDAO = new AlumniDAOImpl();

    @GET
    @Path("/alumni1/{id}")
    @Produces(MediaType.APPLICATION_JSON) //return type
    public Response getAlumni1ById(@PathParam("id") int alumniId){
        Alumni a = alumniDAO.getAlumniById(alumniId);
        if(a!=null){
            return Response.status(200).entity(a).build();
        }
        return Response.status(400).entity(a).build();
    }



    @GET
    @Path("/alumni2/{id}")
    @Produces(MediaType.APPLICATION_JSON) //return type
    public Response getAlumni2ById(@PathParam("id") int alumniId){
        Alumni_education a = alumniDAO.getAlumniEducationById(alumniId);
        if(a!=null){
            return Response.status(200).entity(a).build();
        }
        return Response.status(400).entity(a).build();
    }

    @GET
    @Path("/alumni3/{id}")
    @Produces(MediaType.APPLICATION_JSON) //return type
    public Response getAlumni3ById(@PathParam("id") int alumniId){
        List<Alumni_Organisation> a = alumniDAO.getAlumniOrganisationById(alumniId);
        if(a!=null){
            return Response.status(200).entity(a).build();
        }
        return Response.status(400).entity(a).build();
    }

    @POST
    @Path("/updateAlumni")
    @Produces(MediaType.APPLICATION_JSON) //return type
    @Consumes(MediaType.APPLICATION_JSON) //return type
    public Response updateAlumni(Alumni alumni){
        if(alumniDAO.updateAlumni(alumni)){
            return Response.status(200).entity("Update Success!").build();
        }
        return Response.status(400).entity("Error in Updation!").build();
    }

    @POST
    @Path("/updateAlumniEducation")
    @Produces(MediaType.APPLICATION_JSON) //return type
    @Consumes(MediaType.APPLICATION_JSON) //return type
    public Response updateAlumniEducation(Alumni_education alumniEducation){
        if(alumniDAO.updateAlumniEducation(alumniEducation)){
            return Response.status(200).entity("Update Success!").build();
        }
        return Response.status(400).entity("Error in Updation!").build();
    }

    @GET
    @Path("/getOrganisations")
    @Produces(MediaType.APPLICATION_JSON) //return type
    public Response getOrganisations(){
        List<Organisation> a = alumniDAO.getOrganisations();
        if(a!=null){
            return Response.status(200).entity(a).build();
        }
        return Response.status(400).entity(a).build();
    }

    @POST
    @Path("/deleteOrganisation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON) //return type
    public Response deleteOrganisation(Alumni_Organisation alumni_organisation){
        if(alumniDAO.deleteOrganisation(alumni_organisation)){
            return Response.status(200).entity("Deleted Successfully").build();
        }
        return Response.status(400).entity("Error in deletion").build();
    }

    @POST
    @Path("/updateOrganisation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON) //return type
    public Response updateOrganisation(Alumni_Organisation alumni_organisation){
        if(alumniDAO.updateOrganisation(alumni_organisation)){
            return Response.status(200).entity("Updated Successfully").build();
        }
        return Response.status(400).entity("Error in updation").build();
    }

    @POST
    @Path("/addOrganisation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON) //return type
    public Response addOrganisation(Alumni_Organisation alumni_organisation){
        if(alumniDAO.addOrganisation(alumni_organisation)){
            return Response.status(200).entity("Added Successfully").build();
        }
        return Response.status(400).entity("Error in addition").build();
    }


}
