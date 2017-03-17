package com.ownk.component;

import org.springframework.stereotype.Component;

import com.ownk.entity.Proveedor;
import com.ownk.model.ProveedorModel;

@Component("proveedorConverter")
public class ProveedorConverter {
	public Proveedor convertProveedorModeltoProveedor(ProveedorModel proveedorModel){
		Proveedor proveedor = new Proveedor();
		proveedor.setNit(proveedorModel.getNit());
		proveedor.setNombres(proveedorModel.getNombres());
		proveedor.setApellidos(proveedorModel.getApellidos());
		return proveedor;
		
	}
	
	public 	ProveedorModel convertProveedorToProveedorModel(Proveedor proveedor){
		ProveedorModel proveedorModel = new ProveedorModel();
		proveedorModel.setNit(proveedor.getNit());
		proveedorModel.setNombres(proveedor.getNombres());
		proveedorModel.setApellidos(proveedor.getApellidos());
		return proveedorModel;
		
	}
	
}