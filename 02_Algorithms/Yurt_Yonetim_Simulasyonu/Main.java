package lab4;

public class Main {
	public static void main(String... args) {
		YurtYonetim yurtYonetim = new YurtYonetim();
		Ogrenci ogr1 = new Ogrenci("1", "Ahmet", "OZ", 1000);
		Ogrenci ogr2 = new Ogrenci("2", "Ahmet", "BOZ", 1500);
		Ogrenci ogr3 = new Ogrenci("3", "Ayse", "TEZ", 2000);
		Ogrenci ogr4 = new Ogrenci("4", "Ali", "OZTURK", 1500);
		Ogrenci ogr5 = new Ogrenci("5", "Mehmet", "Oz", 1000);
		
		try {
			yurtYonetim.OgrenciEkle(ogr1);
			yurtYonetim.OgrenciEkle(ogr2);
			yurtYonetim.OgrenciEkle(ogr3);
			yurtYonetim.OgrenciEkle(ogr4);
		}catch( KapasiteDoluIstisna | AyniIDliOgrenciIstisna e) {
			System.out.println( e );
		}
		
		yurtYonetim.listeyazdir();
		yurtYonetim.borcOde("2", 1500);
		
		try {
			yurtYonetim.OgrenciCikar("2");		// listeden cikar
			yurtYonetim.OgrenciCikar("1");		// istisna olcak
		}catch(BorcuOlanOgrenciAyrilamazIstisna e) {
			System.out.println(e);
		}
		

		yurtYonetim.borcOde("1", 1000);
		try {
			yurtYonetim.OgrenciCikar("1");
		}catch(BorcuOlanOgrenciAyrilamazIstisna e) {
			System.out.println(e);
		}
		
		yurtYonetim.borcArttir(1000);
		yurtYonetim.listeyazdir();
		
		try {
			yurtYonetim.OgrenciEkle(ogr5);		// eklenecek
		}catch( KapasiteDoluIstisna | AyniIDliOgrenciIstisna e) {
			System.out.println( e );
		}
		
		try {
			yurtYonetim.OgrenciEkle(ogr3);		// istisna olucak
		}catch( KapasiteDoluIstisna | AyniIDliOgrenciIstisna e) {
			System.out.println( e );
		}
		
		yurtYonetim.listeyazdir();
		
		
	}
}
