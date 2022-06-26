package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.entities.Product;
import model.util.UperCaseName;

public class ProductToUpperCase {
	
	public static void main (String[] args) {
		
		List<Product> list = new ArrayList<>();
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		//Primeiramente preciso transformar a lista (List) em uma STREAM para poder utilizar o método map
		//O método map não é a estrutura Map, ele é um método que aplica funções em cada objeto de uma lista.
		//Portanto, o map exige que a lista esteja no formato stream, e é justamente isso que vamos fazer:
		//converter a lista para stream através do .stream(), aplicar o map e depois converter a lista
		//para seu formato List novamente através do .collect(Collectors.toList())
		List<String> names = list.stream().map(new UperCaseName()).collect(Collectors.toList());
		
		//Utilize o forEach para percorrer a nova lista apenas com Nomes
		names.forEach(System.out::println);
		
	}

}
