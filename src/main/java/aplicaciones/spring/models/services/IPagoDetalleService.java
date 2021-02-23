package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Cliente;
import aplicaciones.spring.models.CompraPago;
import aplicaciones.spring.models.PagoDetalle;

public interface IPagoDetalleService {

	public List<PagoDetalle> findAll();
	
	public PagoDetalle findById(Long id);
	
	public PagoDetalle save(PagoDetalle pagoDetalle);
	
	public void delete(Long id);
	
	public List<PagoDetalle> findByCompraPagoId(CompraPago compraPago);
	
	public List<PagoDetalle> savePagoDetalle(List<PagoDetalle> pagosDetalle);
	
	public boolean existPagoDetalle(List<PagoDetalle> pagosDetalle, Long id);
	
	public void deleteAll(List<PagoDetalle> pagosDetalle);
	
	public List<PagoDetalle> updatePagoDetalle(List<PagoDetalle> pagoDetalleEdit, List<PagoDetalle> pagoDetalleActual, CompraPago compraPagoActual);
	
	public void deleteByCompraPagoId(CompraPago compraPago);
	
}
