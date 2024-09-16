package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Contribuinte;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		List<Contribuinte> list = new ArrayList<>();

		System.out.print("Digite o número de contribuintes: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Dados do contribuinte #" + (i + 1));
			System.out.print("Pessoa física ou jurídica (f/j)? ");
			char fj = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Renda anual: ");
			double rendaAnual = sc.nextDouble();
			if (fj == 'f') {
				System.out.println("Gastos em saúde: ");
				double gastoSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastoSaude));

			}
			else {
				System.out.println("Número de funcionários: ");
				int numFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numFuncionarios));
			}
		}

		System.out.println();
		System.out.println("IMPOSTOS PAGOS:");
		for (Contribuinte ct : list) {
			System.out.println(ct.getNome() + " $ " + String.format("%.2f", ct.imposto()));
		}
		System.out.println();
		double somaImpostos = 0.0;
		for (Contribuinte ct : list) {
			somaImpostos += ct.imposto();
		}
		System.out.println("TOTAL DE IMPOSTOS: " + String.format("%.2f", somaImpostos));
		
		sc.close();
	}
}
