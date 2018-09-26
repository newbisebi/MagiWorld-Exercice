package com.sma;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PartieTest extends Partie{

    /**
     * Pour permettre les tests du scanner, on remplace la méthode
     * qui interroge l'utilisateur par une méthode qui rentre directement les valeurs
     * @param joueur joueur
     * @return une map avec les paramètres
     */
    @Override
    protected Map<String, Integer> askChoixPersonnage(Joueur joueur) {
        Map<String, Integer> params = new HashMap<>();
        params.put("perso", 3);
        params.put("niveau", 50);
        params.put("force", 18);
        params.put("agilite", 12);
        params.put("intelligence", 20);
        return params;
    }

    @Test
    public void Given_characteristicsMap_When_createPerso_Then_createCorrectPerso(){
        Partie partie = new PartieTest();
        Joueur joueur1 = new Joueur(1);
        Personnage perso = partie.createPersonnage(joueur1);

        assertTrue(perso instanceof Mage);
        assertEquals(250, perso.getVie());
        assertEquals(50, perso.getNiveau());
        assertEquals(18, perso.getForce());
        assertEquals(12, perso.getAgilite());
        assertEquals(20, perso.getIntelligence());
    }

}