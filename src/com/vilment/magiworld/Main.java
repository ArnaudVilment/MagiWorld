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
        Personnage joueur1 = null;
        Personnage joueur2 = null;

        for(int i = 1; i <= 2; i++) {

            choixPersonnage = testEntreeClavierEntierEtControl("Création du personnage du joueur " + compteurJoueur + "-Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mâge)", sc, "personnage");

            do {
                niveau = testEntreeClavierEntierEtControl("Niveau du personnage ?", sc, "competence");
                force = testEntreeClavierEntierEtControl("Force du personnage ?", sc, "competence");
                agilite = testEntreeClavierEntierEtControl("Agilité du personnage ?", sc, "competence");
                intelligence = testEntreeClavierEntierEtControl("Intelligence du personnage ?", sc, "competence");

            } while(!testDonnee(niveau, force, agilite, intelligence));

            switch (choixPersonnage) {

                case 1:
                    if (compteurJoueur == 1) {
                        joueur1 = new Guerrier("guerrier", "joueur " + i, choixPersonnage, niveau, force, agilite, intelligence);
                    } else {
                        joueur2 = new Guerrier("guerrier", "joueur " + i, choixPersonnage, niveau, force, agilite, intelligence);
                    }
                    break;

                case 2:
                    if (compteurJoueur == 1) {
                        joueur1 = new Rodeur("Rodeur", "joueur " + i, choixPersonnage, niveau, force, agilite, intelligence);
                    } else {
                        joueur2 = new Rodeur("Rodeur", "joueur " + i, choixPersonnage, niveau, force, agilite, intelligence);
                    }
                    break;

                case 3:
                    if (compteurJoueur == 1) {
                        joueur1 = new Mage("Mage", "joueur " + i, choixPersonnage, niveau, force, agilite, intelligence);
                    } else {
                        joueur2 = new Mage("Mage", "joueur " + i, choixPersonnage, niveau, force, agilite, intelligence);
                    }
                    break;
            }
            if (choixPersonnage == 1) {
                if(compteurJoueur == 1)
                    joueur1.infoTypeJoueur(compteurJoueur);
                else
                    joueur2.infoTypeJoueur(compteurJoueur);
            } else if(choixPersonnage == 2) {
                if(compteurJoueur == 1)
                    joueur1.infoTypeJoueur(compteurJoueur);
                else
                    joueur2.infoTypeJoueur(compteurJoueur);
            } else {
                if(compteurJoueur == 1)
                    joueur1.infoTypeJoueur(compteurJoueur);
                else
                    joueur2.infoTypeJoueur(compteurJoueur);
            }
        }
        compteurJoueur = 1;

        // Boucle du jeu
        do {
            if(compteurJoueur == 1) {

                joueur1.infoChoixAttaqueJoueur(1);
                attaque = testEntreeClavierEntierEtControl("", sc, "attaque");

                if(attaque == 1) {
                    attaque1(joueur1, joueur2);
                } else {
                    attaque2(joueur1, joueur2);
                }
                compteurJoueur = 2;

            } else {

                joueur2.infoChoixAttaqueJoueur(2);
                attaque = testEntreeClavierEntierEtControl("", sc, "attaque");

                if(attaque == 1) {
                    attaque1(joueur2, joueur1);
                } else {
                    attaque2(joueur2, joueur1);
                }
                compteurJoueur = 1;
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

    public static int testEntreeClavierEntierEtControl(String chaine, Scanner sc, String choix) {
        boolean entierCorrect = false;
        int entreClavier = 0;
        do {
            if(!chaine.isEmpty()) {
                String[] tString = chaine.split("-");
                System.out.println(tString[0]);
                if (tString.length > 1)
                    System.out.println(tString[1]);
            }
            try{
                entreClavier = testControleSaisiEntier(sc.next());
                if(choix == "personnage")
                    entierCorrect = testChoixPersonnage(entreClavier);
                else if(choix == "competence")
                    entierCorrect = testChoixCompetences(entreClavier);
                else
                    entierCorrect = testChoixAttaque(entreClavier);
            } catch (ExceptionSaisie e) {
                entierCorrect = false;
                System.out.println(e.getMessage());
            }
        } while (!entierCorrect);
        return entreClavier;
    }

    public static int testControleSaisiEntier(String s) throws ExceptionSaisie {
        try {
            return Integer.parseInt(s);
        }catch (Exception e){
            throw new ExceptionSaisie("Veuillez entrer nombre entier !");
        }
    }

    public static boolean testChoixPersonnage(int choixPersonnage) throws ExceptionSaisie {
        if(choixPersonnage >= 1 && choixPersonnage <= 3) {
            return true;
        } else {
            throw new ExceptionSaisie("Veuillez entrer nombre compris entre 1 et 3 !");
        }
    }

    public static boolean testChoixCompetences(int competence) throws ExceptionSaisie {
        if(competence >= 0 && competence <= 100) {
            return true;
        } else {
            throw new ExceptionSaisie("Veuillez entrer nombre compris entre 0 et 100 !");
        }
    }

    public static boolean testChoixAttaque(int choixAttaque) throws ExceptionSaisie {
        if(choixAttaque >= 1 && choixAttaque <= 2) {
            return true;
        } else {
            throw new ExceptionSaisie("Veuillez entrer nombre compris entre 1 et 2 !");
        }
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

    public static void testJoueurMort(Personnage joueur) {
        if(joueur.getVie() <= 0)
            System.out.println(joueur.getNom() + " est mort");
    }

    public static void attaque1(Personnage joueur1, Personnage joueur2) {

        System.out.println(joueur1.getNom1() + ", " + joueur1.getNom() + " utilise " + joueur1.getCoupBasique() + " et inflige " + joueur1.attackBasique() + " dommages.");
        joueur2.setVie(joueur2.getVie() - joueur1.attackBasique());
        System.out.println(joueur2.getNom1() + ", " + joueur2.getNom() + " perd " + joueur1.attackBasique() + " points de vie");
        testJoueurMort(joueur2);
    }

    public static void attaque2(Personnage joueur1, Personnage joueur2) {

        int pointAttackSpecial = joueur1.attackSpecial();
        switch (joueur1.getTypePersonnage()) {
            case 1:
                System.out.println(joueur1.getNom1() + ", " + joueur1.getNom() + " utilise " + joueur1.getCoupSpecial() + " et inflige " + pointAttackSpecial + " dommages.");
                joueur2.setVie(joueur2.getVie() - pointAttackSpecial);
                System.out.println(joueur2.getNom1() + ", " + joueur2.getNom() + " perd " + pointAttackSpecial + " points de vie");
                testJoueurMort(joueur2);
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
