package aplicacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entidades.AluguelCarro;
import model.entidades.Veiculo;
import model.servicos.ServicoAluguel;
import model.servicos.ServicoFiscalBrasil;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		System.out.print("Modelo do carro: ");
		String modeloCarro = sc.nextLine();
		System.out.print("Retirada (dd/MM/yyy) hh:MM): ");
		LocalDateTime iniciar = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Retorno (dd/MM/yyy) hh:MM): ");
		LocalDateTime terminar = LocalDateTime.parse(sc.nextLine(), fmt);
		
		AluguelCarro ac = new AluguelCarro(iniciar, terminar, new Veiculo(modeloCarro));
		
		System.out.print("Entre com o preço por hora: ");
		double precoHora = sc.nextDouble();
		System.out.print("Entre com preço por dia: ");
		double precoDia = sc.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoHora, precoDia, new ServicoFiscalBrasil());
		
		servicoAluguel.processarFatura(ac);
		
		System.out.println("FATURA: ");
		System.out.println("Pagamento básico: " + ac.getFatura().getPagamentoBasico());
		System.out.println("Imposto: " + ac.getFatura().getImposto());
		System.out.println("Pagamento total: " + ac.getFatura().getPagamentoTotal());
		
		
		
		sc.close();
	}

}
