package aplicacao;

import java.util.Scanner;

import entidades.ServicoJurosBrasil;
import entidades.TaxaJuros;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantia: ");
		double quantia = sc.nextDouble();
		System.out.print("Meses: ");
		int meses = sc.nextInt();

		TaxaJuros tj = new ServicoJurosBrasil(2.0);
		double pagamento = tj.pagamento(quantia, meses);
		
		System.out.print("Pagamento após " + meses + " meses: ");
		System.out.print(String.format("%.2f", pagamento));
	}

}
