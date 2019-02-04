package com.vilment.magiworld;

import com.vilment.magiworld.guerrier.Guerrier;
import com.vilment.magiworld.guerrier.Mage;
import com.vilment.magiworld.guerrier.Personnage;
import com.vilment.magiworld.guerrier.Rodeur;

import java.util.Scanner;

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

        Personnage joueur1 = null;
        Personnage joueur2 = null;

        for(int i = 1; i <= 2; i++) {

            System.out.println("Création du personnage du joueur " + i);
            System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rodeur : 2, Mâge : 3");
            choixPersonnage = sc.nextInt();

            if(choixPersonnage >= 1 && choixPersonnage <= 3) {

                System.out.println("Niveau du personnage ?");
                niveau = sc.nextInt();

                System.out.println("Force du personnage ?");
                force = sc.nextInt();

                System.out.println("Agilité du personnage ?");
                agilite = sc.nextInt();

                System.out.println("Intelligence du personnage ?");
                intelligence = sc.nextInt();

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
                    } else {
                        System.out.println(chaine + ", niveau " + joueur2.getNiveau() + ", vitalité " + joueur2.getVie() + ", force " + joueur2.getForce()
                                + ", agilité " + joueur2.getAgilite() + ", intelligence " + joueur2.getIntelligence() + " !");
                    }
                }
            } else if(joueur1 == null){
                System.out.println("Le choix du personnage doit être compris entre 1 et 3 uniquement !");
                i = 0;
            } else {
                i = 1;
            }
        }

        compteurJoueur = 1;

        // Boucle du jeu
        do {

            if(compteurJoueur == 1) {

                System.out.println(joueur1.getNom1() + "Joueur 1 vie (" + joueur1.getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
                attaque = sc.nextInt();

                if(testAttaque(attaque)) {

                    attaque(joueur1, joueur2, attaque);
                    compteurJoueur = 2;

                } else {
                    compteurJoueur = 1;
                }

            } else {

                System.out.println(joueur2.getNom1() + "Joueur 2 vie (" + joueur2.getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
                attaque = sc.nextInt();

                if(testAttaque(attaque)) {

                    attaque(joueur2, joueur1, attaque);
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

    }

    public static boolean testAttaque(int attaque) {
        if(attaque >= 1 && attaque <= 2) {
            return true;
        } else {
            System.out.println("L'action ne peux être que 1 ou 2 !");
            return false;
        }
    }

    public static boolean testDonnee(int niveau, int force, int agilite, int intelligence) {

        boolean test = true;
        if(niveau > 100) {
            System.out.println("Le niveau ne doit pas être supérieur à 100 !");
            test = false;
        }
        if(force > 100) {
            System.out.println("La force ne doit pas être supérieur à 100 !");
            test = false;
        }
        if(agilite > 100) {
            System.out.println("L' agilité ne doit pas être supérieur à 100 !");
            test = false;
        }
        if(intelligence > 100) {
            System.out.println("L' intelligence ne doit pas être supérieur à 100 !");
            test = false;
        }
        if(force + agilite + intelligence > niveau || force + agilite + intelligence > 100) {
            System.out.println("La force + agilité + intelligence doit être égal au niveau du joueur !");
            test = false;
        }
        return test;
    }

    public static void joueurMort(Personnage joueur) {

        if(joueur.getVie() <= 0) {
            System.out.println(joueur.getNom() + " est mort");
        }
    }

    public static void attaque(Personnage joueur1, Personnage joueur2 , int attaque) {

        if (attaque == 1) {
            System.out.println(joueur1.getNom1() + ", " + joueur1.getNom() + " utilise " + joueur1.getCoupBasique() + " et inflige " + joueur1.attackBasique() + " dommages.");
            joueur2.setVie(joueur2.getVie() - joueur1.attackBasique());
            System.out.println(joueur2.getNom1() + ", " + joueur2.getNom() + " perd " + joueur1.attackBasique() + " points de vie");
            joueurMort(joueur2);

        } else {

            switch (joueur1.getTypePersonnage()) {


                case 1:
                    int pointAttackSpecial = joueur1.attackSpecial();
                    System.out.println(joueur1.getNom1() + ", " + joueur1.getNom() + " utilise " + joueur1.getCouSpecial() + " et inflige " + pointAttackSpecial + " dommages.");
                    joueur2.setVie(joueur2.getVie() - pointAttackSpecial);
                    System.out.println(joueur2.getNom1() + ", " + joueur2.getNom() + " perd " + pointAttackSpecial + " points de vie");
                    joueurMort(joueur2);
                    System.out.println(joueur1.getNom1() + ", " + joueur1.getNom() + " perd " + ((Guerrier) joueur1).getViePerdu() + " points de vie");
                    break;

                case 2:
                    System.out.println(joueur1.getNom1() + ", " + joueur1.getNom() + " utilise " + joueur1.getCouSpecial() + " et gagne " + joueur1.attackSpecial() + " d'agilité.");
                    break;

                case 3:
                    System.out.println(joueur1.getNom1() + ", " + joueur1.getNom() + " utilise " + joueur1.getCouSpecial() + " et gagne " + joueur1.attackSpecial() + " en vitalité.");
                    break;

            }
        }
    }
}
