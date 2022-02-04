package it.wallet.pojo;

import java.util.Objects;

//Creazione conto corrente, con data creazione, iban, saldo e intestatario
public class ContoCorrente {

	public String dataCreazione;
	public int iban;
	public double saldo;
	public String intestatario;
	
	
	public ContoCorrente() {
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(iban);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContoCorrente other = (ContoCorrente) obj;
		return Objects.equals(iban, other.iban);
	}



	public String getDataCreazione() {
		return dataCreazione;
	}


	public int getIban() {
		return iban;
	}


	public double getSaldo() {
		return saldo;
	}


	public String getIntestatario() {
		return intestatario;
	}


	
	// Setters
	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}


	public void setIban(int iban) {
		this.iban = iban;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}
	
	
}
