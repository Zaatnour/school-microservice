package edu.isgb.school.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInstructor;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "t_instructor_t_course",
            joinColumns = @JoinColumn(name = "instructors_pk_Instructor"),
            inverseJoinColumns = @JoinColumn(name = "courses_pk_course")
    )
    private Set<Course> courses;
    @ManyToOne
    @JoinColumn(name = "school_PK_school")
    private School school;

    // Getters and Setters
    public Integer getIdInstructor() { return idInstructor; }
    public void setIdInstructor(Integer idInstructor) { this.idInstructor = idInstructor; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Course> getCourses() { return courses; }
    public void setCourses(Set<Course> courses) { this.courses = courses; }

    public School getSchool() {return school;}
    public void setSchool(School school) {this.school = school;}
}
