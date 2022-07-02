package pe.edu.upc.stumatch.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@NotEmpty(message = "Debe ingresar un ID")
	@Size(min = 1,max = 10	, message = "El valor debe estar entre 1 y 10 digitos")
	@Column(name = "course_id", length = 10, nullable = false)
	private String id;

	@Size(min = 1,max = 75, message = "El valor debe estar entre 1 y 75 digitos")
	@Column(name = "name", length = 75, nullable = false)
	private String name;
	
	@Min(value = 1, message = "El valor debe ser mayor a 1")
	@Max(value = 10, message = "El valor debe menor a 10")
	@Column(name = "number_cycle")
	private int numberCycle;

	@Min(value = 1, message = "El valor debe ser mayor a 1")
	@Max(value = 8, message = "El valor debe ser menor a 8")
	@Column(name = "number_credits")
	private int numberCredits;
	
	@OneToMany(mappedBy = "course")
	private List<Section> sections;
	
	@ManyToOne
	@JoinColumn(name = "career_id")
	private Career career;
	
	public Course() {
		sections = new ArrayList<>();
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

	public int getNumberCycle() {
		return numberCycle;
	}

	public void setNumberCycle(int numberCycle) {
		this.numberCycle = numberCycle;
	}

	public int getNumberCredits() {
		return numberCredits;
	}

	public void setNumberCredits(int numberCredits) {
		this.numberCredits = numberCredits;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}
	
	
}
