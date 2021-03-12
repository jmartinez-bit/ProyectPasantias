package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Hijo;
import aplicaciones.spring.models.dao.IHijoDao;

@Service
public class HijoServiceImpl implements IHijoService {

	@Autowired
	private IHijoDao hijoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Hijo> findAll() {
		// TODO Auto-generated method stub
		return (List<Hijo>) hijoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Hijo findById(Long id) {
		// TODO Auto-generated method stub
		return hijoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Hijo save(Hijo hijo) {
		// TODO Auto-generated method stub
		return hijoDao.save(hijo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		hijoDao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Hijo> saveAll(List<Hijo> hijos) {
		// TODO Auto-generated method stub
		return (List<Hijo>) hijoDao.saveAll(hijos);
	}

}
