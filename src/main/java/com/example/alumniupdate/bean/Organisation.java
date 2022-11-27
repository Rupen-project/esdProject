package com.example.alumniupdate.bean;

import jakarta.persistence.*;

@Entity
@Table

public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organisationId;

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    public Organisation() {
    }

    public int getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(int organisationId) {
        this.organisationId = organisationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "organisationId=" + organisationId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
