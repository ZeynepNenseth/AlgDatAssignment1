package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;


public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////

    /**
     * - I en tabell med n verdier sammenligner maks-metoden a[0] med a[1], a[1] med a[2], a[2] med a[3], ..., a[n-1] med a[n].
     * Dvs. det blir n-1 ganger sammenligninger for å finne den maks-verdien.
     * - Siden vi bytter om verdiene når f. eks. a[0] > a[1], a[1] > a[2], a[2] > a[3], ..., a[n-1] > a[n], får vi flest
     * ombyttinger i en tabell med tall fra 1 til n når tabellen er sortert synkende, altså n er i posisjon 0 og 1 er i posisjon n-1.
     * - Det blir da færrest ombyttinger når tabellen er sortert stigende, altså minste tall (1) er i indeks 0 og største tall (n)
     * i indeks n-1.
     * - Jeg måtte lage en metode som beregner gjennomsnittet av antall ombyttinger. Metoden tar imot en int verdi a som er
     * viser hvor manger ganger en array med n verdier skal permuteres og en int n som størrelsen av arrayet som har unike verdier
     * fra 1 til n. Den returnerer antall ombyttinger/antall arrayer som ble testet, altså gjennomsnittet. Når man velger f.eks.
     * a(500_000) og n(100), blir gjennomsnittet 94 (for a=500_000, n=1000, gjennomsnitt=992) som tyder på at antall gjennomsnitt
     * ombyttinger  er ~ n (størrelsen av arrayet).
     * - Sammenlignet med de tre maks metodene er vår metode svært ineffektiv fordi vi bruker mange tabelloperasjoner. "if (a[i] > a[i+1])"
     * består av to tabelloperasjoner og en sammenlikning for (n-1) ganger siden vi har (n-1) sammenlikninger i for-løkken. Hvis if-setningen
     * er sant, altså vi bytter om, så er det alt sammen fire tabelloperasjoner og tre tilordninger ganget med antall ombyttinger.
     * Tabelloperasjoner er generellt kostbare og derfor er den metoden ikke den mest effektive.
     */

    public static int maks(int[] a) {
        //throw new UnsupportedOperationException();
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Arrayet er tom!");
        }

        int i;

        //Øvre grensen er "<=" a.length-2 fordi den siste indeksen er lenght-1 men i+1 må fortsatt være innafor arrayet
        for (i = 0; i <= a.length-2; i++) {
            if (a[i] > a[i+1]) {             //sammenligner a[0] og a[1] i første omgang
                int temp = a[i+1];           // hvis a[1]>a[0], så bytter man plassen av verdiene med å lagre den ene i en temp verdi
                a[i+1] = a[i];
                a[i] = temp;
            }
        }
        return a[i];
    }

    public static int ombyttinger(int[] a) {
        //throw new UnsupportedOperationException();
        // samme kode som i maks-metoden men innfører en teller (antOmbytt) som teller antall ombyttinger
        if (a.length < 1) {
            throw new NoSuchElementException("Arrayet er tom!");
        }

        int antOmbytt = 0;
        for (int i = 0; i <= a.length-2; i++) {
            if (a[i] > a[i + 1]) {
                antOmbytt++;        // telleren går opp 1 hver gang det skjer ombytting
                int temp = a[i + 1];
                a[i + 1] = a[i];
                a[i] = temp;
            }
        }
        return antOmbytt;
    }

    public static int gjennomsnittOmbytting(int a, int n) {
        Random r = new Random();                        // kaller en randomgenerator
        int sum = 0;

        // denne for-løkken randomgeneriserer permutasjoner av en array med unike tall fra 1 til n
        // koden er en modifisert versjon av 1.1.8 e) fra Kompendiet
        for (int i = 0; i < a; i++) {                 // indikerer antall permutasjoner
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {             // fyller arrayet med tall fra 1 til n
                b[j] = j+1;
            }
            for (int k = n - 1; k > 0; k--) {         // randomiserer tallene fra arrayet og bytter plassene
                int s = r.nextInt(k + 1);
                int temp = b[s];
                b[s] = b[k];
                b[k] = temp;
            }
            sum += ombyttinger(b);                    // sumerer antall ombyttingene
        }
        return sum / a;                               // beregner gjennomsnittet
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
       // throw new UnsupportedOperationException();
        if (a.length < 1) { // sjekker for tomt array. Ikke unntak
            return 0;
        }
        // teller må være lik 1. Med 0 får man en telling mindre. Fant ut det vha debugging
        int teller = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i-1] <= a[i]) {       // sjekker om arrayet er sortert
                if (a[i] != a[i - 1]) {
                    teller++;
                }
            } else { // kaster unntak hvis arrayet er ikke sortert
                    throw new IllegalStateException("Tabellen er ikke stigende sortert!");
                }
        }
        return teller;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        // throw new UnsupportedOperationException();
        // nesten samme tankegang som i oppgave 2 men her må man ha to for-løkker inn i hverandre fordi arrayet er ikke sortert.
        if (a.length < 1) { // sjekker for tomt array. Ikke unntak
            return 0;
        }
        int teller = 0;  // telleren starter på 0 og ikke 1. Fant det ut etter debugging
        for (int i = 0; i < a.length; i++) {
            // må ha en boolean for å utelukke tall som jeg har gjennomgått før i forrige runder av for-løkken
            boolean settTalletFor = false;
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    settTalletFor = true; // har gått gjennom disse tallene før
                    break;
                }
            }
            if (!settTalletFor) { //øker telleren hvis man ikke har gjennomgått det tallet
                teller++;
            }
        }
        return teller;
    }

    ///// Oppgave 4 //////////////////////////////////////
    // Vi har et array hvor oddetall skal sorteres stigende på venstre side av arrayet,
    // og partall skal sorteres stigende etter oddetallene.
    // Først sjekker vi om listen er tom eller har mindre enn 2 verdier, hvis ja returneres arrayet som det er.
    // Deretter sorterer vi arrayet stigende ved bruk av kvikksort.
    // For å sjekke om arrayet inneholder kun partall eller kun oddetall bruker vi
    // en for-løkke som løper gjennom hele arrayet.
    // Hvis listen inneholder en blanding av oddetall og partall, flytter vi alle oddetall til
    // venstre i listen i en for-løkke. Deretter sorteres partallene på nytt i intervallet [første partall, array.length-1).
    // Vi har laget egne metoder for kvikksortering, partisjonering og bytting.
    public static void delsortering(int[] a) {
        // throw new UnsupportedOperationException();

        // Sjekker om listen er tom eller har mindre enn to verdier.
        if (a.length < 2) {
            return;
        }

        // Sorterer listen:
        kvikksortering0(a,0,a.length-1);

        //Sjekker gjennom hele arrayet med en for-løkke
        int antallPartall = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] % 2 == 0) {//Sjekker om tallet er partall

                antallPartall++;
            }
        }

        // sjekker om listen ikke bare inneholder partall eller oddetall.
        // om det er en blanding, går den igjennom listen, og
        // flytter alle oddetall til venstre
        if (antallPartall != a.length && antallPartall != 0) {
            int indeks = 0;
            for (int m = 0; m < a.length; m++) {
                if (a[m] % 2 != 0) {
                    int temp = a[indeks];
                    a[indeks] = a[m];
                    a[m] = temp;
                    indeks++;
                }
            }
            //sorterer partallene i listen
            kvikksortering0(a,indeks, a.length-1);
        }
    }

    //(Denne koden er kopiert fra Online-Kompendiet Programkode 1.3.9 h)
    private static void kvikksortering0(int[] a, int v, int h){

        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }
    //(Denne koden er kopiert fra Online-Kompendiet Programkode 1.3.9 f)
    private static int sParter0(int[] a, int v, int h, int indeks){

        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }
    //(Denne koden er kopiert fra Online-Kompendiet Programkode 1.3.9 a)
    private static int parter0(int[] a, int v, int h, int skilleverdi) {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    ///// Oppgave 5 //////////////////////////////////////
    //Det kan være aktuelt å «rotere» elementene i en tabell.
    // En rotasjon på én enhet gjøres ved at det siste elementet blir
    // det første og alle deandre forskyves én enhet mot høyre.
    // På figuren over har elementene i den første tabellen blitt «rotert» én enhet.
    // Lag metoden public static void rotasjon(char[]a).Den skal «rotere» innholdet i tabellen a én enhet.
    // En rotasjon i en tom tabell eller i en tabell med nøyaktig ett element er ingen feilsituasjon.
    // Men rotasjonen vil da ikke endre noe.
    public static void rotasjon(char[] a) {
        //throw new UnsupportedOperationException();

        //Definere antall plasser som skal roteres
        int d = 1;

        int n = a.length;

        //Sjekke om listen er tom eller har mindre en 2 verdier
        if(n < 2){
            return;
        }

        //Opprette en hjelpetabell som tar vare på verdien som "faller ut av listen
        //(Denne koden er kopiert fra Online-Kompendiet Programkode 1.3.13 d)
        char[] b = Arrays.copyOfRange(a,n-d,n);

        //for-løkke som går igjennom char[] a
        //(Denne koden er kopiert fra Online-Kompendiet Programkode 1.3.13 d)
        for (int i = n-1; i >= d; i--) {
            a[i] = a[i - d]; //forskyver alle d = 1 plass frem.
        }

        //Kopiere tilbake verdien fra hjelpetabellen/Erstatter a[0] med b[0]
        // (Denne koden er kopiert fra Online-Kompendiet Programkode 1.3.13 d)
        System.arraycopy(b,0,a,0,d);
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        //throw new UnsupportedOperationException();

        //(Følgende koden er kopiert fra Online-Kompendiet Programkode 1.3.13 g, og tilpasset oppgaven:)
        int n = a.length;
        //Sjekke om listen er tom eller har mindre en 2 verdier
        if (n < 2) return;

        if ((k %= n) < 0) k += n; // Sjekker om om fortegn er minus, og dermed hvilken vei den skal rotere.

        for (int v = 0, h = n - 1; v < h;){
            bytt(a, v++, h--); // snur a[0:n>
        }
        for (int v = 0, h = k - 1; v < h;){
            bytt(a, v++, h--); // snur a[0:k>
        }
        for (int v = k, h = n - 1; v < h;) {
            bytt(a, v++, h--); // snur a[k:n>
        }
    }
    public static void bytt(char[] a, int i, int j) { // Hjelpemetode til oppgave 6 som bytter elementer i en char-tabell
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    // Inspirasjon til koden hentet fra: https://stackoverflow.com/questions/22919096/how-to-build-a-string-taking-alternate-characters-from-two-equal-length-input-st
    //
    //
    //
    public static String flett(String s, String t) {
        // throw new UnsupportedOperationException();

        String u = "";                          // Lager ny tom streng der de nye bokstavene skal bli plassert

        for (int i = 0; i < s.length() || i < t.length(); i++) {        // Løkke som går så lenge det er
                                                                        // bokstaver igjen i en eller begge strengene
            if (i < s.length()) {                   // Hvis det er bokstaver igjen i array s konkatineres denne bokstaven til strengen u.
                u += s.charAt(i);
            }
            if (i < t.length()) {                   // Hvis det er bokstaver igjen i array t konkatineres denne bokstaven til strengen u.
                u += t.charAt(i);
            }
        }
        return u;           // Returnerer en String
    }

    /// 7b)
    public static String flett(String... s) {
        //throw new UnsupportedOperationException();

        // For å finne antall bokstaver og mellomrom som er i strengene til sammen.
        String uflettetStreng = "";         // Lager en tom String
        for (String streng : s) {           // går gjennom hver string i arrayet og konkatinerer dem til uflettetStreng
            uflettetStreng += streng;
        }

        String flettetString = "";             // Lager en tom String
        for (int i = 0; i < uflettetStreng.length(); i++) {
            for (String streng : s) {       // Går gjennom alle strengene sendt inn.
                if (i < streng.length()) {      // Hvis index i er mindre enn streng-lengde
                    flettetString += streng.charAt(i);          // Konkatinerer bokstaven på indeks i inn i flettetString
                }
            }
        }
        return flettetString;       // Returnerer String
    }


    ///// Oppgave 8 //////////////////////////////////////
    /* Metoden skal returnere tabellen 'indeks' med indekser til verdiene i tabellen 'a'.
     * 'a' skal IKKE endres.
     * 'a' kan ha like verdier.
     * 'a' kan være tom. Da skal også 'indeks' være tom.
     * Hvis a = {6, 10, 16, 11, 7}, så blir indeks = {0, 4, 1, 3, 2}.
     * Legg merke til at a[0] = 6, a[4] = 7, a[1] = 10, a[3] = 11 og a[2] = 16.
     * Dvs. indeksene i 'indeks' refererer til verdiene i 'a' i stigende rekkefølge. (Fra minst til størst).
     */
    public static int[] indekssortering(int[] a) {
        // 'indeks' skal være like stor som 'a'. Default verdier er 0-ere.
        int[] indeks = new int[a.length];

        // Hvis 'a' er tom, så er 'indeks' tom. Returner tom 'indeks' tabell.
        // Hvis 'a' har lengde 1, så vet vi hvordan 'indeks' ser ut. Returnerer indeks = {0}.
        if (indeks.length < 2) return indeks;

        // 'a' har to eller flere elementer.
        // Sett inn indeksverdier. Dette vil referere til listen 'a' som den er nå. Usortert.
        // Trenger ikke begynne på 0, for den vil jeg at skal være 0 (default verdi).
        for (int i = 1; i < indeks.length; i++) indeks[i] = i;

        // Vi kan ikke endre 'a', men vi kan endre 'indeks'-tabellen. Sorterer 'indeks'.
        for (int i = 0; i < indeks.length-1; i++) { // indeks.length-1 fordi når vi har sortert alle tallene bortsett fra 1, så er det siste tallet automatisk sortert.
            for (int j = 0; j < indeks.length-1; j++) {
                if (a[indeks[j]] > a[indeks[j+1]]) {
                    int temp = indeks[j];
                    indeks[j] = indeks[j+1];
                    indeks[j+1] = temp;
                }
            }
        }

        return indeks; // Returnerer liste med indekser.
    } // indekssortering slutt.

    ///// Oppgave 9 //////////////////////////////////////
    /* Metoden skal returnere et array med indeksene til de tre minste verdiene i tabellen 'a'.
     * Arrayet er på formen: { indeksMinsteVerdi, indeksNestMinsteVerdi, indeksTredjeMinsteVerdi }
     * Bruk 3 hjelpevariabler for verdier og 3 hjelpevariabler for indeksene.
     * Oppgaven sier jeg skal bruke samme type ide som Programkode 1.2.5 a). Derfor er min kode inspirert av den programkoden.
     */
    public static int[] tredjeMin(int[] a) {
        // Hvis 'a' har færre enn 3 elementer, så kan vi ikke finne de tre minste verdiene.
        if (a.length < 3)
            throw new java.util.NoSuchElementException("a har lengde " + a.length + ". Må være større enn 2!");

        int m = 0; // posisjonen til minste verdi
        int nm = 1; // posisjonen til nest minste verdi
        int tm = 2; // posisjonen til tredje minste verdi

        // Må bytte m, nm og tm om slik at a[0] er minste verdi, a[1] er nest minste og a[2] er størst.
        for (int i = 0; i < 2; i++) {
            if (a[m] > a[nm]) {
                int temp = m;
                m = nm;
                nm = temp;
            }
            if (a[nm] > a[tm]) {
                int temp = nm;
                nm = tm;
                tm = temp;
            }
        }

        int minVerdi = a[m]; // Minste verdi
        int nestMinVerdi = a[nm]; // Nest minste verdi
        int tredjeMinVerdi = a[tm]; // Tredje minste verdi.

        // Kan starte på plass nr 3. Har sett på elementene på plass 0, 1 og 2.
        for (int i = 3; i < a.length; i++) {
            if (a[i] < tredjeMinVerdi) {
                if (a[i] < nestMinVerdi) {
                    if (a[i] < minVerdi) {
                        // Ny verdi er minst av alle.
                        // Ny tredje minst.
                        tm = nm;
                        tredjeMinVerdi = nestMinVerdi;

                        // Ny nest minst.
                        nm = m;
                        nestMinVerdi = minVerdi;

                        // Ny minste verdi.
                        m = i;
                        minVerdi = a[i];
                    } else {
                        // Ny verdi er mindre enn tredje minste verdi og nest minste verdi, men ikke minste.
                        // Ny tredje minst.
                        tm = nm;
                        tredjeMinVerdi = nestMinVerdi;

                        // Ny nest minst.
                        nm = i;
                        nestMinVerdi = a[i];
                    }
                } else {
                    // Ny verdi er mindre enn tredje minste verdi, men ikke nest minste verdi og minste verdi.
                    // Ny tredje minst.
                    tm = i;
                    tredjeMinVerdi = a[i];
                }
            }
        }

        return new int[] {m, nm, tm};
    }

    ///// Oppgave 10 //////////////////////////////////////
    /* Hvordan gjøre om bokstav til heltall (ASCII tall)?
     * Kode inspirasjon: https://stackoverflow.com/questions/16458564/convert-character-to-ascii-numeric-value-in-java?fbclid=IwAR2UIN-Y1Voxj1FOVRradkQXZ0AauSs4mysGvTYyMR-xTBycJxFUETJl-No
     * Legg merke til at metoden bokstavNr returnerer int. Metoden gjør derfor om et char til ascii tall.
     */
    // A = 65, B = 66, ..., Z = 90. Æ = 198. Ø = 216. Å = 197.
    public static int bokstavNr(char bokstav) {
        return bokstav;
    }

    /* Metode som sjekker om alle bokstavene i et ord 'a' forekommer minst like mange ganger i et annet ord 'b'.
     * Trenger ikke være i rekkefølge. Ta for gitt at begge ordene kun har store bokstaver.
     * Metoden skal returnere true dersom 'a' er inneholdt i 'b', false ellers.
     * Tomt ord/tom streng ("") er inneholdt i alle ord.
     * Ingen grense på hvor lange ordene kan være.
     */
    public static boolean inneholdt(String a, String b) {
        // Et tomt ord/tom streng er innehold i alle ord og er derfor alltid true.
        if (a.equals("")) {
            return true;
        }

        // Teller antall A-er på plass 0, B-er på plass 1, ..., Z-er på plass 25.
        // Fordi ASCII-tallet for A er 65, B er 66, ..., Z = 90. Trekker vi fra 65, får vi A = 0, B = 1, osv.
        // Teller antall Æ-er på plass 133, Ø-er på plass 151, Å-er på plass 132.
        // Fordi ASCII-tallet for Æ er 198, Ø er 216, Å er 197.
        int[] antall = new int[152];

        // Teller hvor mange ganger hver bokstav i 'b' forekommer.
        for (int i = 0; i < b.length(); i++) {
            antall[bokstavNr(b.charAt(i))-65]++;
        }

        for (int i = 0; i < a.length(); i++) {
            // Sjekk om bokstaven på plass i (i 'a') forekommer i 'b'.
            // Hvis ja, trekk 1 fra antallet og fortsett. Hvis nei, så er 'a' ikke innehold i 'b'.
            if (antall[bokstavNr(a.charAt(i))-65] != 0) {
                antall[bokstavNr(a.charAt(i))-65]--;
            } else {
                return false;
            }
        }

        // Om vi kommer hit er 'a' inneholdt i 'b'.
        return true;
    }
}  // Oblig1
