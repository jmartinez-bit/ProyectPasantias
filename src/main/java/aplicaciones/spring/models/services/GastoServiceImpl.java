package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Gasto;
import aplicaciones.spring.models.dao.IGastoDao;

@Service
public class GastoServiceImpl implements IGastoService{

	@Autowired
	private IGastoDao gastoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Gasto> findAll() {
		return (List<Gasto>) gastoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Gasto findById(Long id) {
		return gastoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Gasto save(Gasto gasto) {
		// TODO Auto-generated method stub
		return gastoDao.save(gasto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		gastoDao.deleteById(id);
	}

}
