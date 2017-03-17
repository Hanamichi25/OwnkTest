package com.ownk.controller;

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
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	@Qualifier("productoService")
	private ProductoServiceImpl productoService; 

	@GetMapping("/productoform")
	private String redirectProductoForm(@RequestParam(name="codigo", required=false) int codigo, Model model){
		ProductoModel producto = new ProductoModel();
		if(codigo != 0){
			producto = productoService.findProductoModelByNit(codigo);
		}
		model.addAttribute("productoModel", producto);
		return "productoform";	
	}
	
	@GetMapping("/cancel")
	public String cancel(){
		return "redirect:/proveedor/showproveedore";
	}
	
	@PostMapping("/addproducto")
	public String addProveedor(@ModelAttribute (name = "productoModel") ProductoModel producto, 
				Model model){
		if(null != productoService.addProducto(producto)){
			model.addAttribute("result", 1);
		}else{
			model.addAttribute("result", 0);
		}

		return "redirect:/proveedor/showproveedore";
	}
	
	
	@GetMapping("/removeproducto")
	public String removeProducto(@RequestParam(name="codigo", required=true) int codigo ){
		productoService.removeProducto(codigo);
		return "redirect:/proveedor/showproveedore";
		
	}
}
