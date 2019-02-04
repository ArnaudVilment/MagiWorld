package com.vilment.magiworld.guerrier;

public class Mage extends Personnage {

    private String coupBasique = "Boule de Feu";
    private String couSpecial = "Soin";
    private int vieDepart = 0;

    public Mage(String nom1, String nom, int typePersonnage, int niveau, int force, int agilite, int intelligence) {

        super(nom1, nom, typePersonnage, niveau, force, agilite, intelligence);
        vieDepart = getVie();
    }

    public int attackBasique(){
        return getIntelligence();
    }

    public int attackSpecial() {
        int vie = 0;
        if(getVie() + getIntelligence() * 2 <= vieDepart) {
            vie = getVie() + getIntelligence() * 2;
            setVie(vie);
            return getIntelligence() * 2;
        } else {
            int vieAvant = getVie();
            vie = vieDepart;
            setVie(vie);
            return vieDepart - vieAvant;
        }
    }

    public String getCoupBasique() {
        return coupBasique;
    }

    public String getCouSpecial() {
        return couSpecial;
    }
}
