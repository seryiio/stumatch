package pe.edu.upc.stumatch.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.stumatch.business.crud.SectionService;
import pe.edu.upc.stumatch.model.entity.Section;
import pe.edu.upc.stumatch.model.repository.SectionRepository;

@Service
public class SectionServiceImpl implements SectionService{
	
	@Autowired
	private SectionRepository sectionRepository;
	
	@Override
	public JpaRepository<Section, String> getJpaRepository() {
		return this.sectionRepository;
	}
}
