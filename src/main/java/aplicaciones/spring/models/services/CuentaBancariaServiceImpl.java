package aplicaciones.spring.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.CuentaBancaria;
import aplicaciones.spring.models.PersonaContacto;
import aplicaciones.spring.models.Proveedor;
import aplicaciones.spring.models.dao.ICuentaBancariaDao;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaDao cuentaBancariaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<CuentaBancaria> findAll() {
		// TODO Auto-generated method stub
		return (List<CuentaBancaria>) cuentaBancariaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public CuentaBancaria findById(Long id) {
		// TODO Auto-generated method stub
		return cuentaBancariaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CuentaBancaria save(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		return cuentaBancariaDao.save(cuentaBancaria);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cuentaBancariaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CuentaBancaria> findByProveedorId(Proveedor proveedorId) {
		// TODO Auto-generated method stub
		return cuentaBancariaDao.findByProveedorId(proveedorId);
	}

	@Override
	@Transactional
	public List<CuentaBancaria> saveCuentas(List<CuentaBancaria> cuentas) {
		// TODO Auto-generated method stub
		return (List<CuentaBancaria>) cuentaBancariaDao.saveAll(cuentas);
	}

	@Override
	@Transactional
	public List<CuentaBancaria> updateCuenta(List<CuentaBancaria> cuentaBancariaEdit,
			List<CuentaBancaria> cuentaBancariaActual, Proveedor proveedorActual) {
		// TODO Auto-generated method stub
		int size = cuentaBancariaActual.size();
		
		for(int i=0; i<cuentaBancariaEdit.size(); i++) {
			if(i < size) {
				if(cuentaBancariaEdit.get(i).getId() != null) {
					if(existCuentaBancaria(cuentaBancariaActual, cuentaBancariaEdit.get(i).getId())) {
						cuentaBancariaActual.get(i).setCci(cuentaBancariaEdit.get(i).getCci());
						cuentaBancariaActual.get(i).setEntidad(cuentaBancariaEdit.get(i).getEntidad());
						cuentaBancariaActual.get(i).setMoneda(cuentaBancariaEdit.get(i).getMoneda());
						cuentaBancariaActual.get(i).setNumCuenta(cuentaBancariaEdit.get(i).getNumCuenta());
						cuentaBancariaActual.get(i).setTipoCuenta(cuentaBancariaEdit.get(i).getTipoCuenta());
					} else {
						cuentaBancariaEdit.get(i).setProveedorId(proveedorActual);
						cuentaBancariaActual.add(cuentaBancariaEdit.get(i));
					}
				} else {
					cuentaBancariaEdit.get(i).setProveedorId(proveedorActual);
					cuentaBancariaActual.add(cuentaBancariaEdit.get(i));
				}
			}else {
				cuentaBancariaEdit.get(i).setProveedorId(proveedorActual);
				cuentaBancariaActual.add(cuentaBancariaEdit.get(i));
			}
		}
		
		List<CuentaBancaria> cuentaBancariaDelete = new ArrayList<>();
		for(int i=0; i<cuentaBancariaActual.size(); i++) {
			if(cuentaBancariaActual.get(i).getId() != null) {
				if(!existCuentaBancaria(cuentaBancariaEdit, cuentaBancariaActual.get(i).getId())) {
					cuentaBancariaDelete.add(cuentaBancariaActual.get(i));
				}
			}
		}
		
		if(cuentaBancariaDelete != null) {
			for(int i=0; i<cuentaBancariaDelete.size(); i++) {
				cuentaBancariaActual.remove(cuentaBancariaDelete.get(i));
			}
		}
		
		deleteAll(cuentaBancariaDelete);
		return (List<CuentaBancaria>) cuentaBancariaDao.saveAll(cuentaBancariaActual);
	}

	@Override
	public boolean existCuentaBancaria(List<CuentaBancaria> cuentas, Long id) {
		// TODO Auto-generated method stub
		boolean existe = false;
		
		for(int i=0; i<cuentas.size(); i++) {
			CuentaBancaria c = cuentas.get(i);
			if(c.getId().equals(id)) {
				existe = true;
				break;
			}
		}
		
		return existe;
	}

	@Override
	@Transactional
	public void deleteAll(List<CuentaBancaria> cuentas) {
		// TODO Auto-generated method stub
		cuentaBancariaDao.deleteAll(cuentas);
	}

	@Override
	@Transactional
	public void deleteByProveedorId(Proveedor proveedor) {
		// TODO Auto-generated method stub
		cuentaBancariaDao.deleteByProveedorId(proveedor);
	}

}
