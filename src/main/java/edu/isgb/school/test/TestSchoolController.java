package edu.isgb.school.test;

import edu.isgb.school.entities.*;
import edu.isgb.school.services.SchoolService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class TestSchoolController {

    private SchoolService schoolService;

    // Constructor
    public TestSchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    // a. Create a new School
    @PostMapping("/schools")
    public School createSchool(@RequestBody School school) {
        return schoolService.createSchool(school);
    }

    // b. Get a School by id
    @GetMapping("/schools/{id}")
    public School getSchoolById(@PathVariable Integer id) {
        return schoolService.getSchoolById(id);
    }

    // c. Create a new Student
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return schoolService.createStudent(student);
    }

    // d. List all Students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return schoolService.getAllStudents();
    }

    // e. Create an Instructor
    @PostMapping("/instructors")
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return schoolService.createInstructor(instructor);
    }

    // f. List Instructors by name
    @GetMapping("/instructors/name/{name}")
    public List<Instructor> getInstructorsByName(@PathVariable String name) {
        return schoolService.getInstructorsByName(name);
    }

    // g. Get an Instructor by id
    @GetMapping("/instructors/{id}")
    public Instructor getInstructorById(@PathVariable Integer id) {
        return schoolService.getInstructorById(id);
    }

    // h. Get a Course by id
    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable Integer id) {
        return schoolService.getCourseById(id);
    }

    // i. List Courses of an Instructor
    @GetMapping("/instructors/{id}/courses")
    public Set<Course> getCoursesByInstructor(@PathVariable Integer id) {
        return schoolService.getCoursesByInstructor(id);
    }

    // j. Add a Course to an Instructor
    @PostMapping("/instructors/{id}/courses")
    public Instructor addCourseToInstructor(@PathVariable Integer id,
                                            @RequestBody Course course) {
        return schoolService.addCourseToInstructor(id, course);
    }
}
