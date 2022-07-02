package pe.edu.upc.stumatch.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.stumatch.model.repository.StudentRepository;
import pe.edu.upc.stumatch.business.crud.StudentService;
import pe.edu.upc.stumatch.model.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public JpaRepository<Student, String> getJpaRepository() {
		return this.studentRepository;
	}

	@Override
	public List<Student> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
		return this.studentRepository.findByLastNameAndFirstName(lastName, firstName);
	}

}
