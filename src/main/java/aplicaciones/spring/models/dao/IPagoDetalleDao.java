package aplicaciones.spring.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.CompraPago;
import aplicaciones.spring.models.PagoDetalle;

public interface IPagoDetalleDao extends CrudRepository<PagoDetalle, Long> {

	public List<PagoDetalle> findByCompraPagoId(CompraPago compraPago);
	
	public void deleteByCompraPagoId(CompraPago compraPago);
	
}
