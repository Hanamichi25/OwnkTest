package com.ownk.component;

import org.springframework.stereotype.Component;

import com.ownk.entity.Producto;
import com.ownk.model.ProductoModel;

@Component("productoConverter")
public class ProductoConverter {
	public Producto convertProductoModeltoProducto(ProductoModel productoModel){
		Producto prodcuto = new Producto();
		prodcuto.setCodigo(productoModel.getCodigo());
		prodcuto.setDescripcion(productoModel.getDescripcion());
		return prodcuto;
		
	}
	
	public 	ProductoModel convertProductoToProductoModel(Producto producto){
		ProductoModel productoModel = new ProductoModel();
		productoModel.setCodigo(producto.getCodigo());
		productoModel.setDescripcion(producto.getDescripcion());
		return productoModel;
		
	}
}
