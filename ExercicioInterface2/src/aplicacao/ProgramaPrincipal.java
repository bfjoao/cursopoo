package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Parcela;
import servicos.ServicoContrato;
import servicos.ServicoPagamento;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Número: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate data = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double valorTotal = sc.nextDouble();
		
		Contrato obj = new Contrato(numero, data, valorTotal);
		
		System.out.print("Entre com o número de parcelas: ");
		int n = sc.nextInt();
		
		ServicoContrato servicoContrato = new ServicoContrato(new ServicoPagamento());
		
		servicoContrato.processoContrato(obj, n);
		
		System.out.println("Parcelas:");
		for (Parcela parcela : obj.getParcelas()) {
			System.out.println(parcela);
		}
		
		
		
		sc.close();
	}

}
