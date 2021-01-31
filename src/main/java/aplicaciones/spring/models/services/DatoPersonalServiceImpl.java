package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.DatoPersonal;
import aplicaciones.spring.models.dao.IDatoPersonalDao;

@Service
public class DatoPersonalServiceImpl implements IDatoPersonalService{

	@Autowired
	private IDatoPersonalDao datoPersonalDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<DatoPersonal> findAll() {
		return (List<DatoPersonal>) datoPersonalDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DatoPersonal findById(Long id) {
		return datoPersonalDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DatoPersonal save(DatoPersonal datoPersonal) {
		// TODO Auto-generated method stub
		return datoPersonalDao.save(datoPersonal);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		datoPersonalDao.deleteById(id);
	}

}
