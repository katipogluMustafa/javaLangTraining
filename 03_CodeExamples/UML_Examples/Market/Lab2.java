package com.meshale;

public class Lab2 {
	
	public static void main(String... args) {
		
		Market f = new Market("Yildiz");
		f.sepetEkle("Sepet-1");
		f.sepetEkle("Sepet-2");
		
		Urun a[] = new Urun[6];
		a[0] = new Elektronik(1, "Telefon", 50);
		a[1] = new Elektronik(6, "Bilgisayar", 50);
		a[2] = new Elektronik(2, "Hopörlör", 50);
		a[3] = new Gida(3, "Mercimek", 50);
		a[4] = new Gida(4, "Nohut", 50);
		a[5] = new Gida(5, "Fasulye", 50);
		
		f.getSepet("Sepet-1").urunEkle(a[0]);
		f.getSepet("Sepet-1").urunEkle(a[1]);
		f.getSepet("Sepet-1").urunEkle(a[2]);
		f.getSepet("Sepet-2").urunEkle(a[3]);
		f.getSepet("Sepet-2").urunEkle(a[4]);
		f.getSepet("Sepet-2").urunEkle(a[5]);
		
		f.marketTanit();
		
		for(int i = 0; i < a.length; i++)
			a[i].fiyatGuncelle();
		
		f.marketTanit();
		
	}
	
	
}
