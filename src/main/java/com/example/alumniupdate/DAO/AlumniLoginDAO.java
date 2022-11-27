package com.example.alumniupdate.DAO;

import com.example.alumniupdate.bean.Alumni;

public interface AlumniLoginDAO {
    void updateAlumni(Alumni a);

    Alumni verify(Alumni alumni);

}
