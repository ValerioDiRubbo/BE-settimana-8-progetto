package it.wallet.pojo;

import java.time.LocalDate;

// importo, data, tipo, iban
public class Movimenti {

	private String data;
	private String tipoMovimento;
	private double importo;
	private int ibanMov;
	
	public Movimenti() {
	}

	public Movimenti(String data, String tipoMovimento, double importo, int iban) {
		this.data = data;
		this.tipoMovimento = tipoMovimento;
		this.importo = importo;
		this.ibanMov = iban;
	}

	public String getData() {
		return data;
	}

	public String getTipoMovimento() {
		return tipoMovimento;
	}

	public double getImporto() {
		return importo;
	}

	public int getIban() {
		return ibanMov;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setTipoMovimento(String tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public void setIban(int iban) {
		this.ibanMov = iban;
	}
	
	
	
}
