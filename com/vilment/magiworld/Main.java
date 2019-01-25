package com.vilment.magiworld;

import com.vilment.magiworld.guerrier.Mage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean finDuJeu = true;
        Scanner sc = new Scanner(System.in);
        int compteurJoueur = 1;
        int attaque = 0;

        Mage joueur1 = new Mage();
        Mage joueur2 = new Mage();

        for(int i = 1; i <= 2; i++) {
            int choixPersonnage = 0;
            int niveau = 0;
            int force = 0;
            int agilite = 0;
            int intelligence = 0;

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

            if(choixPersonnage == 3 && i == 1) {
                joueur1 = new Mage(niveau, force, agilite, intelligence);
                compteurJoueur = 1;
            }
            if(choixPersonnage == 3 && i == 2) {
                joueur2 = new Mage(niveau, force, agilite, intelligence);
                compteurJoueur = 2;
            }

            if(compteurJoueur == 1) {
                System.out.println("Je suis le joureur" + compteurJoueur + ", niveau " + joueur1.getNiveau() + ", vitalité " + joueur1.getVie() + ", force " + joueur1.getForce()
                        + ",agilité " + joueur1.getAgilite() + ", intelligence " + joueur1.getIntelligence());
            } else {
                System.out.println("Je suis le joureur" + compteurJoueur + ", niveau " + joueur2.getNiveau() + ", vitalité " + joueur2.getVie() + ", force " + joueur2.getForce()
                        + ",agilité " + joueur2.getAgilite() + ", intelligence " + joueur2.getIntelligence());
            }
            compteurJoueur = 1;
        }

        do {

            if(compteurJoueur == 1) {

                System.out.println("Joueur1 vie " + joueur1.getVie() + " choix attague ?");
                attaque = sc.nextInt();
                System.out.println("Joueur1 inflige " + joueur1.coupBasique());
                joueur2.setVie(joueur2.getVie() - joueur1.coupBasique());
                System.out.println("Joueur2 perd " + joueur1.coupBasique() + " de vie, " + "vie " + joueur2.getVie());
                compteurJoueur = 2;
            } else {

                System.out.println("Joueur2 vie " + joueur2.getVie() + " choix attague ?");
                attaque = sc.nextInt();
                System.out.println("Joueur2 inflige " + joueur2.coupBasique());
                joueur1.setVie(joueur1.getVie() - joueur2.coupBasique());
                System.out.println("Joueur1 perd " + joueur2.coupBasique() + " de vie, " + "vie " + joueur1.getVie());
                compteurJoueur = 1;
            }

            if(joueur1.getVie() <= 0 || joueur2.getVie() <= 0) {
                finDuJeu = false;
                System.out.println("Fin du jeu!");
            }

        } while(finDuJeu);

        if(joueur1.getVie() <= 0) {
            System.out.println("Joueur1 perdu");
        } else {
            System.out.println("Joueur2 perdu");
        }
    }
}
