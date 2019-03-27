package com.meshale;

import java.util.ArrayList;

public class Market {
	private String ad;
	private ArrayList<Sepet> sepet;
	
	public Market(String ad) {
		this.ad = ad;
		sepet = new ArrayList<>();
	}
	
	
	public void marketTanit() {
		System.out.println("\nMarketde " + sepet.size() + " adet sepet var. \nSepetler: \n");
		for(Sepet s : sepet)
			System.out.println(s + "\n");
	}
	
	public void sepetEkle(String ad) {
		sepet.add( new Sepet(ad) );
	}
	
	public Sepet getSepet(String ad) {
		Sepet out = null;
		for( Sepet s : sepet) {
			if( s.getAd().equals(ad) )
				out = s;
		}
		
		return out;
	}

}
