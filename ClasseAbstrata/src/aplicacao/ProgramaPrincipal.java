package aplicacao;

import java.util.ArrayList;
import java.util.List;

import entidades.Conta;
import entidades.ContaEmpresarial;
import entidades.ContaPoupanca;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Conta> list = new ArrayList<>();
		
		list.add(new ContaPoupanca(1001, "Alex", 500.00, 0.01));
		list.add(new ContaEmpresarial(1002, "Maria", 1000.0, 400.0));
		list.add(new ContaPoupanca(1003, "Bob", 300.0, 0.01));
		list.add(new ContaEmpresarial(1004, "Anna", 500.0, 500.0));
		
		double soma = 0.0;
		for (Conta acc : list) {
			soma += acc.getSaldo();
		}
		
		System.out.printf("Saldo total: %.2f%n", soma);
		
		for (Conta acc : list) {
			acc.deposito(10.0);
		}
		for (Conta acc : list) {
			System.out.printf("Saldo atualizado para conta %d: %.2f%n", acc.getNumero(), acc.getSaldo());
		}
	}

}
