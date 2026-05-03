package edu.isgb.school.repositories;

import edu.isgb.school.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    List<Instructor> findByName(String name);
}