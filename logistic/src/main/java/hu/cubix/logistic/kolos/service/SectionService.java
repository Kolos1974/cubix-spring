package hu.cubix.logistic.kolos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.logistic.kolos.model.Section;
import hu.cubix.logistic.kolos.repository.SectionRepository;
import jakarta.transaction.Transactional;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;
	
	@Transactional
	public Section create(Section section)
	{
		return save(section);
	}

	@Transactional
	public Section save(Section section) {

		return sectionRepository.save(section);
	}

	
	public List<Section> findAll() {
		return sectionRepository.findAll();
	}

	
}
