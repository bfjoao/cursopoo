package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Funcionario;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantos funcionários você deseja registar? ");
		int num = sc.nextInt();
		
		List<Funcionario> list = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			System.out.println("Funcionário #" + (i+1));
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (idExiste(list, id)) {
				System.out.println("Esse id já existe! Tente novamente!");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Salário: ");
			Double salario = sc.nextDouble();
			
			Funcionario fun = new Funcionario(id, salario, nome);
			
			list.add(fun);
		}
		
		System.out.println("Digite o id do funcionário que vai receber o aumento de salário: ");
		int idaumento = sc.nextInt();
		
		// Função para encontrar o id na lista
		Funcionario fun = list.stream().filter(x -> x.getId() == idaumento).findFirst().orElse(null);
		
		
		if (fun == null) {
			System.out.println("Esse id não existe!");
		}
		else {
			System.out.print("Digite a porcentagem: ");
			double porcentagem = sc.nextDouble();
			fun.aumentarSalario(porcentagem);
		}
		
		System.out.println();
		System.out.println("Lista de funcionários");
		for (Funcionario f : list) 
			System.out.println(f);
		
		
		sc.close();
	}
	// Função para testar se o id já existe
	public static boolean idExiste(List<Funcionario> list, int id) {
		Funcionario fun = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return fun !=  null;
	}

}