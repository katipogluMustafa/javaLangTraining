package com.meshale;

public class Elektronik extends Urun{
	
	public Elektronik(int id, String urunAdi, double fiyat) {
		super(id, urunAdi, fiyat);
	}

	@Override
	public void fiyatGuncelle() {
		double x = 1.18;
		super.setFiyat( super.getFiyat() * x );
	}
	
	
}
