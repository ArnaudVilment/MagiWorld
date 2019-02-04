package com.vilment.magiworld.guerrier;

public class Rodeur extends Personnage {

    private String coupBasique = "Tir à l’Arc";
    private String couSpecial = "Concentration";

    public Rodeur(String nom1, String nom, int typePersonnage, int niveau, int force, int agilite, int intelligence) {

        super(nom1, nom, typePersonnage, niveau, force, agilite, intelligence);
    }

    public int attackBasique(){
        return getAgilite();
    }

    public int attackSpecial() {
        int agiliteDepart = getAgilite();
        int agiliteGagne = getNiveau() / 2;
        setAgilite(agiliteDepart + agiliteGagne);

        return agiliteGagne;
    }

    public String getCoupBasique() {
        return coupBasique;
    }

    public String getCouSpecial() {
        return couSpecial;
    }
}
