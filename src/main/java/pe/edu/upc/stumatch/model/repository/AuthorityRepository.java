package pe.edu.upc.stumatch.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.stumatch.model.entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}