package pe.edu.upc.stumatch.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.stumatch.model.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{

}
