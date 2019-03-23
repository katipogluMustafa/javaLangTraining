package com.meshale.SchoolGround;

public class AkademikPersonel extends Personel{
    private String unvan;

    public AkademikPersonel(String unvan, String id, String adSoyad, Daire ev){
        super(id,adSoyad,ev);
        this.unvan = unvan;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    @Override
    public void kendiniTanit() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "AkademikPersonel{" +
                "unvan='" + unvan + '\'' +
                "} " + super.toString();
    }
}
