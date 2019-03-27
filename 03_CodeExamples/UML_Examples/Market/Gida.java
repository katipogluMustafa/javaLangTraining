package com.meshale;

public class Gida extends Urun{
	
	public Gida(int id, String urunAdi, double fiyat) {
		super(id, urunAdi, fiyat);
	}

	@Override
	public void fiyatGuncelle() {
		double x = 1.08;
		super.setFiyat( super.getFiyat() * x );
	}
	
}
