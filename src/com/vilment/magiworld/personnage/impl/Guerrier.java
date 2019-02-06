package com.vilment.magiworld.personnage.impl;

import com.vilment.magiworld.personnage.Personnage;

/**
 * @author Arnaud Vilment
 * 
 *
 */

public class Guerrier extends Personnage{

    private String coupBasique = "Coup d'Epée";
    private String couSpecial = "Coup de Rage";
    private int viePerdu;

    public Guerrier(String nom1, String nom, int typePersonnage, int niveau, int force, int agilite, int intelligence) {

        super(nom1, nom, typePersonnage, niveau, force, agilite, intelligence);
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
