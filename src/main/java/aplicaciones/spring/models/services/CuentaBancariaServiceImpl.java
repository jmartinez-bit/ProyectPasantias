package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.CuentaBancaria;
import aplicaciones.spring.models.dao.ICuentaBancariaDao;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaDao cuentaBancariaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<CuentaBancaria> findAll() {
		// TODO Auto-generated method stub
		return (List<CuentaBancaria>) cuentaBancariaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public CuentaBancaria findById(Long id) {
		// TODO Auto-generated method stub
		return cuentaBancariaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CuentaBancaria save(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		return cuentaBancariaDao.save(cuentaBancaria);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cuentaBancariaDao.deleteById(id);
	}

}
