package pe.edu.upc.stumatch.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.stumatch.model.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String>{
	List<Teacher> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
	
}
