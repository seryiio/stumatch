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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "students", 
	indexes = {@Index(columnList = "last_name, first_name", name = "students_index_last_name_first_name")})
public class Student {
	@Id
	@NotEmpty(message = "Debe ingresar un ID")
	@Size(min = 1,max = 12, message = "El valor debe estar entre 1 y 12 caracteres")
	@Column(name = "student_id", length = 12, nullable = false)
	private String id;

	@Size(min = 1,max = 50, message = "El valor debe estar entre 1 y 50 caracteres")
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	@Size(min = 1,max = 50, message = "El valor debe estar entre 1 y 50 caracteres")
	@Column(name = "first_name", length = 50, nullable = false)	
	private String firstName;

	@Min(value = 1, message = "El valor debe ser mayor a 1")
	@Max(value = 90, message = "El valor debe menor a 90")
	@Column(name = "age")
	private Integer age;

	@Min(value = 10000000, message = "El valor debe tener 8 digitos")
	@Max(value = 99999999, message = "El valor debe tener 8 digitos")
	@Column(name = "dni")	
	private Integer dni;
	
	@Min(value = 1, message = "El valor debe ser mayor a 1")
	@Max(value = 10, message = "El valor debe menor a 10")
	@Column(name = "cycle")
	private Integer cycle;
	
	@Min(value = 100000000, message = "El valor debe tener 9 digitos")
	@Max(value = 999999999, message = "El valor debe tener 9 digitos")
	@Column(name = "phone_number")
	private Integer phoneNumber;

	@Size(min = 1,max = 70, message = "El valor debe estar entre 1 y 70 caracteres")
	@Column(name = "email_university", length = 70)	
	private String emailUniversity;

	@Size(min = 1,max = 70, message = "El valor debe estar entre 1 y 70 caracteres")
	@Column(name = "email_personal", length = 70)	
	private String emailPersonal;

	@Min(value = 1, message = "El valor debe ser mayor a 1")
	@Max(value = 28, message = "El valor debe menor a 28")
	@Column(name = "credit_amount")	
	private Integer creditAmount;
	
	@OneToMany(mappedBy = "student")
	private List<Enrollment> enrollments;
	
	@OneToMany(mappedBy = "student")
	private List<Payment> payments;
	
	@ManyToOne
	@JoinColumn(name = "career_id")
	private  Career career;
	
	public Student() {
		payments = new ArrayList<>();
		enrollments = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Integer creditAmount) {
		this.creditAmount = creditAmount;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getCycle() {
		return cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailUniversity() {
		return emailUniversity;
	}

	public void setEmailUniversity(String emailUniversity) {
		this.emailUniversity = emailUniversity;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}
	
	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
}
