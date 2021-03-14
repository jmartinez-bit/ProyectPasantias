package aplicaciones.spring.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.DatoLaboral;
import aplicaciones.spring.models.Idioma;
import aplicaciones.spring.models.dao.IIdiomaDao;

@Service
public class IdiomaServiceImpl implements IIdiomaService {

	@Autowired
	private IIdiomaDao idiomaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Idioma> findAll() {
		// TODO Auto-generated method stub
		return (List<Idioma>) idiomaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Idioma findById(Long id) {
		// TODO Auto-generated method stub
		return idiomaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Idioma save(Idioma idioma) {
		// TODO Auto-generated method stub
		return idiomaDao.save(idioma);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		idiomaDao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Idioma> saveAll(List<Idioma> idiomas) {
		// TODO Auto-generated method stub
		return (List<Idioma>) idiomaDao.saveAll(idiomas);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Idioma> findByDatoLaboralId(DatoLaboral datoLaboral) {
		// TODO Auto-generated method stub
		return idiomaDao.findByDatoLaboralId(datoLaboral);
	}

	@Override
	public boolean existIdioma(List<Idioma> idiomas, Long id) {
		// TODO Auto-generated method stub
		boolean existe = false;
		
		for(int i=0; i<idiomas.size(); i++) {
			Idioma l = idiomas.get(i);
			if(l.getId() != null) {
				if(l.getId().equals(id)) {
					existe = true;
					break;
				}
			}
		}
		
		return existe;
	}

	@Override
	@Transactional
	public List<Idioma> updateIdioma(List<Idioma> idiomaEdit, List<Idioma> idiomaActual,
			DatoLaboral datoLaboralActual) {
		// TODO Auto-generated method stub
		int size = idiomaActual.size();
		
		for(int i=0; i<idiomaEdit.size(); i++) {
			if(i < size) {
				if(idiomaEdit.get(i).getId() != null) {
					if(existIdioma(idiomaActual, idiomaEdit.get(i).getId())) {
						idiomaActual.get(i).setDesc(idiomaEdit.get(i).getDesc());
						idiomaActual.get(i).setNivel(idiomaEdit.get(i).getNivel());
					} else {
						idiomaEdit.get(i).setDatoLaboralId(datoLaboralActual);
						idiomaActual.add(idiomaEdit.get(i));
					}
				} else {
					idiomaEdit.get(i).setDatoLaboralId(datoLaboralActual);
					idiomaActual.add(idiomaEdit.get(i));
				}
			} else {
				idiomaEdit.get(i).setDatoLaboralId(datoLaboralActual);
				idiomaActual.add(idiomaEdit.get(i));
			}
		}
		
		List<Idioma> idiomaDelete = new ArrayList<>();
		for(int i=0; i<idiomaActual.size(); i++) {
			if(idiomaActual.get(i).getId() != null) {
				if(!existIdioma(idiomaEdit, idiomaActual.get(i).getId())) {
					idiomaDelete.add(idiomaActual.get(i));
				}
			}
		}
		
		if(idiomaDelete != null) {
			for(int i=0; i<idiomaDelete.size(); i++) {
				idiomaActual.remove(idiomaDelete.get(i));
			}
		}
		
		deleteAll(idiomaDelete);
		return (List<Idioma>) idiomaDao.saveAll(idiomaActual);
	}

	@Override
	@Transactional
	public void deleteAll(List<Idioma> idiomas) {
		// TODO Auto-generated method stub
		idiomaDao.deleteAll(idiomas);
	}

}
