package com.ownk.service;

import java.util.List;

import com.ownk.entity.Proveedor;
import com.ownk.model.ProveedorModel;


public interface ProveedorService {
	public 	abstract ProveedorModel addProveedor(ProveedorModel proveedor);
	
	public abstract List<ProveedorModel> listAllProveedo();
	
	public abstract Proveedor findProveedorByNit(int nit);
	
	public abstract void removeProveedor(int nit);
	
	public abstract ProveedorModel findProveedorModelByNit(int nit);
}
	