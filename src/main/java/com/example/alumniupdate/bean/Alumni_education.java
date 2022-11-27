package com.example.alumniupdate.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Alumni_education {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int alumniEducationId;

   @Column(nullable = false)
   private String degree;

   @Column(nullable = false)
   private Date passing_year;

   @Column(nullable = false)
   private Date joining_year;

   @Column
   private String collegeName;

   @Column
   private String address;

   @OneToOne
   private Alumni alumni;

   public Alumni_education(){

   }

   public Alumni_education(int alumniEducationId, String degree, Date passing_year, Date joining_year, String collegeName, String address, Alumni alumni) {
      this.alumniEducationId = alumniEducationId;
      this.degree = degree;
      this.passing_year = passing_year;
      this.joining_year = joining_year;
      this.collegeName = collegeName;
      this.address = address;
      this.alumni = alumni;
   }

   public int getAlumniEducationId() {
      return alumniEducationId;
   }

   public void setAlumniEducationId(int alumniEducationId) {
      this.alumniEducationId = alumniEducationId;
   }

   public String getDegree() {
      return degree;
   }

   public void setDegree(String degree) {
      this.degree = degree;
   }

   public Date getPassing_year() {
      return passing_year;
   }

   public void setPassing_year(Date passing_year) {
      this.passing_year = passing_year;
   }

   public Date getJoining_year() {
      return joining_year;
   }

   public void setJoining_year(Date joining_year) {
      this.joining_year = joining_year;
   }

   public String getCollegeName() {
      return collegeName;
   }

   public void setCollegeName(String collegeName) {
      this.collegeName = collegeName;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public Alumni getAlumni() {
      return alumni;
   }

   public void setAlumni(Alumni alumni) {
      this.alumni = alumni;
   }

   @Override
   public String toString() {
      return "Alumni_education{" +
              "alumniEducationId=" + alumniEducationId +
              ", degree='" + degree + '\'' +
              ", passing_year=" + passing_year +
              ", joining_year=" + joining_year +
              ", collegeName='" + collegeName + '\'' +
              ", address='" + address + '\'' +
              ", alumni=" + alumni +
              '}';
   }
}
