package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Circulo;
import entidades.Forma;
import entidades.Retangulo;
import entidades.enums.Cor;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		List<Forma> list = new ArrayList<>();
		
		System.out.print("Digite o número de figuras: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Dados da figura #" + (i + 1));
			System.out.print("Retângulo ou círculo (r/c)? ");
			char rc = sc.next().charAt(0);
			System.out.print("Cor (PRETO/AZUL/VERMELHO): ");
			Cor cor = Cor.valueOf(sc.next());
			if (rc == 'r') {
				System.out.print("Largura: ");
				double largura = sc.nextDouble();
				System.out.print("Altura: ");
				double altura = sc.nextDouble();
				list.add(new Retangulo(cor, largura, altura));
			}
			else {
				System.out.print("Raio: ");
				double raio = sc.nextDouble();
				list.add(new Circulo(cor, raio));
			}
		}
		
		System.out.println();
		System.out.println("ÁREAS FORMA");
		for (Forma forma : list) {
			System.out.println(String.format("%.2f", forma.area()));
		}
		
		sc.close();
	}

}
