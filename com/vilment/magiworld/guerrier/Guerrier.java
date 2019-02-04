package com.vilment.magiworld.guerrier;

public class Guerrier extends Personnage {

    private String coupBasique = "Coup d'Epée";
    private String couSpecial = "Coup de Rage";
    private int viePerdu = 0;

    public Guerrier(String nom, int typePersonnage, int niveau, int force, int agilite, int intelligence) {

        super(nom, typePersonnage, niveau, force, agilite, intelligence);
    }

    public int attackBasique(){
        return getForce();
    }

    public int attackSpecial() {
        viePerdu = getForce() / 2;
        setVie(getVie() - viePerdu);
        return getForce() * 2;
    }

    public String getCoupBasique() {
        return coupBasique;
    }

    public String getCouSpecial() {
        return couSpecial;
    }

    public int getViePerdu() {
        return viePerdu;
    }
}
