package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ProgramStream {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(3,4,5,10,7);
		
		Stream<Integer> st1 = list.stream();
		System.out.println(Arrays.toString(st1.toArray()));
		
		Stream<Integer> st2 = list.stream().map(element -> element *10);
		System.out.println(Arrays.toString(st2.toArray()));
		
		
		Stream<String> st3 = Stream.of("Maria","Alex","Bob");
		System.out.println(Arrays.toString(st3.toArray()));
		
		Stream<Integer> st4 = Stream.iterate(0, x -> x+2);
		System.out.println(Arrays.toString(st4.limit(10).toArray()));
		
		//Brincadeira bem confursa de como implementar sequência Fibonacci através de métodos de iteração e lambda
		Stream<Long> st5 = Stream.iterate(new Long[] {0L, 1L}, x -> new Long[] {x[1], x[0]+x[1]}).map(x -> x[0]);
		System.out.println(Arrays.toString(st5.limit(10).toArray()));
	}

}
