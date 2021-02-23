package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.CompraPago;
import aplicaciones.spring.models.dao.ICompraPagoDao;

@Service
public class CompraPagoServiceImpl implements ICompraPagoService {

	@Autowired
	private ICompraPagoDao compraPagoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<CompraPago> findAll() {
		// TODO Auto-generated method stub
		return (List<CompraPago>) compraPagoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public CompraPago findById(Long id) {
		// TODO Auto-generated method stub
		return compraPagoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CompraPago save(CompraPago compraPago) {
		// TODO Auto-generated method stub
		return compraPagoDao.save(compraPago);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		compraPagoDao.deleteById(id);
	}

}
