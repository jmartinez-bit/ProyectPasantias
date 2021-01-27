package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Pago;
import aplicaciones.spring.models.dao.IPagoDao;

@Service
public class PagoServiceImpl implements IPagoService{
	
	@Autowired
	private IPagoDao pagoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Pago> findAll() {
		return (List<Pago>) pagoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Pago findById(Long id) {
		// TODO Auto-generated method stub
		return pagoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Pago save(Pago pago) {
		// TODO Auto-generated method stub
		return pagoDao.save(pago);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pagoDao.deleteById(id);
	}

}
