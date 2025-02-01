package entidades;

public class ServicoJurosBrasil implements TaxaJuros {

	private double taxaJuros;

	public ServicoJurosBrasil(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	@Override
	public double getTaxaJuros() {
		return taxaJuros;
	}

}
