package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.StatusPedido;

public class ProgramaPrincipal {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira os dados do cliente:");
		System.out.println("Nome: ");
		String nomeCliente = sc.nextLine();
		System.out.println("Email: ");
		String emailCliente = sc.nextLine();
		System.out.println("Data de nascimento: ");
		Date clienteNascimento = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nomeCliente, emailCliente, clienteNascimento);
		
		
		System.out.println("Insira os dados do pedido:");
		System.out.println("Status: ");
		sc.nextLine();
		StatusPedido statusPedido = StatusPedido.valueOf(sc.next());
		
		Pedido pedido = new Pedido(new Date(), statusPedido, cliente);
		
		System.out.print("Quantos itens terá esse pedido?");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Dados do #" + (i+1) + " item: ");
			System.out.println("Nome do produto: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.println("Preço: ");
			Double precoProduto = sc.nextDouble();
			System.out.println("Quantidade: ");
			int quantidadeProduto = sc.nextInt();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			ItemPedido ip = new ItemPedido(quantidadeProduto, precoProduto, produto);
			pedido.addItem(ip);
		}
		
		System.out.println(pedido);
		
		sc.close();
	}

}
