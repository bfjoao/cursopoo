package model.servicos;

import java.time.Duration;

import model.entidades.AluguelCarro;
import model.entidades.Fatura;

public class ServicoAluguel {

	private Double precoHora;
	private Double precoDia;

	private ServicoFiscalBrasil servicoFiscal;

	public ServicoAluguel(Double precoHora, Double precoDia, ServicoFiscalBrasil servicoFiscal) {
		super();
		this.precoHora = precoHora;
		this.precoDia = precoDia;
		this.servicoFiscal = servicoFiscal;
	}

	public void processarFatura(AluguelCarro aluguelCarro) {
		
		double minutos = Duration.between(aluguelCarro.getIniciar(), aluguelCarro.getTerminar()).toMinutes();
		double horas = minutos / 60;
		
		double pagamentoBasico;
		if (horas <= 12) {
			pagamentoBasico = precoHora * Math.ceil(horas);
		}
		else {
			pagamentoBasico = precoDia * Math.ceil(horas / 24);
		}
		
		double imposto = servicoFiscal.imposto(pagamentoBasico);
		
		aluguelCarro.setFatura(new Fatura(pagamentoBasico, imposto));
	}

}
