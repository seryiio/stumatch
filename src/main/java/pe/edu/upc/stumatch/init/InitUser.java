package pe.edu.upc.stumatch.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.stumatch.model.entity.Segment;
import pe.edu.upc.stumatch.model.entity.User;
import pe.edu.upc.stumatch.model.repository.UserRepository;

@Service
public class InitUser implements CommandLineRunner {

	//@Autowired
	//private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		// ROLE_XXXXX
		// ACCESS_YYYYY

		// SIEMPRE DEBE DE ESTAR COMENTADO
		// SOLO SE DEBE DESBLOQUEAR CUANDO SE CREAN USUARIO
		/*User alvaro = new User();
		alvaro.setUsername("alvaro2022");
		alvaro.setPassword(bcpe.encode("alvaro2022"));
		alvaro.setSegment(Segment.STUDENT);
		alvaro.setIdSegment("U202210232");
		alvaro.addAuthority("ROLE_STUDENT");
		alvaro.addAuthority("ACCESS_VIEW_MATRI");
		alvaro.addAuthority("ACCESS_EDIT_MATRI");
		userRepository.save(alvaro);*/
		
		/*User junior = new User();
		junior.setUsername("U201910528");
		junior.setPassword(bcpe.encode("estudiante"));
		junior.setSegment(Segment.STUDENT);
		junior.setIdSegment("U201910528");
		junior.addAuthority("ROLE_STUDENT");
		junior.addAuthority("ACCESS_VIEW_MATRI");
		junior.addAuthority("ACCESS_EDIT_MATRI");
		userRepository.save(junior);*/
		
		/*User admin = new User("admin", bcpe.encode("admin"), Segment.TEACHER,"1");
		admin.addAuthority("ROLE_ADMINISTRATOR");
		admin.addAuthority("ACCESS_ALL");
		userRepository.save(admin);*/

	}

}
