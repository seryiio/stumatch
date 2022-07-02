package pe.edu.upc.stumatch.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.stumatch.business.crud.CourseService;
import pe.edu.upc.stumatch.model.entity.Course;
import pe.edu.upc.stumatch.model.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public JpaRepository<Course, String> getJpaRepository() {
		return this.courseRepository;
	}
}
