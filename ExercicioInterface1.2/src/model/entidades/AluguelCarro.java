package model.entidades;

import java.time.LocalDateTime;

public class AluguelCarro {

	private LocalDateTime iniciar;
	private LocalDateTime terminar;

	private Veiculo veiculo;
	private Fatura fatura;

	public AluguelCarro() {

	}

	public AluguelCarro(LocalDateTime iniciar, LocalDateTime terminar, Veiculo veiculo) {
		this.iniciar = iniciar;
		this.terminar = terminar;
		this.veiculo = veiculo;
	}

	public LocalDateTime getIniciar() {
		return iniciar;
	}

	public void setIniciar(LocalDateTime iniciar) {
		this.iniciar = iniciar;
	}

	public LocalDateTime getTerminar() {
		return terminar;
	}

	public void setTerminar(LocalDateTime terminar) {
		this.terminar = terminar;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

}
