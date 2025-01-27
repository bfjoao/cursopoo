package servicos;

public class ServicoPagamento implements ServicoPagamentoOnline {

	@Override
	public double taxaPagamento(double quantia) {
		// TODO Auto-generated method stub
		return quantia * 0.02;
	}

	@Override
	public double juros(double quantia, int meses) {
		// TODO Auto-generated method stub
		return quantia * 0.01 * meses;
	}

	
}
