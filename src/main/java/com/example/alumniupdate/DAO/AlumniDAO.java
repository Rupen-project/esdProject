package com.example.alumniupdate.DAO;

import com.example.alumniupdate.bean.Alumni;
import com.example.alumniupdate.bean.Alumni_Organisation;
import com.example.alumniupdate.bean.Alumni_education;
import com.example.alumniupdate.bean.Organisation;

import java.util.List;

public interface AlumniDAO {
    Alumni getAlumniById(int alumniId);

    Alumni_education getAlumniEducationById(int alumniId);

    List<Alumni_Organisation> getAlumniOrganisationById(int alumniId);

    boolean updateAlumni(Alumni alumni);

    boolean updateAlumniEducation(Alumni_education alumniEducation);

    List<Organisation> getOrganisations();

    boolean deleteOrganisation(Alumni_Organisation alumni_organisation);

    boolean updateOrganisation(Alumni_Organisation alumni_organisation);

    boolean addOrganisation(Alumni_Organisation alumni_organisation);
}
