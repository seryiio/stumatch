package pe.edu.upc.stumatch.model.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sections")
public class Section {
	@Id
	@NotEmpty(message = "Debe ingresar un ID")
	@Size(min = 1,max = 5	, message = "El valor debe estar entre 1 y 5 caracteres")
	@Column(name = "section_id", length = 5)
	private String id;

	@Max(value = 10, message = "El valor debe ser menor a 10")
	@Column(name = "vacancies")
	private int vacancies;

	@NotEmpty(message = "Debe ingresar un la hora de inicio")
	@Column(name = "start_time")
	private String startTime;

	@NotEmpty(message = "Debe ingresar un la hora de fin")
	@Column(name = "end_time")
	private String endTime;

	@NotEmpty(message = "Debe ingresar un dia")
	@Column(name = "days")
	private String day;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	
	@OneToMany(mappedBy = "section")
	private List<Enrollment> enrollment;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVacancies() {
		return vacancies;
	}

	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Enrollment> getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(List<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	
	
}
