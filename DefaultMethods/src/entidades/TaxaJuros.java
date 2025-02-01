package entidades;

import java.security.InvalidParameterException;

public interface TaxaJuros {

	double getTaxaJuros();

	default double pagamento(double quantia, int meses) {
		if (meses < 1) {
			throw new InvalidParameterException("O número de meses deve ser maior que zero!");
		}
		return quantia * Math.pow(1.0 + getTaxaJuros() / 100, meses);
	}
	
}
