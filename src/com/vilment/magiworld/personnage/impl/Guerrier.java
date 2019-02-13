package com.vilment.magiworld.personnage.impl;

import com.vilment.magiworld.personnage.Personnage;

/**
 * @author Arnaud Vilment
 * 
 *
 */

public class Guerrier extends Personnage {

    private String coupBasique = "Coup d'Epée";
    private String couSpecial = "Coup de Rage";
    private int viePerdu;

    public Guerrier(String nom1, String nom, int typePersonnage, int niveau, int force, int agilite, int intelligence) {

        super(nom1, nom, typePersonnage, niveau, force, agilite, intelligence);
    }

    public void infoTypeJoueur(int compteurJoueur) {
        System.out.println("Woarg je suis le Guerrier Joueur" + compteurJoueur + " , niveau " + getNiveau() + ", vitalité " + getVie() + ", force " + getForce()
                + ", agilité " + getAgilite() + ", intelligence " + getIntelligence() + " !");
    }

    public void infoChoixAttaqueJoueur(int compteurJoueur) {
        System.out.println(getNom1() + "Joueur " + compteurJoueur + " vie (" + getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
    }

    @Override
    public int attackBasique(){
        return getForce();
    }

    @Override
    public int attackSpecial() {
        viePerdu = getForce() / 2;
        setVie(getVie() - viePerdu);
        return getForce() * 2;
    }

    /* (non-Javadoc)
     * @see com.vilment.magiworld.guerrier.Personnage#getCoupBasique()
     */
    @Override
    public String getCoupBasique() {
        return coupBasique;
    }

    @Override
    public String getCoupSpecial() {
        return couSpecial;
    }

    public int getViePerdu() {
        return viePerdu;
    }
}
