package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.DatoLaboral;
import aplicaciones.spring.models.DatoPersonal;
import aplicaciones.spring.models.dao.IDatoLaboralDao;

@Service
public class DatoLaboralServiceImpl implements IDatoLaboralService{

	@Autowired
	private IDatoLaboralDao datoLaboralDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<DatoLaboral> findAll() {
		return (List<DatoLaboral>) datoLaboralDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DatoLaboral findById(Long id) {
		return datoLaboralDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DatoLaboral save(DatoLaboral datoLaboral) {
		// TODO Auto-generated method stub
		return datoLaboralDao.save(datoLaboral);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		datoLaboralDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public DatoLaboral findByDatoPersonal(DatoPersonal datoPersonal) {
		// TODO Auto-generated method stub
		return datoLaboralDao.findByDatoPersonalId(datoPersonal);
	}

}
