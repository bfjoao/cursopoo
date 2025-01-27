package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {

	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate vencimento;
	private Double quantia;

	public Parcela() {

	}

	public Parcela(LocalDate vencimento, Double quantia) {
		this.vencimento = vencimento;
		this.quantia = quantia;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

	public Double getQuantia() {
		return quantia;
	}

	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}

	@Override
	public String toString() {
		return vencimento.format(fmt) + " - " + String.format("%.2f", quantia);
	}

}
