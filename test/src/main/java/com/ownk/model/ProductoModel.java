package com.ownk.model;

public class ProductoModel {
	private int codigo;
	private String descripcion;
	private ProveedorModel proveedor;
	
	public ProveedorModel getProveedor() {
		return proveedor;
	}
	public void setProveedor(ProveedorModel proveedor) {
		this.proveedor = proveedor;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ProductoModel(int codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	public ProductoModel() {
		super();
	}
	
	
}
