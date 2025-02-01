package entidades;

public class ServicoJurosUsa implements TaxaJuros {

	private double taxaJuros;

	public ServicoJurosUsa(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	@Override
	public double getTaxaJuros() {
		return taxaJuros;
	}

}
