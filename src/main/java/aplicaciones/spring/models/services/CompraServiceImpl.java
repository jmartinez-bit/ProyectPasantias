package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Compra;
import aplicaciones.spring.models.Proveedor;
import aplicaciones.spring.models.dao.ICompraDao;

@Service
public class CompraServiceImpl implements ICompraService{

	@Autowired
	private ICompraDao compraDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Compra> findAll() {
		// TODO Auto-generated method stub
		return (List<Compra>) compraDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Compra findById(Long id) {
		// TODO Auto-generated method stub
		return compraDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Compra save(Compra compra) {
		// TODO Auto-generated method stub
		return compraDao.save(compra);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		compraDao.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByProveedorId(Proveedor proveedor) {
		// TODO Auto-generated method stub
		compraDao.deleteByProveedorId(proveedor);
	}

}
