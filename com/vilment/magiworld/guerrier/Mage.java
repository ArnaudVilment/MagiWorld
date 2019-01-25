package com.vilment.magiworld.guerrier;

public class Mage extends Personnage {

    private int coupBasique;
    private int coupSpecial;

    public Mage() {

    }
    public Mage(int niveau, int force, int agilite, int intelligence) {

        super(niveau, force, agilite, intelligence);
        this.coupBasique = intelligence;
        this.coupSpecial = intelligence * 2;
    }

    public int coupBasique() {
        return coupBasique;
    }

    public void setCoupSpecial() {
        setVie(getVie() + coupSpecial);
    }
}
