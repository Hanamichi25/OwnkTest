package com.ownk.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ownk.model.ProductoModel;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	
	@Id
	@Column(name = "nit")
	private int nit;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@OneToMany(targetEntity=Producto.class)
	private List<Producto> productos;
	
	

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> list) {
		this.productos = list;
	}

	public Proveedor() {
		super();
	}

	public Proveedor(int nit, String nombres, String apellidos) {
		super();
		this.nit = nit;
		this.nombres = nombres;
		this.apellidos = apellidos;
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
	
	
	
	
}
