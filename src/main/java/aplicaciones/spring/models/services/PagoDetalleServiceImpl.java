package aplicaciones.spring.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.CompraPago;
import aplicaciones.spring.models.PagoDetalle;
import aplicaciones.spring.models.dao.IPagoDetalleDao;

@Service
public class PagoDetalleServiceImpl implements IPagoDetalleService {

	@Autowired
	private IPagoDetalleDao pagoDetalleDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PagoDetalle> findAll() {
		// TODO Auto-generated method stub
		return (List<PagoDetalle>) pagoDetalleDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public PagoDetalle findById(Long id) {
		// TODO Auto-generated method stub
		return pagoDetalleDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public PagoDetalle save(PagoDetalle pagoDetalle) {
		// TODO Auto-generated method stub
		return pagoDetalleDao.save(pagoDetalle);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pagoDetalleDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PagoDetalle> findByCompraPagoId(CompraPago compraPago) {
		// TODO Auto-generated method stub
		return pagoDetalleDao.findByCompraPagoId(compraPago);
	}

	@Override
	@Transactional
	public List<PagoDetalle> savePagoDetalle(List<PagoDetalle> pagosDetalle) {
		// TODO Auto-generated method stub
		return (List<PagoDetalle>) pagoDetalleDao.saveAll(pagosDetalle);
	}

	@Override
	public boolean existPagoDetalle(List<PagoDetalle> pagosDetalle, Long id) {
		// TODO Auto-generated method stub
		boolean existe = false;
		
		for(int i=0; i<pagosDetalle.size(); i++) {
			PagoDetalle p = pagosDetalle.get(i);
			if(p.getId().equals(id)) {
				existe = true;
				break;
			}
		}
		
		return existe;
	}

	@Override
	@Transactional
	public void deleteAll(List<PagoDetalle> pagosDetalle) {
		// TODO Auto-generated method stub
		pagoDetalleDao.deleteAll();
	}

	@Override
	@Transactional
	public List<PagoDetalle> updatePagoDetalle(List<PagoDetalle> pagoDetalleEdit, List<PagoDetalle> pagoDetalleActual,
			CompraPago compraPagoActual) {
		// TODO Auto-generated method stub
		int size = pagoDetalleActual.size();

		for(int i=0; i<pagoDetalleEdit.size(); i++) {
			if (i < size) {
				if(pagoDetalleEdit.get(i).getId() != null) {					
					if(existPagoDetalle(pagoDetalleActual, pagoDetalleEdit.get(i).getId())) {	
						pagoDetalleActual.get(i).setBanco(pagoDetalleEdit.get(i).getBanco());
						pagoDetalleActual.get(i).setFechaPago(pagoDetalleEdit.get(i).getFechaPago());
						pagoDetalleActual.get(i).setMonedaPago(pagoDetalleEdit.get(i).getMonedaPago());
						pagoDetalleActual.get(i).setMontoPagado(pagoDetalleEdit.get(i).getMontoPagado());
						pagoDetalleActual.get(i).setNumOperacion(pagoDetalleEdit.get(i).getNumOperacion());
						pagoDetalleActual.get(i).setTipoCambio(pagoDetalleEdit.get(i).getTipoCambio());
						pagoDetalleActual.get(i).setTipoPago(pagoDetalleEdit.get(i).getTipoPago());
					} else {
						pagoDetalleEdit.get(i).setCompraPagoId(compraPagoActual);
						pagoDetalleActual.add(pagoDetalleEdit.get(i));
					}
				}else {
					pagoDetalleEdit.get(i).setCompraPagoId(compraPagoActual);
					pagoDetalleActual.add(pagoDetalleEdit.get(i));
				}
			}else {
				pagoDetalleEdit.get(i).setCompraPagoId(compraPagoActual);
				pagoDetalleActual.add(pagoDetalleEdit.get(i));
			}
		}
		
		List<PagoDetalle> pagoDetalleDelete = new ArrayList<>();
		for(int i=0; i<pagoDetalleActual.size(); i++) {				
			if(pagoDetalleActual.get(i).getId() != null) {				
				if(!existPagoDetalle(pagoDetalleEdit, pagoDetalleActual.get(i).getId())) {
					pagoDetalleDelete.add(pagoDetalleActual.get(i));
				}
			}
		}
		
		if(pagoDetalleDelete != null) {			
			for(int i=0; i<pagoDetalleDelete.size(); i++) {
				pagoDetalleActual.remove(pagoDetalleDelete.get(i));
			}
		}
		
		deleteAll(pagoDetalleDelete);
		return (List<PagoDetalle>) pagoDetalleDao.saveAll(pagoDetalleActual);
	}

	@Override
	@Transactional
	public void deleteByCompraPagoId(CompraPago compraPago) {
		// TODO Auto-generated method stub
		pagoDetalleDao.deleteByCompraPagoId(compraPago);
	}

}
