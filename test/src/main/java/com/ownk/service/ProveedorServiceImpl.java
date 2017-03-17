package com.ownk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ownk.component.ProveedorConverter;
import com.ownk.entity.Proveedor;
import com.ownk.model.ProveedorModel;
import com.ownk.repository.ProveedorRepository;
@Service("proveedorService")
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	@Qualifier("proveedorRepository")
	private ProveedorRepository proveedorRepo;
	
	@Autowired
	@Qualifier("proveedorConverter")
	private ProveedorConverter proveedorConver;
	
	@Override
	public ProveedorModel addProveedor(ProveedorModel proveedor) {
		Proveedor prov = proveedorRepo.save(proveedorConver.convertProveedorModeltoProveedor(proveedor));
		return proveedorConver.convertProveedorToProveedorModel(prov);
	}

	@Override
	public List<ProveedorModel> listAllProveedo() {
		List<Proveedor> proveedores = proveedorRepo.findAll();
		List<ProveedorModel> proveedoresModel = new ArrayList<ProveedorModel>();
		for(Proveedor proveedor : proveedores){
			proveedoresModel.add(proveedorConver.convertProveedorToProveedorModel(proveedor));
		}
		
		return proveedoresModel;
	}

	@Override
	public Proveedor findProveedorByNit(int nit) {
		return proveedorRepo.findByNit(nit);
	}

	@Override
	public void removeProveedor(int nit) {
		Proveedor proveedor = findProveedorByNit(nit);
		if(null != proveedor){
			proveedorRepo.delete(findProveedorByNit(nit));
		}
	}
	
	public ProveedorModel findProveedorModelByNit(int nit){
		return proveedorConver.convertProveedorToProveedorModel(findProveedorByNit(nit));
		
	}
	
	
	
	
}
