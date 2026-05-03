package edu.isgb.school.entities;

import jakarta.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartment;
    private String name;
    @ManyToOne
    @JoinColumn(name = "school_PK_school")
    private School school;

    // Getters and Setters
    public Integer getIdDepartment() { return idDepartment; }
    public void setIdDepartment(Integer idDepartment) { this.idDepartment = idDepartment; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
