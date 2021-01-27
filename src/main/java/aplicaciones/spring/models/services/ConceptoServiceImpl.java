package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Concepto;
import aplicaciones.spring.models.dao.IConceptoDao;

@Service
public class ConceptoServiceImpl implements IConceptoService{

	@Autowired
	private IConceptoDao conceptoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Concepto> findAll() {
		return (List<Concepto>)conceptoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Concepto findById(Long id) {
		return conceptoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Concepto save(Concepto concepto) {
		// TODO Auto-generated method stub
		return conceptoDao.save(concepto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		conceptoDao.deleteById(id);
	}

}
