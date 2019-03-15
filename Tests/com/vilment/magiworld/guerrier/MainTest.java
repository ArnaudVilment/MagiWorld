package com.vilment.magiworld.guerrier;

import com.vilment.magiworld.Main;
import com.vilment.magiworld.exception.ExceptionSaisie;
import org.junit.jupiter.api.*;

public class MainTest {

    @BeforeEach
    public void avant(){
        System.out.println("avant le test :");
    }


    @AfterEach
    public void apres(){
        System.out.println("Après le test :");
    }

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
        //Assertions.assertTrue(Main.testChoixAttaque(1));
    }

    @Test
    public void testAttaqueOK2() {
        //Assertions.assertTrue(Main.testChoixAttaque(2));
    }

    @Test
    public void testAttaqueKO() {
        //Assertions.assertFalse(Main.testChoixAttaque(5));
    }

    @Test
    public void controleKoExceptionSaisi(){
            Assertions.assertThrows(ExceptionSaisie.class, () -> Main.testControleSaisiEntier("m"));
    }

    @Test
    public void controleOk() throws ExceptionSaisie{
        Assertions.assertEquals(1, Main.testControleSaisiEntier("1"));
    }
}
