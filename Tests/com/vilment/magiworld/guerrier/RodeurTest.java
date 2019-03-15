package com.vilment.magiworld.guerrier;

import com.vilment.magiworld.personnage.Personnage;
import com.vilment.magiworld.personnage.impl.Rodeur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class RodeurTest extends Personnage {

    @Test
    public void attackBasiqueTest() {
        Rodeur joueur = new Rodeur("joueur1", "joueur1", 1, 20, 0, 20, 0);
        Assertions.assertEquals(joueur.attackBasique(), joueur.getAgilite());
    }

    @Test
    public void attackSpecialTest() {
        Rodeur joueur = new Rodeur("joueur1", "joueur1", 1, 20, 0, 20, 0);
        int agiliteDepart = joueur.getAgilite();
        Assertions.assertEquals(joueur.attackSpecial(),   joueur.getNiveau() / 2);
        Assertions.assertEquals(joueur.getAgilite(), agiliteDepart + joueur.getNiveau() / 2);
    }

    @Test
    public void getCoupBasiqueTest() {
        Rodeur joueur = new Rodeur("joueur1", "joueur1", 1, 20, 0, 20, 0);
        Assertions.assertEquals(joueur.getCoupBasique(),   "Tir à l'Arc");
    }

    @Test
    public void getCoupSpecialTest() {
        Rodeur joueur = new Rodeur("joueur1", "joueur1", 1, 20, 0, 20, 0);
        Assertions.assertEquals(joueur.getCoupSpecial(),   "Concentration");
    }

    public abstract void info(int compteurJoueur);

    @Override
    public int attackBasique() {
        return 0;
    }

    @Override
    public int attackSpecial() {
        return 0;
    }

    @Override
    public String getCoupBasique() {
        return null;
    }

    @Override
    public String getCoupSpecial() {
        return null;
    }
}