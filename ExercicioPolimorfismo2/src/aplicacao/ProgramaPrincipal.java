package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		List <Produto> list = new ArrayList<>();
		
		System.out.print("Informe o número de produtos: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Dados do #" + (i+1) + " produto");
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char cui = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			
			if (cui == 'c') {
				list.add(new Produto(nome, preco));
			}
			
			else if (cui == 'u') {
				System.out.print("Data de fabricação (DD/MM/YYYY): ");
				LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new ProdutoUsado(nome, preco, data));
				
			}
			
			else {
				System.out.print("Taxa alfandegária: ");
				double taxaAlfandega = sc.nextDouble();
				list.add(new ProdutoImportado(nome, preco, taxaAlfandega));
			}
			
		}
		
		System.out.println();
		System.out.println("ETIQUETAS DE PREÇO: ");
		for (Produto prod : list) {
			System.out.println(prod.etiquetaPreco());
		}
			
		sc.close();
	}
	

}
