package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.TipoGasto;
import aplicaciones.spring.models.dao.ITipoGastoDao;

@Service
public class TipoGastoServiceImpl implements ITipoGastoService{

	@Autowired
	private ITipoGastoDao tipoGastoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoGasto> findAll() {
		return (List<TipoGasto>) tipoGastoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TipoGasto findById(Long id) {
		// TODO Auto-generated method stub
		return tipoGastoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public TipoGasto save(TipoGasto tipoGasto) {
		// TODO Auto-generated method stub
		return tipoGastoDao.save(tipoGasto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		tipoGastoDao.deleteById(id);
	}

}
