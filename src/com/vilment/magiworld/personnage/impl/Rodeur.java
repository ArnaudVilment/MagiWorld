package com.vilment.magiworld.personnage.impl;

import com.vilment.magiworld.personnage.Personnage;

public class Rodeur extends Personnage {

    private String coupBasique = "Tir à l'Arc";
    private String couSpecial = "Concentration";

    public Rodeur(String nom1, String nom, int typePersonnage, int niveau, int force, int agilite, int intelligence) {

        super(nom1, nom, typePersonnage, niveau, force, agilite, intelligence);
    }

    public void infoTypeJoueur(int compteurJoueur) {
        System.out.println("Rrrrr je suis le Rôdeur Joueur" + compteurJoueur + " , niveau " + getNiveau() + ", vitalité " + getVie() + ", force " + getForce()
                + ", agilité " + getAgilite() + ", intelligence " + getIntelligence() + " !");
    }

    public void infoChoixAttaqueJoueur(int compteurJoueur) {
        System.out.println(getNom1() + "Joueur " + compteurJoueur + " vie (" + getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
    }

    @Override
    public int attackBasique(){
        return getAgilite();
    }

    @Override
    public int attackSpecial() {
        int agiliteDepart = getAgilite();
        int agiliteGagne = getNiveau() / 2;
        setAgilite(agiliteDepart + agiliteGagne);

        return agiliteGagne;
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
