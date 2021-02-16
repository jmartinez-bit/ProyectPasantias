package aplicaciones.spring.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Cliente;
import aplicaciones.spring.models.Direccion;
import aplicaciones.spring.models.dao.IDireccionDao;

@Service
public class DireccionServiceImpl implements IDireccionService{
	
	@Autowired
	private IDireccionDao direccionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Direccion> findAll() {
		// TODO Auto-generated method stub
		return (List<Direccion>) direccionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Direccion findById(Long id) {
		// TODO Auto-generated method stub
		return direccionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Direccion save(Direccion direccion) {
		// TODO Auto-generated method stub
		return direccionDao.save(direccion);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		direccionDao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Direccion> saveDireccion(List<Direccion> direcciones) {
		// TODO Auto-generated method stub
		return (List<Direccion>) direccionDao.saveAll(direcciones);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Direccion> findByClienteId(Cliente clienteId) {
		// TODO Auto-generated method stub
		return direccionDao.findByClienteId(clienteId);
	}

	@Override
	public boolean existDireccion(List<Direccion> direcciones, Long id) {
		// TODO Auto-generated method stub
		boolean existe = false;
		
		for(int i=0; i<direcciones.size(); i++) {
			Direccion d = direcciones.get(i);
			if(d.getId().equals(id)) {
				existe = true;
				break;
			}
		}
		
		return existe;
	}

	@Override
	@Transactional
	public void deleteAll(List<Direccion> direcciones) {
		// TODO Auto-generated method stub
		direccionDao.deleteAll(direcciones);
	}

	@Override
	@Transactional
	public List<Direccion> updateDireccion(List<Direccion> direccionEdit, List<Direccion> direccionActual, Cliente clienteActual) {
		// TODO Auto-generated method stub
		int size = direccionActual.size();
		
		for(int i=0; i<direccionEdit.size(); i++) {
			if (i < size) {
				if(direccionEdit.get(i).getId() != null) {					
					if(existDireccion(direccionActual, direccionEdit.get(i).getId())) {					
						direccionActual.get(i).setDepartamento(direccionEdit.get(i).getDepartamento());
						direccionActual.get(i).setDistrito(direccionEdit.get(i).getDistrito());
						direccionActual.get(i).setPais(direccionEdit.get(i).getPais());
						direccionActual.get(i).setProvincia(direccionEdit.get(i).getProvincia());
						direccionActual.get(i).setUbigeo(direccionEdit.get(i).getUbigeo());
					} else {
						direccionEdit.get(i).setClienteId(clienteActual);
						direccionActual.add(direccionEdit.get(i));
					}
				}else {
					direccionEdit.get(i).setClienteId(clienteActual);
					direccionActual.add(direccionEdit.get(i));
				}
			}else {
				direccionEdit.get(i).setClienteId(clienteActual);
				direccionActual.add(direccionEdit.get(i));
			}
		}
		
		List<Direccion> direccionDelete = new ArrayList<>();
		for(int i=0; i<direccionActual.size(); i++) {				
			if(direccionActual.get(i).getId() != null) {				
				if(!existDireccion(direccionEdit, direccionActual.get(i).getId())) {
					direccionDelete.add(direccionActual.get(i));
				}
			}
		}
		
		if(direccionDelete != null) {			
			for(int i=0; i<direccionDelete.size(); i++) {
				direccionActual.remove(direccionDelete.get(i));
			}
		}
		
		deleteAll(direccionDelete);
		return (List<Direccion>) direccionDao.saveAll(direccionActual);
	}

	@Override
	@Transactional
	public void deleteByClienteId(Cliente cliente) {
		// TODO Auto-generated method stub
		direccionDao.deleteByClienteId(cliente);
	}
	
}
