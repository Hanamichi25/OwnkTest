package com.ownk.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ownk.entity.Producto;


@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable> {
	public abstract Producto findByCodigo(int codigo);
}
