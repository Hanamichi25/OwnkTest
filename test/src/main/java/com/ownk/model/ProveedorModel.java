package com.ownk.model;

import java.util.List;

public class ProveedorModel {
	private int nit;
	private String nombres;
	private String apellidos;
	private List<ProductoModel> productos;
	
	
	
	public List<ProductoModel> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductoModel> productos) {
		this.productos = productos;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public ProveedorModel(int nit, String nombres, String apellidos) {
		super();
		this.nit = nit;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	public ProveedorModel() {
		super();
	}
	
	
}
