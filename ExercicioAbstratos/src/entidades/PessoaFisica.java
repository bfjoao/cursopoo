package entidades;

public class PessoaFisica extends Contribuinte {

	private double gastoSaude;

	public PessoaFisica(String nome, Double rendaAnual, double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	public double imposto() {
		double impostoBasico = (getRendaAnual() < 2000.0) ? getRendaAnual() * 0.15 : getRendaAnual() * 0.25;
		
		impostoBasico -= (getGastoSaude() * 0.5);
		if (impostoBasico < 0.0) {
			impostoBasico = 0.0;
		}
		return impostoBasico;
		
	}

}