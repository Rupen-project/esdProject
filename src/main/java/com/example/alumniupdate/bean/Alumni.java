package com.example.alumniupdate.bean;

import jakarta.persistence.*;

@Entity
@Table
public class Alumni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alumniId;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String contact_number;

    @Column(nullable = false)
    private String password;

    public Alumni() {
    }

    public Alumni(String email, String contact_number, String password) {
        this.alumniId = alumniId;
        this.email = email;
        this.contact_number = contact_number;
        this.password = password;
    }

    public int getAlumniId() {
        return alumniId;
    }

    public void setAlumniId(int alumniId) {
        this.alumniId = alumniId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Alumni{" +
                "alumniId=" + alumniId +
                ", email='" + email + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
