package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.DatoFamiliar;
import aplicaciones.spring.models.DatoPersonal;
import aplicaciones.spring.models.dao.IDatoFamiliarDao;

@Service
public class DatoFamiliarServiceImpl implements IDatoFamiliarService{

	@Autowired
	private IDatoFamiliarDao datoFamiliarDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<DatoFamiliar> findAll() {
		return (List<DatoFamiliar>) datoFamiliarDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DatoFamiliar findById(Long id) {
		return datoFamiliarDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DatoFamiliar save(DatoFamiliar datoFamiliar) {
		// TODO Auto-generated method stub
		return datoFamiliarDao.save(datoFamiliar);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		datoFamiliarDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public DatoFamiliar findByDatoPersonal(DatoPersonal datoPersonal) {
		// TODO Auto-generated method stub
		return datoFamiliarDao.findByDatoPersonalId(datoPersonal);
	}

}
