package com.vilment.magiworld.guerrier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuerrierTest extends Personnage {

    @Test
    public void attackBasiqueTest() {
        Guerrier joueur = new Guerrier("joueur1", "joueur1", 1, 20, 20, 0, 0);
        Assertions.assertEquals(joueur.attackBasique(), joueur.getForce());
    }

    @Test
    public void attackSpecialTest() {
        Guerrier joueur = new Guerrier("joueur1", "joueur1", 1, 20, 20, 0, 0);
        int vieDepart = joueur.getVie();
        Assertions.assertEquals(joueur.attackSpecial(),   joueur.getForce() * 2);
        Assertions.assertEquals(joueur.getVie(), vieDepart - joueur.getViePerdu());
    }

    @Test
    public void getCoupBasiqueTest() {
        Guerrier joueur = new Guerrier("joueur1", "joueur1", 1, 20, 20, 0, 0);
        Assertions.assertEquals(joueur.getCoupBasique(),   "Coup d'Epée");
    }

    @Test
    public void getCoupSpecialTest() {
        Guerrier joueur = new Guerrier("joueur1", "joueur1", 1, 20, 20, 0, 0);
        Assertions.assertEquals(joueur.getCoupSpecial(),   "Coup de Rage");
    }

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