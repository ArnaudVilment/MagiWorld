package com.vilment.magiworld;

import java.util.Scanner;

import com.vilment.magiworld.exception.ExceptionSaisie;
import com.vilment.magiworld.personnage.Personnage;
import com.vilment.magiworld.personnage.impl.Guerrier;
import com.vilment.magiworld.personnage.impl.Mage;
import com.vilment.magiworld.personnage.impl.Rodeur;

public class Main {

    public static void main(String[] args) {

        boolean finDuJeu = true;
        Scanner sc = new Scanner(System.in);
        int compteurJoueur = 1;
        int attaque = 0;
        int choixPersonnage = 0;
        int niveau = 0;
        int force = 0;
        int agilite = 0;
        int intelligence = 0;
        boolean entierCorrect = false;

        Personnage joueur1 = null;
        Personnage joueur2 = null;

        for(int i = 1; i <= 2; i++) {

            do {
            	 System.out.println("Création du personnage du joueur " + i);
                 System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mâge)");

                try{
                    choixPersonnage = testControleSaisiEntier(sc.next());
                    entierCorrect = true;

                } catch (ExceptionSaisie e) {
                    entierCorrect = false;
                    System.out.println(e.getMessage());

                }
                if(entierCorrect) {
                    try {
                        choixPersonnage = testChoixPersonnage(choixPersonnage);
                        entierCorrect = true;

                    } catch (ExceptionSaisie e) {
                        entierCorrect = false;
                        System.out.println(e.getMessage());
                    }
                }
            } while (!entierCorrect);


            System.out.println("Niveau du personnage ?");
            niveau = Math.abs(sc.nextInt());

            System.out.println("Force du personnage ?");
            force = Math.abs(sc.nextInt());

            System.out.println("Agilité du personnage ?");
            agilite = Math.abs(sc.nextInt());

            System.out.println("Intelligence du personnage ?");
            intelligence = Math.abs(sc.nextInt());

            if (!testDonnee(niveau, force, agilite, intelligence)) {
                i = 0;
            } else {

                switch (choixPersonnage) {

                    case 1:
                        if (i == 1) {
                            joueur1 = new Guerrier("guerrier", "joueur " + i, choixPersonnage, niveau, force, agilite, intelligence);
                        } else {
                            joueur2 = new Guerrier("guerrier", "joueur " + i, choixPersonnage, niveau, force, agilite, intelligence);
                        }
                        break;

                    case 2:
                        if (i == 1) {
                            joueur1 = new Rodeur("Rodeur", "joueur " + i, choixPersonnage, niveau, force, agilite, intelligence);
                        } else {
                            joueur2 = new Rodeur("Rodeur", "joueur " + i, choixPersonnage, niveau, force, agilite, intelligence);
                        }
                        break;

                    case 3:
                        if (i == 1) {
                            joueur1 = new Mage("Mage", "joueur " + i, choixPersonnage, niveau, force, agilite, intelligence);
                        } else {
                            joueur2 = new Mage("Mage", "joueur " + i, choixPersonnage, niveau, force, agilite, intelligence);
                        }
                        break;

                }
                String chaine = "";
                if (choixPersonnage == 1) {
                    chaine = "Woarg je suis le Guerrier Joueur" + compteurJoueur;

                } else if (choixPersonnage == 2) {
                    chaine = "Rrrrr je suis le Rôdeur Joueur" + compteurJoueur;

                } else {
                    chaine = "Abracadabra je suis le Mage Joueur" + compteurJoueur;
                }
                if (compteurJoueur == 1) {
                    System.out.println(chaine + ", niveau " + joueur1.getNiveau() + ", vitalité " + joueur1.getVie() + ", force " + joueur1.getForce()
                            + ", agilité " + joueur1.getAgilite() + ", intelligence " + joueur1.getIntelligence() + " !");
                    compteurJoueur = 2;
                } else {
                    System.out.println(chaine + ", niveau " + joueur2.getNiveau() + ", vitalité " + joueur2.getVie() + ", force " + joueur2.getForce()
                            + ", agilité " + joueur2.getAgilite() + ", intelligence " + joueur2.getIntelligence() + " !");
                }
            }
        }

        compteurJoueur = 1;

