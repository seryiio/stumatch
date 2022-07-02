package pe.edu.upc.stumatch.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teachers", indexes = {@Index(columnList = "last_name, first_name", name = "teachers_index_last_name_first_name")})
public class Teacher {
	@Id
	@NotEmpty(message = "Debe ingresar un ID")
	@Size(min = 1,max = 12	, message = "El valor debe estar entre 1 y 12 caracteres")
	@Column(name = "teacher_id")
	private String id;
	
	@NotEmpty(message = "Debe ingresar un Apellido")
	@Size(min = 1,max = 50	, message = "El valor debe estar entre 1 y 50 caracteres")
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty(message = "Debe ingresar un Nombre")
	@Size(min = 1,max = 50	, message = "El valor debe estar entre 1 y 50 caracteres")
	@Column(name = "first_name")	
	private String firstName;

	@Min(value = 1, message = "El valor debe ser mayor a 1")
	@Max(value = 90, message = "El valor debe ser menor a 90")
	@Column(name = "age")
	private int age;

	@Min(value = 10000000, message = "El valor debe tener 8 digitos")
	@Max(value = 99999999, message = "El valor debe tener 8 digitos")
	@Column(name = "dni")	
	private int dni;

	@Min(value = 100000000, message = "El valor debe tener 9 digitos")
	@Max(value = 999999999, message = "El valor debe tener 9 digitos")
	@Column(name = "phone_number")
	private int phoneNumber;

	@Size(min = 1,max = 70, message = "El valor debe estar entre 1 y 70 caracteres")
	@Column(name = "email_university")	
	private String emailUniversity;
	
	@ManyToOne
	@JoinColumn(name = "career_id")
	private  Career career;
	
	@OneToMany(mappedBy = "teacher")
	private List<Section> sections;
	
	public Teacher() {
		sections = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailUniversity() {
		return emailUniversity;
	}

	public void setEmailUniversity(String emailUniversity) {
		this.emailUniversity = emailUniversity;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	
	
}
