package no.oslomet.cs.algdat.Oblig1;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Denne klassen kan du bruke til hjelp under utvikling av din oblig.
 * Lag små og enkle test-eksempler for å teste at metoden din fungerer som ønsket.
 */
class Oblig1UnitTest {

    @org.junit.jupiter.api.Test
    void maks() {
        int[] array = {5, 3, 8, 1 , 12, 21, 6, 14, 7};
        int maksVerdi = Oblig1.maks(array);
        assertEquals(21, maksVerdi);

        // Se kommentar fra test tredjeMin(), test 7.
        int[] tom = {};
        Exception exception = assertThrows(NoSuchElementException.class, () -> Oblig1.maks(tom));
        String forventetMelding = "Arrayet er tom!";
        assertEquals(forventetMelding, exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void ombyttinger() {
        int[] array = {5, 3, 8, 1 , 12, 21, 6, 14, 7};
        int antallOmbyttinger = Oblig1.ombyttinger(array);
        assertEquals(5, antallOmbyttinger);

        int[] array2 = {4};
        antallOmbyttinger = Oblig1.ombyttinger(array2);
        assertEquals(0, antallOmbyttinger);

        // Se kommentar fra test tredjeMin(), test 7.
        int[] tom = {};
        Exception exception = assertThrows(NoSuchElementException.class, () -> Oblig1.maks(tom));
        String forventetMelding = "Arrayet er tom!";
        assertEquals(forventetMelding, exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void antallUlikeSortert() {
        int[] sortert = {3, 3, 4, 5, 5, 6, 7, 7, 7, 8};
        int antallUlike = Oblig1.antallUlikeSortert(sortert);
        assertEquals(6,antallUlike);

        // Se kommentar fra test tredjeMin(), test 7.
        int[] usortert = {3, 4, 5, 5, 3, 6, 8, 7, 7, 7};
        Exception exception = assertThrows(IllegalStateException.class, () -> Oblig1.antallUlikeSortert(usortert));
        String forventetMelding = "Tabellen er ikke stigende sortert!";
        assertEquals(forventetMelding, exception.getMessage());

        int[] tom = {};
        int forventet_0 = 0;
        assertEquals(forventet_0, Oblig1.antallUlikeSortert(tom));
    }

    @org.junit.jupiter.api.Test
    void antallUlikeUsortert() {
        int[] usortert = {5, 3, 7, 4, 3, 5, 7, 8, 6, 7};
        int antallUlike = Oblig1.antallUlikeUsortert(usortert);
        assertEquals(6, antallUlike);

        int[] tom = {};
        int forventet_0 = 0;
        assertEquals(forventet_0, Oblig1.antallUlikeUsortert(tom));
    }

    @org.junit.jupiter.api.Test
    void delsortering() {

        // Tester for vanlig tilfelle
        int[] a = {6, 10, 16, 11, 7, 12, 3, 5, 8};
        int[] forventet_a = {3, 5, 7, 11, 6, 8, 10, 12, 16};

        Oblig1.delsortering(a);

        assertArrayEquals(forventet_a, a);

        // Tester for tom tabell
        int[] b = {};
        int[] forventet_b = {};

        Oblig1.delsortering(b);
        assertArrayEquals(forventet_b, b);

        // Tester for negative tall
        int[] c = {6, -10, 16, -11, 7, 12, -3, 5, 8};
        int[] forventet_c = {-11, -3, 5, 7, -10, 6, 8, 12, 16};

        Oblig1.delsortering(c);
        assertArrayEquals(forventet_c, c);

        // Tester for kun partall
        int[] d = {6, 10, 16, 12, 8};
        int[] forventet_d = {6, 8, 10, 12, 16};

        Oblig1.delsortering(d);
        assertArrayEquals(forventet_d, d);

        // Tester for kun oddetall
        int[] e = {11, 7, 3, 5};
        int[] forventet_e = {3, 5, 7, 11};

        Oblig1.delsortering(e);
        assertArrayEquals(forventet_e, e);
    }

    @org.junit.jupiter.api.Test
    void rotasjon() {
        char[] a = {'A','B','C','D','E','F','G','H','I','J'};
        char[] forventet_a = {'H', 'I', 'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        Oblig1.rotasjon(a, 3);

        assertArrayEquals(forventet_a, a);

        //assertEquals(true, false, "Implementer rotasjon og denne testen");
    }

    @org.junit.jupiter.api.Test
    void flett() {


        // 7a
        // Tester for vanlig tilfelle
        String a = "ACEG";
        String b = "BDFH";
        String forventet_ab = "ABCDEFGH";

        String resultat1 = Oblig1.flett(a, b);
        assertEquals(forventet_ab, resultat1);


        // Tester for en string uten tegn
        String c = "";
        String d = "HEI";
        String forventet_cd = "HEI";

        String resultat2 = Oblig1.flett(c, d);
        assertEquals(forventet_cd, resultat2);


        // Tester for to stringer uten tegn
        String e = "";
        String f = "";
        String forventet_ef = "";

        String resultat3 = Oblig1.flett(e, f);
        assertEquals(forventet_ef, resultat3);

        // 7b
        // Tester for vanlig tilfelle
        String [] g = {"HPE", "EÅG", "ID"};
        String forventet_1 = "HEIPÅDEG";

        String resultat4 = Oblig1.flett(g);
        assertEquals(forventet_1, resultat4);


        // Tester for tomme strenger
        String [] h = {"", "", ""};
        String forventet_2 = "";

        String resultat5 = Oblig1.flett(h);
        assertEquals(forventet_2, resultat5);
    }

    @org.junit.jupiter.api.Test
    void indekssortering() {
        // Test 1: 'a' tomt array skal gi tomt 'indeks'-array.
        int[] a = {};
        int[] forventet_a = {};
        assertArrayEquals(forventet_a, Oblig1.indekssortering(a));

        // Test 2: 'a' med lengde 1.
        int[] b = {12};
        int[] forventet_b = {0};
        assertArrayEquals(forventet_b, Oblig1.indekssortering(b));

        // Test 3: Lenger array med like verdier.
        int[] c = {6, 10, 16, 11, 7, 12, 3, 5, 8, 5};
        int[] forventet_c = {6, 7, 9, 0, 4, 8, 1, 3, 5, 2};
        assertArrayEquals(forventet_c, Oblig1.indekssortering(c));

        // Test 4: Array med bare like verdier.
        int[] d = {2, 2, 2, 2};
        int[] forventet_d = {0, 1, 2, 3};
        assertArrayEquals(forventet_d, Oblig1.indekssortering(d));
    }

    @org.junit.jupiter.api.Test
    void tredjeMin() {
        // Test 1: Et array med 3 elementer som er sortert.
        int[] a = {1, 2, 3};
        int[] forventet_a = {0, 1, 2};
        assertArrayEquals(forventet_a, Oblig1.tredjeMin(a));

        // Test 2: Et array med 3 elementer usortert.
        int[] b = {2, 3, 1};
        int[] forventet_b = {2, 0, 1};
        assertArrayEquals(forventet_b, Oblig1.tredjeMin(b));

        // Test 3: Et array med 3 elementer med like verdier.
        int[] c = {3, 2, 2};
        int[] forventet_c = {1, 2, 0};
        assertArrayEquals(forventet_c, Oblig1.tredjeMin(c));

        // Test 4: Et array med flere enn 3 elementer sortert.
        int[] d = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] forventet_d = {0, 1, 2};
        assertArrayEquals(forventet_d, Oblig1.tredjeMin(d));

        // Test 5: Et array med flere enn 3 elementer usortert.
        int[] e = {6, 10, 16, 11, 7, 12, 3, 5, 8, 5};
        int[] forventet_e = {6, 7, 9};
        assertArrayEquals(forventet_e, Oblig1.tredjeMin(e));

        // Test 6: Et array med flere enn 3 elementer med like verdier.
        int[] f = {6, 10, 3, 11, 8, 12, 3, 5, 8, 3};
        int[] forventet_f = {2, 6, 9};
        assertArrayEquals(forventet_f, Oblig1.tredjeMin(f));

        // Test 7: Hvis lengden til arrayet er mindre enn 3, så kastes en exception.
        // Inspirasjon til denne koden: https://www.baeldung.com/junit-assert-exception
        int[] g = {2, 1};
        Exception exception = assertThrows(NoSuchElementException.class, () -> Oblig1.tredjeMin(g), "Forventet at tredjeMin(g) fikk NoSuchElementException, men fikk ikke det.");
        String forventetMelding = "a har lengde 2. Må være større enn 2!";
        assertEquals(forventetMelding, exception.getMessage());

    }

    @org.junit.jupiter.api.Test
    void bokstavNr() {
        // Test 1: Returnerer riktig verdi for A.
        char A = 'A';
        int forventetA = 65;
        assertEquals(forventetA, Oblig1.bokstavNr(A));

        // Test 2: Returnerer riktig verdi for Æ, Ø og Å.
        char AE = 'Æ';
        int forventetAE = 198;
        assertEquals(forventetAE, Oblig1.bokstavNr(AE));

        char O = 'Ø';
        int forventetO = 216;
        assertEquals(forventetO, Oblig1.bokstavNr(O));

        char AA = 'Å';
        int forventetAA = 197;
        assertEquals(forventetAA, Oblig1.bokstavNr(AA));
    }

    @org.junit.jupiter.api.Test
    void inneholdt() {
        // Test 1: Sjekker om "ABBA" er i ord som jeg vet "ABBA" er inneholdt i.
        String a = "ABBA";
        String b = "ABBABBA";
        assertTrue(Oblig1.inneholdt(a, b));

        b = "BARAB";
        assertTrue(Oblig1.inneholdt(a, b));

        b = "BARBARER";
        assertTrue(Oblig1.inneholdt(a, b));

        b = "RABARBRA";
        assertTrue(Oblig1.inneholdt(a, b));

        // Test 2: Sjekker om "ABBA" er i ord som jeg vet "ABBA" IKKE er inneholdt i.
        b = "AKROBAT";
        assertFalse(Oblig1.inneholdt(a, b));

        b = "BARBERER";
        assertFalse(Oblig1.inneholdt(a, b));

        // Test 3: Sjekker om "" er innehold i hvilket som helst ord.
        String tom = "";
        b = "";
        assertTrue(Oblig1.inneholdt(tom, b));

        b = "OPPGAVE";
        assertTrue(Oblig1.inneholdt(tom, b));

        // Test 4: Sjekker om "A" er inneholdt i "". Skal være false.
        a = "A";
        assertFalse(Oblig1.inneholdt(a, tom));

        // Test 5: 'a' er lenger enn 'b'. Skal returnere false.
        a = "AA";
        b = "A";
        assertFalse(Oblig1.inneholdt(a, b));

        // Test 6: Strenger med Æ,Ø og/eller Å. Den første skal være true, den andre skal være false.
        a = "BÆÅ";
        b = "BLÅBÆR";
        assertTrue(Oblig1.inneholdt(a, b));

        a = "ÅØ";
        assertFalse(Oblig1.inneholdt(a, b));
    }
}