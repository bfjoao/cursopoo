package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Funcionario;
import entidades.FuncionarioTerceirizado;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		List<Funcionario> list = new ArrayList<>();
		
		System.out.print("Informe o número de funcionários: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Dados do #" + (i+1 + " funcionário"));
			System.out.print("Terceirizado (s/n)? ");
			char sn = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Horas: ");
			int horas = sc.nextInt();
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			
			if(sn == 's') {
				System.out.print("Taxa adicional: ");
				double taxaAdicional = sc.nextDouble();
				list.add(new FuncionarioTerceirizado(nome, horas, valorPorHora, taxaAdicional));
			}
			
			else {
				list.add(new Funcionario(nome, horas, valorPorHora));
			}
		}
		
		System.out.println();
		System.out.println("PAGAMENTOS:");
		for(Funcionario fun : list) {
			System.out.println(fun.getNome() + " - $" + String.format("%.2f", fun.pagamento()));
		}
		
		sc.close();
	}

}