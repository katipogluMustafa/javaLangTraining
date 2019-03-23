package com.meshale.SchoolGround;

public class IdariPersonel extends Personel {
    private int hizmetYili;

    public IdariPersonel(int hizmetYili, String id, String adSoyad, Daire ev){
        super(id,adSoyad,ev);
        this.hizmetYili = hizmetYili;
    }

    public int getHizmetYili() {
        return hizmetYili;
    }

    public void setHizmetYili(int hizmetYili) {
        this.hizmetYili = hizmetYili;
    }

    @Override
    public String toString() {
        return "IdariPersonel{" +
                "hizmetYili=" + hizmetYili +
                "} " + super.toString();
    }

    @Override
    public void kendiniTanit() {
        System.out.println(this);
    }

}
