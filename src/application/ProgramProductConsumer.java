package application;
import java.util.ArrayList;
import java.util.List;

import model.entities.Product;

public class ProgramProductConsumer {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		//Chamando direto no forEach Consumer para Product no Formato Lambda com uma vari�vel externa.
		Double percentage = 1.1;
		
		//M�todo N�O est�tico implementando Consumer na classe Product
		list.forEach(product -> product.setPrice(product.getPrice()*percentage));
		//Nova forma de imprimir uma cole��o utilizando Lambda
		//Isso porque o println � um m�todo est�tico da classe System
		list.forEach(System.out::println);

	}

}
