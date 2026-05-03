package edu.isgb.school.services;

import edu.isgb.school.entities.*;
import edu.isgb.school.repositories.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class SchoolService {

    private SchoolRepository schoolRepository;
    private StudentRepository studentRepository;
    private InstructorRepository instructorRepository;
    private CourseRepository courseRepository;

    // Constructor
    public SchoolService(SchoolRepository schoolRepository,
                         StudentRepository studentRepository,
                         InstructorRepository instructorRepository,
                         CourseRepository courseRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }
    // a. Create a new School
    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    // b. Get a School by id
    public School getSchoolById(Integer id) {
        return schoolRepository.findById(id).orElse(null);
    }

    // c. Create a new Student with Address and School
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // d. List all Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // e. Create an Instructor with a list of courses
    public Instructor createInstructor(Instructor instructor) {
        if (instructor.getCourses() != null) {
            courseRepository.saveAll(instructor.getCourses());
        }
        return instructorRepository.save(instructor);
    }
    // f. List Instructors by name
    public List<Instructor> getInstructorsByName(String name) {
        return instructorRepository.findByName(name);
    }

    // g. Get an Instructor by id
    public Instructor getInstructorById(Integer id) {
        return instructorRepository.findById(id).orElse(null);
    }

    // h. Get a Course by id
    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    // i. List Courses of an Instructor by id
    public Set<Course> getCoursesByInstructor(Integer instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElse(null);
        if (instructor != null) {
            return instructor.getCourses();
        }
        return null;
    }

    // j. Add a Course to an existing Instructor
    public Instructor addCourseToInstructor(Integer instructorId, Course course) {
        Instructor instructor = instructorRepository.findById(instructorId).orElse(null);
        if (instructor != null) {
            instructor.getCourses().add(course);
            courseRepository.save(course);
            return instructorRepository.save(instructor);
        }
        return null;
    }

}
