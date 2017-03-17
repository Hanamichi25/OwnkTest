package com.ownk.service;

import java.util.List;

import com.ownk.entity.Producto;
import com.ownk.model.ProductoModel;


public interface ProductoService {
	public 	abstract ProductoModel addProducto(ProductoModel proveedor);
	
	public abstract List<ProductoModel> listAllProductos();
	
	public abstract Producto findProductoByNit(int codigo);
	
	public abstract void removeProducto(int codigo);
	
	public abstract ProductoModel findProductoModelByNit(int codigo);
}