        // Boucle du jeu
        do {

            if(compteurJoueur == 1) {

                System.out.println(joueur1.getNom1() + "Joueur 1 vie (" + joueur1.getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
                attaque = sc.nextInt();

                if(testAttaque(attaque)) {

                    if(attaque == 1) {
                        attaque1(joueur1, joueur2);
                    } else {
                        attaque2(joueur1, joueur2);
                    }
                    compteurJoueur = 2;

                } else {
                    compteurJoueur = 1;
                }

            } else {

                System.out.println(joueur2.getNom1() + "Joueur 2 vie (" + joueur2.getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
                attaque = sc.nextInt();

                if(testAttaque(attaque)) {

                    if(attaque == 1) {
                        attaque1(joueur2, joueur1);
                    } else {
                        attaque2(joueur2, joueur1);
                    }
                    compteurJoueur = 1;

                } else {
                    compteurJoueur = 2;
                }
            }

            if(joueur1.getVie() <= 0 || joueur2.getVie() <= 0) {
                finDuJeu = false;
            }

        } while(finDuJeu);

        // Fin du jeu
        if(joueur1.getVie() <= 0) {
            System.out.println("Joueur 1 a perdu !");
        } else {
            System.out.println("Joueur 2 a perdu !");
        }
        
        sc.close();
    }

    public static int testControleSaisiEntier(String s) throws ExceptionSaisie {
        try {
            return Integer.parseInt(s);
        }catch (Exception e){
            throw new ExceptionSaisie("Veuillez entrer nombre !");
        }
    }

    public static int testChoixPersonnage(int choixPersonnage) throws ExceptionSaisie {
        if(choixPersonnage >= 1 && choixPersonnage <= 3) {
            return choixPersonnage;
        } else {
            throw new ExceptionSaisie("Veuillez entrer nombre compris entre 1 et 3 !");
        }
    }

    public static int testChoixAttaque(int choixAttaque) throws ExceptionSaisie {
        if(choixAttaque >= 1 && choixAttaque <= 2) {
            return choixAttaque;
        } else {
            throw new ExceptionSaisie("Veuillez entrer nombre compris entre 1 et 2 !");
        }
    }

    public static boolean testAttaque(int i) {
        if(i >= 1 && i <= 2)
            return true;
        else
            return false;
    }

    public static boolean testDonnee(int niveau, int force, int agilite, int intelligence) {

        boolean test = true;
        if(niveau > 100) {
            System.out.println("Le niveau ne doit pas être supérieur à 100 !");
            test = false;
        } else if(force > 100) {
            System.out.println("La force ne doit pas être supérieur à 100 !");
            test = false;
        } else if(agilite > 100) {
            System.out.println("L' agilité ne doit pas être supérieur à 100 !");
            test = false;
        } else if(intelligence > 100) {
            System.out.println("L' intelligence ne doit pas être supérieur à 100 !");
            test = false;
        } else if(force + agilite + intelligence != niveau) {
            System.out.println("La force + agilité + intelligence doit être égal au niveau du joueur !");
            test = false;
        }
        return test;
    }

    public static void attaque1(Personnage joueur1, Personnage joueur2) {

        System.out.println(joueur1.getNom1() + ", " + joueur1.getNom() + " utilise " + joueur1.getCoupBasique() + " et inflige " + joueur1.attackBasique() + " dommages.");
        joueur2.setVie(joueur2.getVie() - joueur1.attackBasique());
        System.out.println(joueur2.getNom1() + ", " + joueur2.getNom() + " perd " + joueur1.attackBasique() + " points de vie");
        System.out.println(joueur2.getNom() + " est mort");
    }

    public static void attaque2(Personnage joueur1, Personnage joueur2) {

        int pointAttackSpecial = joueur1.attackSpecial();
        switch (joueur1.getTypePersonnage()) {
            case 1:
                System.out.println(joueur1.getNom1() + ", " + joueur1.getNom() + " utilise " + joueur1.getCoupSpecial() + " et inflige " + pointAttackSpecial + " dommages.");
                joueur2.setVie(joueur2.getVie() - pointAttackSpecial);
                System.out.println(joueur2.getNom1() + ", " + joueur2.getNom() + " perd " + pointAttackSpecial + " points de vie");
                System.out.println(joueur2.getNom() + " est mort");
                System.out.println(joueur1.getNom1() + ", " + joueur1.getNom() + " perd " + ((Guerrier) joueur1).getViePerdu() + " points de vie");
                break;
            case 2:
                System.out.println(joueur1.getNom1() + ", " + joueur1.getNom() + " utilise " + joueur1.getCoupSpecial() + " et gagne " + pointAttackSpecial + " d'agilité.");
                break;
            case 3:
                System.out.println(joueur1.getNom1() + ", " + joueur1.getNom() + " utilise " + joueur1.getCoupSpecial() + " et gagne " + pointAttackSpecial + " en vitalité.");
                break;
        }
    }
}
