package edu.isgb.school.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;
    private String name;
    private Date birthDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_PK_ADDRESS")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "school_PK_school")
    private School school;

    // Getters and Setters
    public Integer getIdStudent() { return idStudent; }
    public void setIdStudent(Integer idStudent) { this.idStudent = idStudent; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public School getSchool() {return school;}
    public void setSchool(School school) {this.school = school;}
}
