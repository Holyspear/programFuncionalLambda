package model.util;

import java.util.function.Function;

import model.entities.Product;

public class UperCaseName implements Function<Product, String> {

	@Override
	public String apply(Product product) {
		return product.getName().toUpperCase();
	}
	
	

}
