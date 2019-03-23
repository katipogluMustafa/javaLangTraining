package com.meshale.SchoolGround;



public class Main {

    public static void main(String[] args) {
        IdariPersonel müdür = new IdariPersonel(5,"152345","Tcp-IP",new Daire(1));
        IdariPersonel müdürYardimcisi = new IdariPersonel(3,"451271","Udp-Protocol", new Daire(2));
        AkademikPersonel monster = new AkademikPersonel("Professor", "5624123","Monster Santavik", new Daire(3));
        AkademikPersonel trainee = new AkademikPersonel("Reasearcher","263214","SGM-P2", new Daire(4));

        Personel[] ytu = new Personel[4];
        ytu[0] = müdür;ytu[1] = müdürYardimcisi;ytu[2] = monster;ytu[3] = trainee;

        for(Personel p : ytu)
            p.kendiniTanit();



        }
    }
