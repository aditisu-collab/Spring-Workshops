package com.example;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository pr;
	

	@Override
	public List<Product> displayAll() {
		return pr.findAll();
	}
	
	@Override
	public void add(Product product) {
		System.out.println("ProductServiceImpl"+product);
		pr.save(product);
		
	}

	@Override
	public void delete(int id) {
		System.out.println("ProductServiceImpl"+id);
		pr.deleteById(id);
		
	}

	@Override
	public Optional<Product> findById(int id) {
		return pr.findById(id);
	}

	@Override
	public void update(Product product) {
		pr.save(product);
	}


}
