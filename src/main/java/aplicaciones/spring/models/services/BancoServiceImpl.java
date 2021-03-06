package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Banco;
import aplicaciones.spring.models.dao.IBancoDao;

@Service
public class BancoServiceImpl implements IBancoService{

	@Autowired
	private IBancoDao bancoDao;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Banco> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return bancoDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Banco findById(Long id) {
		// TODO Auto-generated method stub
		return bancoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Banco save(Banco banco) {
		// TODO Auto-generated method stub
		return bancoDao.save(banco);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		bancoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Banco> findAllBancos() {
		// TODO Auto-generated method stub
		return (List<Banco>) bancoDao.findAll();
	}

}
