package edu.isgb.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSchool;
    private String name;
    private Integer phone;
    @JsonIgnore
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private Set<Department> departments;
    @JsonIgnore
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private Set<Student> students;
    @JsonIgnore
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private Set<Instructor> instructors;

    // Getters and Setters
    public Integer getIdSchool() { return idSchool; }
    public void setIdSchool(Integer idSchool) { this.idSchool = idSchool; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getPhone() { return phone; }
    public void setPhone(Integer phone) { this.phone = phone; }

    public Set<Department> getDepartments() {return departments;}
    public void setDepartments(Set<Department> departments) {this.departments = departments;}

    public Set<Student> getStudents() {return students;}
    public void setStudents(Set<Student> students) {this.students = students;}

    public Set<Instructor> getInstructors() {return instructors;}
    public void setInstructors(Set<Instructor> instructors) {this.instructors = instructors;}
}