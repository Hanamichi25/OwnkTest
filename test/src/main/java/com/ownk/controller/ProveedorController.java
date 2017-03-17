package com.ownk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ownk.model.ProductoModel;
import com.ownk.model.ProveedorModel;
import com.ownk.service.ProductoServiceImpl;
import com.ownk.service.ProveedorServiceImpl;


@Controller	
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	@Qualifier("proveedorService")
	private ProveedorServiceImpl proveedorService; 
	
	@Autowired
	@Qualifier("productoService")
	private ProductoServiceImpl productoService; 

	@GetMapping("/proveedorform")
	private String redirectProveedorForm(@RequestParam(name="nit",required=false) int nit, Model model){
		ProveedorModel proveedor = new ProveedorModel();
		if(nit != 0){
			proveedor = proveedorService.findProveedorModelByNit(nit);
		}
		model.addAttribute("proveedorModel", proveedor);
		return "proveedorform";	
	}
	
	
	@GetMapping("/cancel")
	public String cancel(){
		return "redirect:/proveedor/showproveedore";
	}
	
	@PostMapping("/addproveedor")
	public String addProveedor(@ModelAttribute (name = "proveedorModel") ProveedorModel proveedor, 
				Model model){
		if(null != proveedorService.addProveedor(proveedor)){
			model.addAttribute("result", 1);
		}else{
			model.addAttribute("result", 0);
		}
		
		
		return "redirect:/proveedor/showproveedore";
	}
	@GetMapping("/showproveedore")
	public ModelAndView showProveedores(){
		ModelAndView mav = new ModelAndView("proveedores");
		mav.addObject("proveedores", proveedorService.listAllProveedo());
	    mav.addObject("productos", productoService.listAllProductos());
		return mav;
	}
	
	@GetMapping("/asociarproducto")
	private ModelAndView redirectAsociarProducto(@RequestParam(name="nit",required=true) int nit){
		ProveedorModel proveedor = new ProveedorModel();
		ModelAndView mav = new ModelAndView("addproducto");
		mav.addObject("productos",productoService.listAllProductos());
		if(nit != 0){
			proveedor = proveedorService.findProveedorModelByNit(nit);
			mav.addObject("proveedor", proveedor);
		}
		return mav;	
	}
	
	@PostMapping("/addproducto")
	public String addProducto(@RequestParam(name="nit") int nit,@ModelAttribute (name = "productoModel") ProductoModel producto ){
		ProveedorModel proveedor = new ProveedorModel();
		proveedor = proveedorService.findProveedorModelByNit(nit);
		List<ProductoModel> listproductos= new ArrayList<ProductoModel>();
		listproductos.add(producto);
		proveedor.setProductos(listproductos);
		proveedorService.addProveedor(proveedor);

		return "redirect:/proveedor/asociarproducto";
	}
	
	
	@GetMapping("/removeproveedor")
	public ModelAndView removeProveedor(@RequestParam(name="nit", required=true) int nit ){
		proveedorService.removeProveedor(nit);
		return showProveedores();
		
	}
	
	
	
	
}
