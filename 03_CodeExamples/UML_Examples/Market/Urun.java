package com.meshale;

public abstract class Urun {
	private int id;
	private String urunAdi;
	private double fiyat;
	
	public Urun(int id, String urunAdi, double fiyat) {
		this.id = id;
		this.urunAdi = urunAdi;
		this.fiyat = fiyat;
	}
	
	public double getFiyat() {
		return this.fiyat;
	}
	
	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	
	public abstract void fiyatGuncelle();

	@Override
	public String toString() {
		return "Urun [id=" + id + ", urunAdi=" + urunAdi + ", fiyat=" + fiyat + "]";
	}
	
	
}

