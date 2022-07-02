package pe.edu.upc.stumatch.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "careers")
public class Career {
	@Id
	@NotEmpty(message = "Debe ingresar un ID")
	@Size(min = 1,max = 80, message = "El valor debe estar entre 1 y 8 digitos")
	@Column(name = "career_id", length = 8, nullable = false)
	private String id;
	
	@Size(min = 1,max = 80, message = "El valor debe estar entre 1 y 80 digitos")
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "career")
	private List<Student> students;
	
	@OneToMany(mappedBy = "career")
	private List<Teacher> teachers;
	
	@OneToMany(mappedBy = "career")
	private List<Course> courses;
	
	public Career() {
		students = new ArrayList<>();
		teachers = new ArrayList<>();
		courses = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
