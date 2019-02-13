package com.vilment.magiworld.personnage.impl;

import com.vilment.magiworld.personnage.Personnage;

public class Mage extends Personnage {

    private String coupBasique = "Boule de Feu";
    private String couSpecial = "Soin";
    private int vieDepart = 0;

    public Mage(String nom1, String nom, int typePersonnage, int niveau, int force, int agilite, int intelligence) {

        super(nom1, nom, typePersonnage, niveau, force, agilite, intelligence);
        vieDepart = getVie();
    }

    public void infoTypeJoueur(int compteurJoueur) {
        System.out.println("Abracadabra je suis le Mage Joueur" + compteurJoueur + " , niveau " + getNiveau() + ", vitalité " + getVie() + ", force " + getForce()
                + ", agilité " + getAgilite() + ", intelligence " + getIntelligence() + " !");
    }

    public void infoChoixAttaqueJoueur(int compteurJoueur) {
        System.out.println(getNom1() + "Joueur " + compteurJoueur + " vie (" + getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
    }

    @Override
    public int attackBasique(){
        return getIntelligence();
    }

    @Override
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

    @Override
    public String getCoupBasique() {
        return coupBasique;
    }

    @Override
    public String getCoupSpecial() {
        return couSpecial;
    }
}
