package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Pago;
import aplicaciones.spring.models.PersonaContacto;
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

}
