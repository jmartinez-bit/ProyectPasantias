package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Comprobante;
import aplicaciones.spring.models.dao.IComprobanteDao;

@Service
public class ComprobanteServiceImpl implements IComprobanteService {
	
	@Autowired
	private IComprobanteDao comprobanteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Comprobante> findAll() {
		// TODO Auto-generated method stub
		return (List<Comprobante>) comprobanteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Comprobante findById(Long id) {
		// TODO Auto-generated method stub
		return comprobanteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Comprobante save(Comprobante comprobante) {
		// TODO Auto-generated method stub
		return comprobanteDao.save(comprobante);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		comprobanteDao.deleteById(id);
	}

}
