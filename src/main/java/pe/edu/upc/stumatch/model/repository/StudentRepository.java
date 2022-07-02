package pe.edu.upc.stumatch.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.stumatch.model.entity.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, String>{
	List<Student> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;

}
