package model.services;

import java.util.List;
import java.util.function.Predicate;

import model.entities.Product;

public class ProductService {
	
	public double filteredSum(List<Product> productList) {
		double sum = 0.0;
		for(Product product : productList) {
			if(product.getName().charAt(0) == 'T') {
				sum += product.getPrice();
			}
		}
		return sum;
	}
	
	//Abstração do método para infusão de predicado genérico
	public double filteredSumGeneric(List<Product> productList, Predicate<Product> predicate) {
		double sum = 0.0;
		for(Product product : productList) {
			if(predicate.test(product)) {
				sum += product.getPrice();
			}
		}
		return sum;
	}
}
