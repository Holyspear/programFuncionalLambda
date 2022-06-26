package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.entities.Product;
import model.services.ProductService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		List<Product> list = new ArrayList<>();
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		ProductService productService = new ProductService();
		
		double sum = productService.filteredSum(list);
		System.out.println("Total dos preços de produtos com a letra T: R$ " + String.format("%.2f", sum));
		
		//Utilizando agora a abstração do predicado para criar ele no programa principal		
		double sum2 = productService.filteredSumGeneric(list, product -> product.getName().charAt(0) == 'T');
		System.out.println("Total dos preços com Infusão de Predicado com a letra T: R$ " + String.format("%.2f", sum2));
		
		//Modificando o predicado para letra M
		double sum3 = productService.filteredSumGeneric(list, product -> product.getName().charAt(0) == 'M');
		System.out.println("Total dos preços com Infusão de Predicado com a letra M: R$ " + String.format("%.2f", sum3));
		
		//Modificando o predicado para produtos menor que 100
		double sum4 = productService.filteredSumGeneric(list, product -> product.getPrice() < 100);
		System.out.println("Total dos preços com Infusão de Predicado Produtos menor que 100: R$ " + String.format("%.2f", sum4));		
		
	}
}