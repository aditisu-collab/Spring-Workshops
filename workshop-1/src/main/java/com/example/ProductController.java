package com.example;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
	@Autowired
	ProductService ps;
	
	//check jsp page
	@RequestMapping(path = {"/","/index"}, method = RequestMethod.GET)
	public String getIndex(ModelMap model) {
		System.out.println("Product Controller is called...");
		List<Product> products = ps.displayAll();
		model.addAttribute("products",products);
		System.out.println("Product controller is being called"+products);
		return "index";
	}
	
	@RequestMapping(path = {"/viewAdd"}, method = RequestMethod.GET)
	public String getProductPage() {
		System.out.println("Product List");
		return "add-product";
	}
	
	
	//add product
	@GetMapping(path = "/insert")
	public String addProduct(@RequestParam String name) {
		Product product = new Product(name);
		System.out.println("Add Product : "+product);
		ps.add(product);
		return "redirect:/";
	}
	
	//delete product
	@GetMapping(path = "/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		System.out.println("Delete product with ID : "+id);
		ps.delete(id);
		return "redirect:/";
	}
	
	
	 //update product
	 
	@GetMapping(path = "/viewUpdate/{id}")
		public String getProduct(@PathVariable Integer id, ModelMap model) {
		System.out.println("Show product with Id: "+id);
		Optional<Product> p = ps.findById(id);
		Product product = p.get();
		System.out.println("Product Updated"+product);
		model.addAttribute("product", product);
		return "update-product"; 
	}
	
	@GetMapping(path = "/update")
	public String updateProduct(@RequestParam int id, @RequestParam String name) {
	System.out.println("Update  product: "+id);
	Product product = new Product(id, name);
	System.out.println("Product : "+product);
	ps.update(product);
	return "redirect:/";
}
	
	
	
	
	
	

}
