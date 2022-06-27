package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Product;

public class ProgramExercicioStream {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		//String path = sc.nextLine();
		String path = "C:\\Workspaces\\ws-eclipse\\programacao_funcional_lambda\\inProducts.txt";
		
		try(BufferedReader bfs = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"))){
			
			List<Product> list = new ArrayList<>();
			String linha = bfs.readLine();
			String[] vetorString;
			while(linha != null) {
				vetorString = linha.split(",");
				list.add(new Product(vetorString[0], Double.parseDouble(vetorString[1])));
				linha = bfs.readLine();
			}
			
			//Primeiro transformo a lista em double para retornar a m�dia
			double avg = list.stream()
					//Utilizo fun��o map para reduzir a lista apenas para o Pre�o
					.map(product -> product.getPrice())
					//Uso ao fun��o reduce para somar tudo (Come�a com zero de cria uma fun��o anonima para somar x e y)
					//Depois eu pego o resultado e divido pelo tamanho da lista (Quantidade de produtos)
					.reduce(0.0, (x,y) -> x + y) / list.size();
			System.out.println("Average price: " + String.format("%.2f", avg));
			
			//Agora vou pegar os produtos que est�o abaixo da m�dia de pre�os (avg) e listar em ordem decrescente
			//Lembrando que precisamos criar um comparator para ordenar
			Comparator<String> comp = (string1 ,string2) -> string1.toLowerCase().compareTo(string2.toLowerCase());
			
			List<String> names = list.stream()
					//Filtrar todos os produtos que tem pre�o menor que a m�dia
					.filter(product -> product.getPrice() < avg)
					//Pegar o nome de cada produto com o map
					.map(product -> product.getName())
					//Ordenar em ordem decrescente de nome repassando o comparator(Modo Reverse)
					.sorted(comp.reversed())
					//Vamos transformar nosso Pipeline em lista novamente
					.collect(Collectors.toList());
			
			//N�o esque�a de utilizar o iterator do lambda (forEach)
			names.forEach(System.out::println);
					
			
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			sc.close();
		}

	}

}
