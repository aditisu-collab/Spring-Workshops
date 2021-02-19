package com.example;

import java.util.List;
import java.util.Optional;

public interface ProductService {
	
	public List<Product> displayAll();
	public void  add(Product product);
	public void delete(int id);
	public Optional<Product> findById(int id);
	void update(Product product);
	

}
