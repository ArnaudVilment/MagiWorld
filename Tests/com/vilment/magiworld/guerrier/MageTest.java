package com.vilment.magiworld.guerrier;

import com.vilment.magiworld.personnage.Personnage;
import com.vilment.magiworld.personnage.impl.Mage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class MageTest extends Personnage {

    @Test
    public void attackBasiqueTest() {
        Mage joueur = new Mage("joueur1", "joueur1", 1, 20, 0, 0, 20);
        Assertions.assertEquals(joueur.attackBasique(), joueur.getIntelligence());
    }

    @Test
    public void attackSpecialTest() {
        Mage joueur = new Mage("joueur1", "joueur1", 1, 20, 0, 0, 20);
        int vieDepart = joueur.getVie();
        Assertions.assertEquals(joueur.attackSpecial(),   0);
        joueur.setVie(50);
        Assertions.assertEquals(joueur.attackSpecial(),   joueur.getIntelligence() * 2);
        Assertions.assertEquals(joueur.getVie(),   90);
        joueur.attackSpecial();
        Assertions.assertEquals(joueur.getVie(),   vieDepart);
    }

    @Test
    public void getCoupBasiqueTest() {
        Mage joueur = new Mage("joueur1", "joueur1", 1, 20, 0, 0, 20);
        Assertions.assertEquals(joueur.getCoupBasique(),   "Boule de Feu");
    }

    @Test
    public void getCoupSpecialTest() {
        Mage joueur = new Mage("joueur1", "joueur1", 1, 20, 0, 0, 20);
        Assertions.assertEquals(joueur.getCoupSpecial(),   "Soin");
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