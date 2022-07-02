package pe.edu.upc.stumatch.business.crud;

import java.util.List;

import pe.edu.upc.stumatch.model.entity.Student;

public interface StudentService extends CrudService<Student, String>{
	List<Student> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;

}
