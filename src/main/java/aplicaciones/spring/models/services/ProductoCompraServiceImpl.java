package aplicaciones.spring.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aplicaciones.spring.models.Compra;
import aplicaciones.spring.models.ProductoCompra;
import aplicaciones.spring.models.dao.IProductoCompraDao;

@Service
public class ProductoCompraServiceImpl implements IProductoCompraService{

	@Autowired
	private IProductoCompraDao productoCompraDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductoCompra> findAll() {
		// TODO Auto-generated method stub
		return (List<ProductoCompra>) productoCompraDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoCompra findById(Long id) {
		// TODO Auto-generated method stub
		return productoCompraDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ProductoCompra save(ProductoCompra productoCompra) {
		// TODO Auto-generated method stub
		return productoCompraDao.save(productoCompra);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productoCompraDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductoCompra> findByCompraId(Compra compra) {
		// TODO Auto-generated method stub
		return productoCompraDao.findByCompraId(compra);
	}

	@Override
	@Transactional
	public List<ProductoCompra> saveProductos(List<ProductoCompra> productos) {
		// TODO Auto-generated method stub
		return (List<ProductoCompra>) productoCompraDao.saveAll(productos);
	}

	@Override
	public boolean existProductoCompra(List<ProductoCompra> productos, Long id) {
		// TODO Auto-generated method stub
		boolean existe = false;
		
		for(int i=0; i<productos.size(); i++) {
			ProductoCompra p = productos.get(i);
			if(p.getId().equals(id)) {
				existe = true;
				break;
			}
		}
		
		return existe;
	}

	@Override
	@Transactional
	public List<ProductoCompra> updateProductoCompra(List<ProductoCompra> productoCompraEdit,
			List<ProductoCompra> productoCompraActual, Compra compraActual) {
		// TODO Auto-generated method stub
		int size = productoCompraActual.size();
		
		for(int i=0; i<productoCompraEdit.size(); i++) {
			if (i < size) {
				if(productoCompraEdit.get(i).getId() != null) {					
					if(existProductoCompra(productoCompraActual, productoCompraEdit.get(i).getId())) {					
						productoCompraActual.get(i).setCantidad(productoCompraEdit.get(i).getCantidad());
						productoCompraActual.get(i).setCodigo(productoCompraEdit.get(i).getCodigo());
						productoCompraActual.get(i).setDescripcion(productoCompraEdit.get(i).getDescripcion());
						productoCompraActual.get(i).setIgv(productoCompraEdit.get(i).getIgv());
						productoCompraActual.get(i).setNomProd(productoCompraEdit.get(i).getNomProd());
						productoCompraActual.get(i).setSaldo(productoCompraEdit.get(i).getSaldo());
						productoCompraActual.get(i).setSubTotal(productoCompraEdit.get(i).getSubTotal());
						productoCompraActual.get(i).setTotal(productoCompraEdit.get(i).getTotal());
						productoCompraActual.get(i).setvUnit(productoCompraEdit.get(i).getvUnit());
					} else {
						productoCompraEdit.get(i).setCompraId(compraActual);
						productoCompraActual.add(productoCompraEdit.get(i));
					}
				}else {
					productoCompraEdit.get(i).setCompraId(compraActual);
					productoCompraActual.add(productoCompraEdit.get(i));
				}
			}else {
				productoCompraEdit.get(i).setCompraId(compraActual);
				productoCompraActual.add(productoCompraEdit.get(i));
			}
		}
		
		List<ProductoCompra> productoCompraDelete = new ArrayList<>();
		for(int i=0; i<productoCompraActual.size(); i++) {				
			if(productoCompraActual.get(i).getId() != null) {				
				if(!existProductoCompra(productoCompraEdit, productoCompraActual.get(i).getId())) {
					productoCompraDelete.add(productoCompraActual.get(i));
				}
			}
		}
		
		if(productoCompraDelete != null) {			
			for(int i=0; i<productoCompraDelete.size(); i++) {
				productoCompraActual.remove(productoCompraDelete.get(i));
			}
		}
		
		deleteAll(productoCompraDelete);
		return (List<ProductoCompra>) productoCompraDao.saveAll(productoCompraActual);
	}

	@Override
	@Transactional
	public void deleteAll(List<ProductoCompra> productos) {
		// TODO Auto-generated method stub
		productoCompraDao.deleteAll(productos);
	}

	@Override
	@Transactional
	public void deleteByCompraId(Compra compra) {
		// TODO Auto-generated method stub
		productoCompraDao.deleteByCompraId(compra);
	}

}
