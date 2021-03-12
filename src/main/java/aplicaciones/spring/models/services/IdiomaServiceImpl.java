package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Idioma;
import aplicaciones.spring.models.dao.IIdiomaDao;

@Service
public class IdiomaServiceImpl implements IIdiomaService {

	@Autowired
	private IIdiomaDao idiomaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Idioma> findAll() {
		// TODO Auto-generated method stub
		return (List<Idioma>) idiomaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Idioma findById(Long id) {
		// TODO Auto-generated method stub
		return idiomaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Idioma save(Idioma idioma) {
		// TODO Auto-generated method stub
		return idiomaDao.save(idioma);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		idiomaDao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Idioma> saveAll(List<Idioma> idiomas) {
		// TODO Auto-generated method stub
		return (List<Idioma>) idiomaDao.saveAll(idiomas);
	}

}
