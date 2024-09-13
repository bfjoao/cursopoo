package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<>();

		list.add("João");
		list.add("Neymar");
		list.add("Giulia");
		list.add("Bella");
		list.add("Nélio");
		list.add(2, "Marco");

		System.out.println(list.size());

		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("-----------------------------------");

		list.remove("Bella");
		list.remove(2);
		list.removeIf(x -> x.charAt(0) == 'J');

		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("-----------------------------------");
		System.out.println("Posição de Nélio " + list.indexOf("Nélio"));
		System.out.println("Posição de João " + list.indexOf("João"));
		System.out.println("-----------------------------------");

		// Encontrar elementos na lista que comecem com a letra N
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'N').collect(Collectors.toList());
		for (String x : result) {
			System.out.println(x);
		}
		System.out.println("-----------------------------------");
		// Encontrar primeiro elemento que comece com N na lista
		String name = list.stream().filter(x -> x.charAt(0) == 'N').findFirst().orElse(null);
		System.out.println(name);

	}
}