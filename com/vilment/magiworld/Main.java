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

            System.out.println("Niveau du personnage ?");
            niveau = sc.nextInt();

            System.out.println("Force du personnage ?");
            force = sc.nextInt();

            System.out.println("Agilité du personnage ?");
            agilite = sc.nextInt();

            System.out.println("Intelligence du personnage ?");
            intelligence = sc.nextInt();

            switch (choixPersonnage) {

                case 1 : if(i == 1) {
                            joueur1 = new Guerrier("joueur" + i, choixPersonnage, niveau, force, agilite, intelligence);
                        } else {
                            joueur2 = new Guerrier("joueur" + i, choixPersonnage, niveau, force, agilite, intelligence);
                        }
                        break;

                case 2 : if(i == 1) {
                            joueur1 = new Rodeur("joueur" + i, choixPersonnage, niveau, force, agilite, intelligence);
                        } else {
                            joueur2 = new Rodeur("joueur" + i, choixPersonnage, niveau, force, agilite, intelligence);
                        }
                    break;

                case 3 : if(i == 1) {
                            joueur1 = new Mage("joueur" + i, choixPersonnage, niveau, force, agilite, intelligence);
                        } else {
                            joueur2 = new Mage("joueur" + i, choixPersonnage, niveau, force, agilite, intelligence);
                        }
                        break;

            }
            String chaine = "";
            if(choixPersonnage == 1) {
                chaine = "Woarg je suis le Guerrier Joueur" + compteurJoueur;

            } else if(choixPersonnage == 2) {
                chaine = "Rrrrr je suis le Rôdeur Joueur" + compteurJoueur;

            } else {
                chaine = "Abracadabra je suis le Mage Joueur" + compteurJoueur;
            }
            if(compteurJoueur == 1) {
                System.out.println(chaine + ", niveau " + joueur1.getNiveau() + ", vitalité " + joueur1.getVie() + ", force " + joueur1.getForce()
                        + ", agilité " + joueur1.getAgilite() + ", intelligence " + joueur1.getIntelligence() + " !");
            } else {
                System.out.println(chaine + ", niveau " + joueur2.getNiveau() + ", vitalité " + joueur2.getVie() + ", force " + joueur2.getForce()
                        + ", agilité " + joueur2.getAgilite() + ", intelligence " + joueur2.getIntelligence() + " !");
            }
        }

        compteurJoueur = 1;

        // Boucle du jeu
        do {

            if(compteurJoueur == 1) {

                System.out.println("Joueur1 vie (" + joueur1.getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
                attaque = sc.nextInt();

                attaque(joueur1, joueur2, attaque);

                compteurJoueur = 2;

            } else {

                System.out.println("Joueur2 vie (" + joueur2.getVie() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
                attaque = sc.nextInt();

                attaque(joueur2, joueur1, attaque);

                compteurJoueur = 1;
            }

            if(joueur1.getVie() <= 0 || joueur2.getVie() <= 0) {
                finDuJeu = false;
                System.out.println("Fin du jeu!");
            }

        } while(finDuJeu);

        // Fin du jeu
        if(joueur1.getVie() <= 0) {
            System.out.println("Joueur1 perdu");
        } else {
            System.out.println("Joueur2 perdu");
        }

    }

    public static void attaque(Personnage joueur1, Personnage joueur2 , int attaque) {

        if (attaque == 1) {
            System.out.println(joueur1.getNom() + " utilise " + joueur1.getCoupBasique() + " et inflige " + joueur1.attackBasique() + " dommages.");
            joueur2.setVie(joueur2.getVie() - joueur1.attackBasique());
            System.out.println(joueur2.getNom() + " perd " + joueur1.attackBasique() + " points de vie");

        } else {

            switch (joueur1.getTypePersonnage()) {


                case 1:
                    System.out.println(joueur1.getNom() + " utilise " + joueur1.getCouSpecial() + " et inflige " + joueur1.attackSpecial() + " dommages.");
                    joueur2.setVie(joueur2.getVie() - joueur1.attackSpecial());
                    System.out.println(joueur2.getNom() + " perd " + joueur1.attackSpecial() + " points de vie");
                    System.out.println(joueur1.getNom() + " perd " + ((Guerrier) joueur1).getViePerdu() + " points de vie");
                    break;

                case 2:
                    System.out.println(joueur1.getNom() + " utilise " + joueur1.getCouSpecial() + " et gagne " + joueur1.attackSpecial() + " d'agilité.");
                    break;

                case 3:
                    System.out.println(joueur1.getNom() + " utilise " + joueur1.getCouSpecial() + " et gagne " + joueur1.attackSpecial() + " en vitalité.");
                    break;

            }
        }
    }
}
