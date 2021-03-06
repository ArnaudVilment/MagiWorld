package com.vilment.magiworld.personnage;

public abstract class Personnage {

    private String nom1;
    private String nom;
    private int typePersonnage;
    private int niveau;
    private int vie;
    private int force;
    private int agilite;
    private int intelligence;

    public Personnage() {};

    public Personnage(String nom1, String nom, int typePersonnage, int niveau,int force, int agilite, int intelligence) {

        this.nom1 = nom1;
        this.nom = nom;
        this.typePersonnage = typePersonnage;
        this.niveau = niveau;
        this.vie = niveau * 5;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
    }

    public abstract void infoTypeJoueur(int compteurJoueur);
    public abstract void infoChoixAttaqueJoueur(int compteurJoueur);

    public abstract int attackBasique();
    public abstract int attackSpecial();
    public abstract String getCoupBasique();
    public abstract String getCoupSpecial();

    public int getNiveau() {
        return niveau;
    }

    public int getForce() {
        return force;
    }

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getTypePersonnage() {
        return typePersonnage;
    }

    public String getNom() {
        return nom;
    }

    public String getNom1() {
        return nom1;
    }

}
