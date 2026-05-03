package edu.isgb.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    private Set<Instructor> instructors;

    // Getters and Setters
    public Integer getIdCourse() { return idCourse; }
    public void setIdCourse(Integer idCourse) { this.idCourse = idCourse; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Instructor> getInstructors() { return instructors; }
    public void setInstructors(Set<Instructor> instructors) { this.instructors = instructors; }
}
