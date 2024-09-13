package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enums.StatusPedido;

public class Pedido {

	private Date moment;
	private StatusPedido status;

	private Cliente cliente;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private List<ItemPedido> itenspedido = new ArrayList<>();

	public Pedido() {

	}

	public Pedido(Date moment, StatusPedido status, Cliente cliente) {
		this.moment = moment;
		this.status = status;
		this.cliente = cliente;

	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItenspedido() {
		return itenspedido;
	}

	public void addItem(ItemPedido item) {
		itenspedido.add(item);
	}

	public void removeItem(ItemPedido item) {
		itenspedido.remove(item);
	}

	public double total() {
		double soma = 0;
		for (ItemPedido ip : itenspedido) {
			soma = soma + ip.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do pedido: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Status do pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens do pedido: ");
		for (ItemPedido item : itenspedido) {
			sb.append(item + "\n");
		}
		sb.append("Preço total: ");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

}