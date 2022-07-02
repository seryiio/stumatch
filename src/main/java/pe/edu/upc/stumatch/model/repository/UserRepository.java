package pe.edu.upc.stumatch.model.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.stumatch.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);
	
	@Query("select count(u.username) from User u where u.idSegment =:username")
	public int buscarUsername(@Param("username") String nombre);
	
}