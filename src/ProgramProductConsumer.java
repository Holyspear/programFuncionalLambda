import java.util.ArrayList;
import java.util.List;

import model.entities.Product;
import model.util.PriceUpdate;

public class ProgramProductConsumer {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		//Criada uma classe referencia para dar update em cada instância
		list.forEach(new PriceUpdate());
		//Nova forma de imprimir uma coleção utilizando Lambda
		//Isso porque o println é um método estático da classe System
		list.forEach(System.out::println);

	}

}
