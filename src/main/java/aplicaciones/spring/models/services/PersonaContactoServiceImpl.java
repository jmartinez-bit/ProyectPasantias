package aplicaciones.spring.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Cliente;
import aplicaciones.spring.models.PersonaContacto;
import aplicaciones.spring.models.Proveedor;
import aplicaciones.spring.models.dao.IPersonaContactoDao;

@Service
public class PersonaContactoServiceImpl implements IPersonaContactoService{

	@Autowired
	private IPersonaContactoDao personaContactoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PersonaContacto> findAll() {
		// TODO Auto-generated method stub
		return (List<PersonaContacto>) personaContactoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public PersonaContacto findById(Long id) {
		// TODO Auto-generated method stub
		return personaContactoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public PersonaContacto save(PersonaContacto personaContacto) {
		// TODO Auto-generated method stub
		return personaContactoDao.save(personaContacto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		personaContactoDao.deleteById(id);
	}

	@Override
	@Transactional
	public List<PersonaContacto> savePersonas(List<PersonaContacto> personas) {
		// TODO Auto-generated method stub
		return (List<PersonaContacto>) personaContactoDao.saveAll(personas);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PersonaContacto> findByClienteId(Cliente cliente) {
		// TODO Auto-generated method stub
		return personaContactoDao.findByClienteId(cliente);
	}

	@Override
	public boolean existPersonaContacto(List<PersonaContacto> personas, Long id) {
		// TODO Auto-generated method stub
		boolean existe = false;
		
		for(int i=0; i<personas.size(); i++) {
			PersonaContacto p = personas.get(i);
			if(p.getId().equals(id)) {
				existe = true;
				break;
			}
		}
		
		return existe;
	}

	@Override
	@Transactional
	public void deleteAll(List<PersonaContacto> personas) {
		// TODO Auto-generated method stub
		personaContactoDao.deleteAll(personas);
	}

	@Override
	@Transactional
	public List<PersonaContacto> updatePersona(List<PersonaContacto> personaContactoEdit,
			List<PersonaContacto> personaContactoActual, Cliente clienteActual) {
		// TODO Auto-generated method stub
		int size = personaContactoActual.size();
		
		for(int i=0; i<personaContactoEdit.size(); i++) {
			if (i < size) {
				if(personaContactoEdit.get(i).getId() != null) {					
					if(existPersonaContacto(personaContactoActual, personaContactoEdit.get(i).getId())) {					
						personaContactoActual.get(i).setCargo(personaContactoEdit.get(i).getCargo());
						personaContactoActual.get(i).setCorreo(personaContactoEdit.get(i).getCorreo());
						personaContactoActual.get(i).setNombre(personaContactoEdit.get(i).getNombre());
						personaContactoActual.get(i).setProveedorId(personaContactoEdit.get(i).getProveedorId());
						personaContactoActual.get(i).setTelefono(personaContactoEdit.get(i).getTelefono());
					} else {
						personaContactoEdit.get(i).setClienteId(clienteActual);
						personaContactoActual.add(personaContactoEdit.get(i));
					}
				}else {
					personaContactoEdit.get(i).setClienteId(clienteActual);
					personaContactoActual.add(personaContactoEdit.get(i));
				}
			}else {
				personaContactoEdit.get(i).setClienteId(clienteActual);
				personaContactoActual.add(personaContactoEdit.get(i));
			}
		}
		
		List<PersonaContacto> personaContactoDelete = new ArrayList<>();
		for(int i=0; i<personaContactoActual.size(); i++) {				
			if(personaContactoActual.get(i).getId() != null) {				
				if(!existPersonaContacto(personaContactoEdit, personaContactoActual.get(i).getId())) {
					personaContactoDelete.add(personaContactoActual.get(i));
				}
			}
		}
		
		if(personaContactoDelete != null) {			
			for(int i=0; i<personaContactoDelete.size(); i++) {
				personaContactoActual.remove(personaContactoDelete.get(i));
			}
		}
		
		deleteAll(personaContactoDelete);
		return (List<PersonaContacto>) personaContactoDao.saveAll(personaContactoActual);
	}

	@Override
	@Transactional
	public void deleteByClienteId(Cliente cliente) {
		// TODO Auto-generated method stub
		personaContactoDao.deleteByClienteId(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PersonaContacto> findByProveedorId(Proveedor proveedorId) {
		// TODO Auto-generated method stub
		return personaContactoDao.findByProveedorId(proveedorId);
	}

	@Override
	@Transactional
	public List<PersonaContacto> updatePersona(List<PersonaContacto> personaContactoEdit,
			List<PersonaContacto> personaContactoActual, Proveedor proveedorActual) {
		// TODO Auto-generated method stub
		int size = personaContactoActual.size();
		
		for(int i=0; i<personaContactoEdit.size(); i++) {
			if (i < size) {
				if(personaContactoEdit.get(i).getId() != null) {					
					if(existPersonaContacto(personaContactoActual, personaContactoEdit.get(i).getId())) {					
						personaContactoActual.get(i).setCargo(personaContactoEdit.get(i).getCargo());
						personaContactoActual.get(i).setCorreo(personaContactoEdit.get(i).getCorreo());
						personaContactoActual.get(i).setNombre(personaContactoEdit.get(i).getNombre());
						personaContactoActual.get(i).setProveedorId(personaContactoEdit.get(i).getProveedorId());
						personaContactoActual.get(i).setTelefono(personaContactoEdit.get(i).getTelefono());
					} else {
						personaContactoEdit.get(i).setProveedorId(proveedorActual);
						personaContactoActual.add(personaContactoEdit.get(i));
					}
				}else {
					personaContactoEdit.get(i).setProveedorId(proveedorActual);
					personaContactoActual.add(personaContactoEdit.get(i));
				}
			}else {
				personaContactoEdit.get(i).setProveedorId(proveedorActual);
				personaContactoActual.add(personaContactoEdit.get(i));
			}
		}
		
		List<PersonaContacto> personaContactoDelete = new ArrayList<>();
		for(int i=0; i<personaContactoActual.size(); i++) {				
			if(personaContactoActual.get(i).getId() != null) {				
				if(!existPersonaContacto(personaContactoEdit, personaContactoActual.get(i).getId())) {
					personaContactoDelete.add(personaContactoActual.get(i));
				}
			}
		}
		
		if(personaContactoDelete != null) {			
			for(int i=0; i<personaContactoDelete.size(); i++) {
				personaContactoActual.remove(personaContactoDelete.get(i));
			}
		}
		
		deleteAll(personaContactoDelete);
		return (List<PersonaContacto>) personaContactoDao.saveAll(personaContactoActual);
	}

	@Override
	@Transactional
	public void deleteByProveedorId(Proveedor proveedor) {
		// TODO Auto-generated method stub
		personaContactoDao.deleteByProveedorId(proveedor);
	}

}
