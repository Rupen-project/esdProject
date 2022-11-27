package com.example.alumniupdate.bean;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Alumni_Organisation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alumniOrganisationId;

    @Column
    private String position;

    @Column(nullable = false)
    private Date joining_date;

    @Column(nullable = false)
    private Date leaving_date;

    @ManyToOne
    private Alumni alumni;

    @ManyToOne
    private Organisation organisation;

    public Alumni_Organisation() {
    }

    public Alumni_Organisation(int alumniOrganisationId, String position, Date joining_date, Date leaving_date, Alumni alumni, Organisation organisation) {
        this.alumniOrganisationId = alumniOrganisationId;
        this.position = position;
        this.joining_date = joining_date;
        this.leaving_date = leaving_date;
        this.alumni = alumni;
        this.organisation = organisation;
    }

    public int getAlumniOrganisationId() {
        return alumniOrganisationId;
    }

    public void setAlumniOrganisationId(int alumniOrganisationId) {
        this.alumniOrganisationId = alumniOrganisationId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(Date joining_date) {
        this.joining_date = joining_date;
    }

    public Date getLeaving_date() {
        return leaving_date;
    }

    public void setLeaving_date(Date leaving_date) {
        this.leaving_date = leaving_date;
    }

    public Alumni getAlumni() {
        return alumni;
    }

    public void setAlumni(Alumni alumni) {
        this.alumni = alumni;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    @Override
    public String toString() {
        return "Alumni_Organisation{" +
                "alumniOrganisationId=" + alumniOrganisationId +
                ", position='" + position + '\'' +
                ", joining_date=" + joining_date +
                ", leaving_date=" + leaving_date +
                ", alumni=" + alumni +
                ", organisation=" + organisation +
                '}';
    }
}
