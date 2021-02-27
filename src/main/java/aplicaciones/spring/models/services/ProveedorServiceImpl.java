package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Proveedor;
import aplicaciones.spring.models.dao.IProveedorDao;

@Service
public class ProveedorServiceImpl implements IProveedorService{

	@Autowired
	private IProveedorDao proveedorDao;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Proveedor> findAll(Pageable pageable) {
		return proveedorDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Proveedor findById(Long id) {
		// TODO Auto-generated method stub
		return proveedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Proveedor save(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return proveedorDao.save(proveedor);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		proveedorDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Long obtenerIdUltimo() {
		Proveedor proveedor = proveedorDao.findTopByOrderByIdDesc();
		if(proveedor == null) {
			return 0L;
		}
		return proveedor.getId();
	}

	@Override
	@Transactional(readOnly = true)
	public Proveedor findByRucDni(String rucDni) {
		// TODO Auto-generated method stub
		return proveedorDao.findByRucDni(rucDni);
	}

}
