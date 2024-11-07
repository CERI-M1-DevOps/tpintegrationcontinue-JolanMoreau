package liste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class ListeSimpleTest {

    ListeSimple listeATester;

    @BeforeEach
    public void init() {
        listeATester = new ListeSimple();
    }

    @Test
     void listeConstruiteVide() {
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
     void ajoutAugmenteSize() {
        listeATester.ajout(1);
        assertEquals(1, listeATester.getSize());
    }

    @Test
     void ajoutChangeTete() {
        listeATester.ajout(1);
        Noeud teteApresPremierAjout = listeATester.tete;
        listeATester.ajout(1);
        assertNotNull(teteApresPremierAjout);
        assertNotSame(teteApresPremierAjout, listeATester.tete);
    }

    @Test
     void ajoutPlusieursFoisLeMeme() {
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.ajout(1);
        assertEquals(3, listeATester.getSize());
    }

    @Test
     void toStringDonneTousLesNoeuds() {
        System.out.println(listeATester);
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))", listeATester.toString());
    }

    @Test
     void modifiePremier() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifiePremier(2, 4);
        assertEquals( "ListeSimple(Noeud(3), Noeud(4), Noeud(1))",listeATester.toString());
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
    void modifieTous() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.modifieTous(1, 4);
        assertEquals("ListeSimple(Noeud(4), Noeud(4), Noeud(2), Noeud(4))",listeATester.toString());
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
     void supprimePremierListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
     void supprimePremierEnPremierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))",listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
     void supprimePremierEnPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(2);
        assertEquals("ListeSimple(Noeud(4), Noeud(3), Noeud(1))",listeATester.toString());
        assertEquals(3, listeATester.getSize());
    }

    @Test
     void supprimePremierEnDernierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(1);
        assertEquals("ListeSimple(Noeud(4), Noeud(3), Noeud(2))",listeATester.toString() );
        assertEquals(3, listeATester.getSize());
    }

    @Test
     void supprimeTousListeVide() {
        listeATester.supprimeTous(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
     void supprimeTousUneSeuleFoisAuDebut() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))",listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
     void supprimeTousUneSeuleFoisPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))",listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
     void supprimeTousPlusieursFois() {
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.supprimeTous(1);
        assertEquals( "ListeSimple(Noeud(2))",listeATester.toString());
        assertEquals(1, listeATester.getSize());
    }

    @Test
     void supprimeTousPlusieursFoisPositionQuelconque() {
        listeATester.ajout(3);
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))",listeATester.toString());
        assertEquals(2, listeATester.getSize());
    }

    @Test
     void avantDernierListeVide() {
        assertNull(listeATester.getAvantDernier());
    }

    @Test
     void avantDernierListeAUnElement() {
        listeATester.ajout(1);
        assertNull(listeATester.getAvantDernier());
    }

    @Test
     void avantDernierListeADeuxElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
     void avantDernierListeAPlusieursElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
      void inverserListeVide() {
        listeATester.inverser();
        assertNull(listeATester.tete);
    }

    @Test
     void inverserListeNbPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.inverser();
        assertEquals( "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4))",listeATester.toString());
    }

    @Test
     void inverserListeNbImPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.inverser();
        assertEquals( "ListeSimple(Noeud(1), Noeud(2), Noeud(3))",listeATester.toString());
    }

    @Test
     void echanger2NoeudsQuelconques() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(1);
        assertEquals( "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))",listeATester.toString());
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(1), Noeud(4), Noeud(3), Noeud(2), Noeud(5))",listeATester.toString());
    }

    @Test
     void echangerLePremierNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r1 = listeATester.tete;
        assertEquals( "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))",listeATester.toString());
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals( "ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))",listeATester.toString());
    }

    @Test
     void echangerLePremierEnSecondArgumentNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r2 = listeATester.tete;
        assertEquals("ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))",listeATester.toString());
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))",listeATester.toString());
    }

    @Test
    void ajoutUnSeulElement() {
        listeATester.ajout(42);
        assertNotNull(listeATester.tete);
        assertEquals(42, listeATester.tete.getElement());
    }

    @Test
    void modifiePremierElementNonExistant() {
        listeATester.ajout(1);
        listeATester.modifiePremier(999, 4); // élément inexistant
        assertEquals("ListeSimple(Noeud(1))", listeATester.toString());
    }

    @Test
    void supprimePremierNonExistant() {
        listeATester.ajout(1);
        listeATester.supprimePremier(999); // élément inexistant
        assertEquals(1, listeATester.getSize());
        assertEquals("ListeSimple(Noeud(1))", listeATester.toString());
    }

    void getAvantDernier() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }




    @Test
    void inverserListeAvecElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.inverser();
        assertEquals("ListeSimple(Noeud(1), Noeud(2))", listeATester.toString());
    }

    @Test
    void echangerDeuxNoeuds() {
        listeATester.ajout(3);
        listeATester.ajout(2);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(1);
        Noeud r2 = listeATester.tete;
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(2), Noeud(1), Noeud(3))", listeATester.toString());
    }

    @Test
    void echangerNoeudAvecLuiMeme() {
        listeATester.ajout(1);
        Noeud r1 = listeATester.tete;
        listeATester.echanger(r1, r1);
        assertEquals("ListeSimple(Noeud(1))", listeATester.toString());
    }
    @Test
    void getPrecedent() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        
        Noeud r = listeATester.tete.getSuivant();  // Noeud valide pour getPrecedent
        assertNotNull(r, "Le noeud r devrait être dans la liste.");
        Noeud precedent = listeATester.getPrecedent(r);
        assertNotNull(precedent, "Le noeud précédent devrait exister.");
        assertEquals(3, precedent.getElement(), "Le noeud précédent devrait avoir la valeur 3.");
    }
    @Test
