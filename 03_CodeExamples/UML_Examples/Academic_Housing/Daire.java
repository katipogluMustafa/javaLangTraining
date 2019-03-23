package com.meshale.SchoolGround;

import java.util.Arrays;

public class Daire {
    private int kapiNo;
    private Oda[] odalar;

    public Daire(int kapiNo){
        this.kapiNo = kapiNo;
        odalar = Oda.odaFabrikasi("oturma odası", "yatak odası", "mutfak");
    }

    public int getKapiNo() {
        return kapiNo;
    }

    public void setKapiNo(int kapiNo) {
        this.kapiNo = kapiNo;
    }

    @Override
    public String toString() {
        return "Daire{" +
                "kapiNo=" + kapiNo +
                ", odalar=" + Arrays.toString(odalar) +
                '}';
    }
}
