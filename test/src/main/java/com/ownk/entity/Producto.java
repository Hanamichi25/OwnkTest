package com.ownk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ownk.model.ProveedorModel;

@Entity
@Table(name = "producto2")
public class Producto {
	
	@Id
	@Column(name = "codigo")
	private int codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne
	private Proveedor proveedor;
	
	

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
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



	public Producto(int codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public Producto() {
		super();
	}
	
	
	
}
