package pe.edu.upc.stumatch.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Bean
	PasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}
	
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEnconder());		
		
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		// Aqui realiza la configuracion de los permisos
				.antMatchers("/students").hasRole("ADMINISTRATOR")
				.antMatchers("/teachers").hasRole("ADMINISTRATOR")
				.antMatchers("/careers").hasRole("ADMINISTRATOR")
				.antMatchers("/sections").hasRole("ADMINISTRATOR")
				.antMatchers("/courses").hasRole("ADMINISTRATOR")
				
				.antMatchers("/students/new").hasRole("ADMINISTRATOR")
				.antMatchers("/teachers/new").hasRole("ADMINISTRATOR")
				.antMatchers("/careers/new").hasRole("ADMINISTRATOR")
				.antMatchers("/sections/new").hasRole("ADMINISTRATOR")
				.antMatchers("/courses/new").hasRole("ADMINISTRATOR")
				
				.antMatchers("/students/**/edit").hasRole("ADMINISTRATOR")
				.antMatchers("/teachers/**/edit").hasRole("ADMINISTRATOR")
				.antMatchers("/careers/**/edit").hasRole("ADMINISTRATOR")
				.antMatchers("/sections/**/edit").hasRole("ADMINISTRATOR")
				.antMatchers("/courses/**/edit").hasRole("ADMINISTRATOR")
				

				.antMatchers("/enrollments/report").hasRole("ADMINISTRATOR")
				
				.antMatchers("/enrollments").hasRole("STUDENT")
				
				.antMatchers("/main").permitAll()
				.and()
					.formLogin().loginPage("/login").permitAll().and().logout().permitAll().and()
					.exceptionHandling().accessDeniedPage("/error");
	}
	
	
}