package pe.edu.upc.stumatch.business.crud;

import java.util.List;

import pe.edu.upc.stumatch.model.entity.Teacher;

public interface TeacherService extends CrudService<Teacher, String>{
	List<Teacher> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;

}
