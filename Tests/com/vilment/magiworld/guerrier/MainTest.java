package com.vilment.magiworld.guerrier;

import com.vilment.magiworld.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    /*
     * Tests de la méthode testDonnee
     *
     */

    @Test
    public void testDonneeNiveauKO() {
        Assertions.assertFalse(Main.testDonnee(120, 0, 0, 0));
    }

    @Test
    public void testDonneeForceKO() {
        Assertions.assertFalse(Main.testDonnee(0, 120, 0, 0));
    }

    @Test
    public void testDonneeAgiliteKO() {
        Assertions.assertFalse(Main.testDonnee(0, 0, 120, 0));
    }

    @Test
    public void testDonneeIntelligenceOK() {
        Assertions.assertFalse(Main.testDonnee(99, 0, 0, 120));
    }

    @Test
    public void testDonneeKO() {
        Assertions.assertFalse(Main.testDonnee(100, 0, 0, 0));
    }

    @Test
    public void testDonneeOK() {
        Assertions.assertTrue(Main.testDonnee(100, 50, 25, 25));
    }

    /*
     * Tests de la méthodes testAttaque
     *
     */
    @Test
    public void testAttaqueOK1() {
        Assertions.assertTrue(Main.testAttaque(1));
    }

    @Test
    public void testAttaqueOK2() {
        Assertions.assertTrue(Main.testAttaque(2));
    }

    @Test
    public void testAttaqueKO() {
        Assertions.assertFalse(Main.testAttaque(5));
    }
}
