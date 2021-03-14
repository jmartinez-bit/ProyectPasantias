package aplicaciones.spring.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.DatoFamiliar;
import aplicaciones.spring.models.Hijo;
import aplicaciones.spring.models.dao.IHijoDao;

@Service
public class HijoServiceImpl implements IHijoService {

	@Autowired
	private IHijoDao hijoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Hijo> findAll() {
		// TODO Auto-generated method stub
		return (List<Hijo>) hijoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Hijo findById(Long id) {
		// TODO Auto-generated method stub
		return hijoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Hijo save(Hijo hijo) {
		// TODO Auto-generated method stub
		return hijoDao.save(hijo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		hijoDao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Hijo> saveAll(List<Hijo> hijos) {
		// TODO Auto-generated method stub
		return (List<Hijo>) hijoDao.saveAll(hijos);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Hijo> findByDatoFamiliarId(DatoFamiliar datoFamiliar) {
		// TODO Auto-generated method stub
		return hijoDao.findByDatoFamiliarId(datoFamiliar);
	}

	@Override
	public boolean existHijo(List<Hijo> hijos, Long id) {
		// TODO Auto-generated method stub
		boolean existe = false;
		
		for(int i=0; i<hijos.size(); i++) {
			Hijo h = hijos.get(i);
			if(h.getId() != null) {
				if(h.getId().equals(id)) {
					existe = true;
					break;
				}
			}
		}
		
		return existe;
	}

	@Override
	@Transactional
	public List<Hijo> updateHijo(List<Hijo> hijoEdit, List<Hijo> hijoActual, DatoFamiliar datoFamiliarActual) {
		// TODO Auto-generated method stub
		int size = hijoActual.size();
		
		for(int i=0; i<hijoEdit.size(); i++) {
			if(i < size) {
				if(hijoEdit.get(i).getId() != null) {
					if(existHijo(hijoActual, hijoEdit.get(i).getId())) {
						hijoActual.get(i).setDni(hijoEdit.get(i).getDni());
						hijoActual.get(i).setFechaNac(hijoEdit.get(i).getFechaNac());
						hijoActual.get(i).setNomApe(hijoEdit.get(i).getNomApe());
					} else {
						hijoEdit.get(i).setDatoFamiliarId(datoFamiliarActual);
						hijoActual.add(hijoEdit.get(i));
					}
				} else {
					hijoEdit.get(i).setDatoFamiliarId(datoFamiliarActual);
					hijoActual.add(hijoEdit.get(i));
				}
			} else {
				hijoEdit.get(i).setDatoFamiliarId(datoFamiliarActual);
				hijoActual.add(hijoEdit.get(i));
			}
		}
		
		List<Hijo> hijoDelete = new ArrayList<>();
		for(int i=0; i<hijoActual.size(); i++) {
			if(hijoActual.get(i).getId() != null) {
				if(!existHijo(hijoEdit, hijoActual.get(i).getId())) {
					hijoDelete.add(hijoActual.get(i));
				}
			}
		}
		
		if(hijoDelete != null) {
			for(int i=0; i<hijoDelete.size(); i++) {
				hijoActual.remove(hijoDelete.get(i));
			}
		}
		
		deleteAll(hijoDelete);
		return (List<Hijo>) hijoDao.saveAll(hijoActual);
	}

	@Override
	@Transactional
	public void deleteAll(List<Hijo> hijos) {
		// TODO Auto-generated method stub
		hijoDao.deleteAll(hijos);
	}

}
