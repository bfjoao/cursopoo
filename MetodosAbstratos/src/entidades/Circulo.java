package entidades;

import entidades.enums.Cor;

public class Circulo extends Forma {

	private double raio;

	public Circulo() {
		super();
	}

	public Circulo(Cor cor, double raio) {
		super(cor);
		this.raio = raio;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return Math.PI * raio * raio;
	}

}
