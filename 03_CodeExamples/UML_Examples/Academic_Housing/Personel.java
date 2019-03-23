package com.meshale.SchoolGround;

public abstract class Personel {
    private String id;
    private String adSoyad;
    private Daire ev;

    public Personel(String id, String adSoyad, Daire ev ){
        this.id = id;
        this.adSoyad = adSoyad;
        this.ev = ev;
    }

    public abstract void kendiniTanit();

    /**
     *
     * @return Evin kapı numarasını döner, daire null olması durumda kapi numarası -1 döner.
     */
    public int getDaireKapiNo(){
        if( ev == null)
            return -1;
        return ev.getKapiNo();
    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                ", adSoyad='" + adSoyad + '\'' +
                ", ev=" + ev +
                '}';
    }
}
