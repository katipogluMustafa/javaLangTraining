package lab4;

import java.util.ArrayList;
import java.util.List;

public class YurtYonetim {
	private List<Ogrenci> ogrenciler;
	private int ogrenciLimit;
	
	public YurtYonetim() {
		ogrenciler = new ArrayList<>();
		ogrenciLimit = 3;	
	}
	
	public void OgrenciEkle(Ogrenci ogr) throws KapasiteDoluIstisna, AyniIDliOgrenciIstisna{
		if( ogr == null)
			return;
		
		if( bosYerSayisi() <= 0 )
			throw new KapasiteDoluIstisna("Yurt Kapasitesi Dolu");
		
		if( ogrenciBul(ogr.getId()) != null )
			throw new AyniIDliOgrenciIstisna("Ayný ID'ye sahip zaten ogrenci sistemde var");
		
		ogrenciler.add(ogr);
		System.out.println(ogr.getAd() + " " + ogr.getSoyad() + " Yurda eklendi");
	}	
	
	public boolean OgrenciCikar(String id) throws BorcuOlanOgrenciAyrilamazIstisna {
		Ogrenci ogr = ogrenciBul(id);
		if( id == null )
			return false;
		
		if( ogr.borcVarMi() )
			throw new BorcuOlanOgrenciAyrilamazIstisna( ogr.getAd() + " borcunu odemeden ayrilamaz. Borc: " + ogr.getBorc());
		
		ogrenciler.remove(ogr);
		return true;
	}
	
	public boolean borcOde(String id, int amount) {
		Ogrenci ogr = ogrenciBul(id);
		if(ogr == null)
			return false;
		
		ogr.setBorc( ogr.getBorc() - amount );
		return true;
	}
	
	public void borcArttir(int amount) {
		ogrenciler.forEach( ogr->{
			ogr.setBorc(ogr.getBorc() + amount);
		});
	}
	
	
	private Ogrenci ogrenciBul(String id) {
		for(Ogrenci o : ogrenciler) {
			if( o.getId().equals(id) )
				return o;
		}
		
		return null;
	}
	
	private int bosYerSayisi() {
		return ogrenciLimit - ogrenciler.size();
	}
	
	public void listeyazdir() {
		System.out.println("\nOGRENCI LISTESI");
		for( Ogrenci o : ogrenciler)
			System.out.println(o);
	}

}