void getPrecedentDebutListe() {
    listeATester.ajout(1);
    listeATester.ajout(2);
    Noeud r = listeATester.tete;  // Premier noeud
    assertNull(listeATester.getPrecedent(r), "Le noeud en tête n'a pas de précédent.");
}

@Test
void getPrecedentNoeudNonPresent() {
    listeATester.ajout(1);
    listeATester.ajout(2);
    Noeud noeudNonListe = new Noeud(3, null); // Noeud non inclus
    assertThrows(IllegalArgumentException.class, () -> listeATester.getPrecedent(noeudNonListe), 
        "Le noeud n'appartient pas à la liste, une exception devrait être levée.");
}
@Test
void echangerDeuxNoeudsListeDeuxElements() {
    listeATester.ajout(2);
    listeATester.ajout(1);
    Noeud r1 = listeATester.tete;
    Noeud r2 = r1.getSuivant();
    listeATester.echanger(r1, r2);
    assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
}
@Test
void modifiePremierElementAbsent() {
    listeATester.ajout(1);
    listeATester.modifiePremier(99, 2); // Élément non présent
    assertEquals("ListeSimple(Noeud(1))", listeATester.toString());
}

@Test
void modifieTousElementsAbsents() {
    listeATester.ajout(1);
    listeATester.ajout(1);
    listeATester.modifieTous(99, 2); // Aucun 99 présent
    assertEquals("ListeSimple(Noeud(1), Noeud(1))", listeATester.toString());
}
@Test
void supprimePremierUnSeulElement() {
    listeATester.ajout(1);
    listeATester.supprimePremier(1);
    assertNull(listeATester.tete, "La liste devrait être vide après suppression.");
    assertEquals(0, listeATester.getSize());
}
@Test
void supprimeTousElementAbsent() {
    listeATester.ajout(1);
    listeATester.ajout(2);
    listeATester.supprimeTous(3); // Aucun élément 3 présent
    assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
    assertEquals(2, listeATester.getSize());
}
@Test
void getPrecedentListeVide() {
    assertNull(listeATester.getPrecedent(null), "Si la liste est vide, getPrecedent devrait retourner null.");
}

@Test
void getPrecedentTete() {
    listeATester.ajout(1);
    Noeud tete = listeATester.tete;  // tête de la liste
    assertNull(listeATester.getPrecedent(tete), "Si r est la tête de la liste, getPrecedent devrait retourner null.");
}
        
}