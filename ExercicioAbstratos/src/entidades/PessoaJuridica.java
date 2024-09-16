package entidades;

public class PessoaJuridica extends Contribuinte {

	private int numFuncionarios;

	public PessoaJuridica(String nome, Double rendaAnual, int numFuncionarios) {
		super(nome, rendaAnual);
		this.numFuncionarios = numFuncionarios;
	}

	public int getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(int numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	@Override
	public double imposto() {
		return (numFuncionarios > 10) ? getRendaAnual() * 0.14 : getRendaAnual() * 0.16;
	}

}
