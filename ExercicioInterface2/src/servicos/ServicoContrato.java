package servicos;

import java.time.LocalDate;

import entidades.Contrato;
import entidades.Parcela;

public class ServicoContrato {

	private ServicoPagamentoOnline servicoPagamentoOnline;

	public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}
	
	public void processoContrato(Contrato contrato, int meses) {
		double parcelaBasica = contrato.getValorTotal() / meses;
		
		for (int i=1; i<=meses; i++) {
			LocalDate vencimento = contrato.getData().plusMonths(i);
			
			double juros = servicoPagamentoOnline.juros(parcelaBasica, i);
			double taxa = servicoPagamentoOnline.taxaPagamento(parcelaBasica + juros);
			double cota = parcelaBasica + juros + taxa;
			
			contrato.getParcelas().add(new Parcela(vencimento, cota));
		}
	}
	
}
