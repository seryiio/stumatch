package pe.edu.upc.stumatch.business.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.stumatch.business.crud.UserService;
import pe.edu.upc.stumatch.model.entity.User;
import pe.edu.upc.stumatch.model.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository uR;

	@Override
	public JpaRepository<User, Integer> getJpaRepository() {
		return this.uR;
	}
	
	@Override
	public Optional<User> findByUsername(String username){
		return this.uR.findByUsername(username);
	}
	
	@Override
	public Integer insert(User user) {
		int rpta = uR.buscarUsername(user.getUsername());
		if (rpta == 0) {
			uR.save(user);
		}
		return rpta;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return uR.findAll();
	}
	
	
}
