package pe.edu.upc.stumatch.business.crud;

import java.util.List;

import pe.edu.upc.stumatch.model.entity.Authority;

public interface AuthorityService /*extends CrudService<Authority, Long> */{
	
	public void insert(Authority authority);

	List<Authority> list();

}
