package com.meshale.SchoolGround;

public class Oda {
    private String isim;

    public Oda(String isim){
        this.isim = isim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public static Oda[] odaFabrikasi(String... odaIsimleri){
        Oda[] odalar = new Oda[odaIsimleri.length];

        for(int i = 0; i < odaIsimleri.length; i++)
            odalar[i] = new Oda(odaIsimleri[i]);

        return odalar;
    }

    @Override
    public String toString() {
        return "Oda{" +
                "isim='" + isim + '\'' +
                '}';
    }
}
