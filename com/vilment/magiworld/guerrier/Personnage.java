package com.vilment.magiworld.guerrier;

public abstract class Personnage {

    private String nom;
    private int typePersonnage;
    private int niveau;
    private int vie;
    private int force;
    private int agilite;
    private int intelligence;

    public Personnage() {

    }

    public Personnage(String nom, int typePersonnage, int niveau,int force, int agilite, int intelligence) {
        this.nom = nom;
        this.typePersonnage = typePersonnage;
        this.niveau = niveau;
        this.vie = niveau * 5;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
    }

    public abstract int attackBasique();
    public abstract int attackSpecial();
    public abstract String getCoupBasique();
    public abstract String getCouSpecial();

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
}
