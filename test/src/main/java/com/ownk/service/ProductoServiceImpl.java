package com.ownk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ownk.component.ProductoConverter;
import com.ownk.component.ProveedorConverter;
import com.ownk.entity.Producto;
import com.ownk.entity.Proveedor;
import com.ownk.model.ProductoModel;
import com.ownk.model.ProveedorModel;
import com.ownk.repository.ProductoRepository;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	@Qualifier("productoRepository")
	private ProductoRepository poductoRepo;
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConver;

	@Override
	public ProductoModel addProducto(ProductoModel producto) {
		Producto pro = poductoRepo.save(productoConver.convertProductoModeltoProducto(producto));
		return productoConver.convertProductoToProductoModel(pro);
	}

	@Override
	public List<ProductoModel> listAllProductos() {
		List<Producto> productos = poductoRepo.findAll();
		List<ProductoModel> proveedoresModel = new ArrayList<ProductoModel>();
		for(Producto producto : productos){
			proveedoresModel.add(productoConver.convertProductoToProductoModel(producto));
		}
			
		return proveedoresModel;
	}

	@Override
	public Producto findProductoByNit(int codigo) {
		return poductoRepo.findByCodigo(codigo);
	}

	@Override
	public void removeProducto(int codigo) {
		Producto producto = findProductoByNit(codigo);
		if(null != producto){
			poductoRepo.delete(findProductoByNit(codigo));
		}
	}

	@Override
	public ProductoModel findProductoModelByNit(int codigo) {
		return productoConver.convertProductoToProductoModel(findProductoByNit(codigo));
	}

}
