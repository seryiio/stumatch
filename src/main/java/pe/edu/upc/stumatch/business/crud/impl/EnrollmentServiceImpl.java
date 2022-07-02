package pe.edu.upc.stumatch.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.stumatch.model.repository.EnrollmentRepository;
import pe.edu.upc.stumatch.business.crud.EnrollmentService;
import pe.edu.upc.stumatch.model.entity.Enrollment;
import pe.edu.upc.stumatch.model.entity.Section;
import pe.edu.upc.stumatch.model.entity.Student;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Override
	public JpaRepository<Enrollment, Integer> getJpaRepository() {
		return this.enrollmentRepository;
	}

	@Override
	public List<String[]> Reporte1() {
		return this.enrollmentRepository.Reporte1();
	}

	@Override
	public Integer insert(Enrollment enrollment) {
		/*
		 * int rpta =
		 * enrollmentRepository.BuscarCurso(enrollment.getSection().getCourse().getId(),
		 * enrollment.getStudent().getId()); if (rpta == 0) {
		 * enrollmentRepository.save(enrollment); } return rpta;
		 */

		int CursosRepetidos = 0;
		int Vacantesdisponibles = 0;
		int CreditosDisponibles = 0;
		CursosRepetidos = this.enrollmentRepository.BuscarCurso(enrollment.getSection().getCourse().getId(),
				enrollment.getStudent().getId());
		Vacantesdisponibles = this.enrollmentRepository.BuscarVacantes(enrollment.getSection().getId());
		CreditosDisponibles = this.enrollmentRepository.BuscarCreditos(enrollment.getStudent().getId());

		if (CursosRepetidos < 1 && Vacantesdisponibles > 0 && CreditosDisponibles - enrollment.getSection().getCourse().getNumberCredits() >= 0) {
			enrollmentRepository.save(enrollment);
		}
		for (int i = 0; i < 20; i++) {
			System.out.println(enrollment.getSection().getCourse().getId());
			System.out.println(enrollment.getStudent().getId());
			System.out.println(CursosRepetidos);
			System.out.println(Vacantesdisponibles);
			System.out.println(CreditosDisponibles);
		}
		return CursosRepetidos;

	}

	@Override
	public void NewVacancies(Section section, Enrollment enrollment) {
	}

	@Override
	public void UpdateCredit(Student student, Enrollment enrollment) {
	}

	@Override
	public Integer verifyVacancies(Enrollment enrollment) {
		int rpta2 = 0;
		rpta2 = this.enrollmentRepository.BuscarVacantes(enrollment.getSection().getId());
		return rpta2;
	}

	@Override
	public Integer veriflyCredits(Enrollment enrollment) {
		int rpta3 = 0;
		rpta3 = this.enrollmentRepository.BuscarCreditos(enrollment.getStudent().getId());
		return rpta3 - enrollment.getSection().getCourse().getNumberCredits();
	}

	@Override
    public void Restaurar(Integer IDenrollment) {
        enrollmentRepository.Restaurarcreditos(IDenrollment);
        enrollmentRepository.RestaurarVacantes(IDenrollment);

    }

}
