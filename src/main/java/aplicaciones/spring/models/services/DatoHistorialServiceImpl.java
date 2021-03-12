package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.DatoHistorial;
import aplicaciones.spring.models.dao.IDatoHistorialDao;

@Service
public class DatoHistorialServiceImpl implements IDatoHistorialService{

	@Autowired
	private IDatoHistorialDao datoHistorialDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<DatoHistorial> findAll() {
		// TODO Auto-generated method stub
		return (List<DatoHistorial>) datoHistorialDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DatoHistorial findById(Long id) {
		// TODO Auto-generated method stub
		return datoHistorialDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DatoHistorial save(DatoHistorial datoHistorial) {
		// TODO Auto-generated method stub
		return datoHistorialDao.save(datoHistorial);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		datoHistorialDao.deleteById(id);
	}

}
