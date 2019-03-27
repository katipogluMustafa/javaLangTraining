package com.meshale;

import java.util.ArrayList;

public class Sepet {
	private String ad;
	private ArrayList<Urun> urun;
	
	public Sepet(String ad) {
		this.ad = ad;
		urun = new ArrayList<>();
	}
	
	public void urunEkle( Urun newUrun) {
		urun.add(newUrun);
	}
	
	public void urunTanit() {
		System.out.println("Sepetteki Urunler: ");
		for(Urun u : urun)
			System.out.println(u);
	}

	@Override
	public String toString() {
		return "Sepet [ad=" + ad + ", urun=" + urun + "]";
	}
	
	public String getAd() {
		return this.ad;
	}
	
	
}
