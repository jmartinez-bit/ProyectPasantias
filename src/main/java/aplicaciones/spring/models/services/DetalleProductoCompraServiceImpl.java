package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.DetalleProductoCompra;
import aplicaciones.spring.models.ProductoCompra;
import aplicaciones.spring.models.dao.IDetalleProductoCompraDao;

@Service
public class DetalleProductoCompraServiceImpl implements IDetalleProductoCompraService{

	@Autowired
	private IDetalleProductoCompraDao detalleProductoCompraDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<DetalleProductoCompra> findAll() {
		// TODO Auto-generated method stub
		return (List<DetalleProductoCompra>) detalleProductoCompraDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DetalleProductoCompra findById(Long id) {
		// TODO Auto-generated method stub
		return detalleProductoCompraDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public DetalleProductoCompra save(DetalleProductoCompra detalleProductoCompra) {
		// TODO Auto-generated method stub
		return detalleProductoCompraDao.save(detalleProductoCompra);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		detalleProductoCompraDao.deleteById(id);
	}

	@Override
	@Transactional
	public List<DetalleProductoCompra> saveDetalleCompra(List<DetalleProductoCompra> detalleProductoCompra) {
		// TODO Auto-generated method stub
		return (List<DetalleProductoCompra>) detalleProductoCompraDao.saveAll(detalleProductoCompra);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleProductoCompra> findByProductoCompra(ProductoCompra productoCompra) {
		// TODO Auto-generated method stub
		return detalleProductoCompraDao.findByProductoCompraId(productoCompra);
	}

	@Override
	@Transactional
	public List<DetalleProductoCompra> updateDetalleCompra(List<DetalleProductoCompra> detalleEdit,
			List<DetalleProductoCompra> detalleActual) {
		// TODO Auto-generated method stub
		for(int i=0; i<detalleEdit.size(); i++) {
			detalleActual.get(i).setCantIng(detalleEdit.get(i).getCantIng());
			detalleActual.get(i).setCodInt(detalleEdit.get(i).getCodInt());
			detalleActual.get(i).setFamilia(detalleEdit.get(i).getFamilia());
			detalleActual.get(i).setGuiaRemision(detalleEdit.get(i).getGuiaRemision());
			detalleActual.get(i).setMarca(detalleEdit.get(i).getMarca());
			detalleActual.get(i).setModelo(detalleEdit.get(i).getModelo());
			detalleActual.get(i).setSerie(detalleEdit.get(i).getSerie());
			detalleActual.get(i).setSubFamilia(detalleEdit.get(i).getSubFamilia());
			detalleActual.get(i).setTipo(detalleEdit.get(i).getTipo());
		}
		
		return (List<DetalleProductoCompra>) detalleProductoCompraDao.saveAll(detalleActual);
	}

}
