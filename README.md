[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=446858&assignment_repo_type=GroupAssignmentRepo)
# Obligatorisk oppgave 1 i Algoritmer og Datastrukturer

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Zeynep har hatt hovedansvar for oppgave 1, 2, og 3. 
* Vilde har hatt hovedansvar for oppgave 4, og 7. 
* Marianne har hatt hovedansvar for oppgave 5 og 6. 
* Mari har hatt hovedansvar for oppgave 8, 9 og 10. 

# Oppgavebeskrivelse

I oppgave 1 ser koden lignende til bubblesort. I en for-løkke begynner vi med verdi i indeks 0 og sammenligner
med verdi i indeks 1. Den største verdien av de to får indeks 1. Det samme skjer med de tallene nå in indeks 1 og 2 og så
bobler den største verdien bakover. I motsetting til koden i forelesningen, må vi returnere verdien og ikke indeksen.
Koden til ombyttinger-matoden er nesten det samme som i maks-metoden men vi innfører en teller for å telle antall ombyttinger.
I javadoc-kommentaren svarte jeg på spørsmålene. For å svare på siste spørsmålet lagde jeg en ekstra metode for å kunne beregne
gjennomsnittlige antall av ombyttinger. Metoden er forklart i javadoc. Jeg prøvde med noen forskjellige parametre i den metoden
som ga håpentligvis det riktige svaret.

I oppgave 2 skulle man finne antall unike verdier i en stigende sortert array som hadde gjentakende verdier. Her brukte jeg en for-lokke
for å gå gjennom arrayet og telte ulike verdier. Selv om jeg startet foran og gikk mot enden av arrayet, måtte jeg bruke indeksene
på en annen måte enn i oppgave1 for å få riktig gjennomgang. Her brukte jeg mye tid på å få telleren riktig og kom på at den måtte
starte på 1 og ikke null. Dette fikk jeg se kun etter debugging av for-løkken.

I oppgave 3 trengte vi 2 for-løkker, en in den andre, for å gå gjennom arrayet. Dette kommer fra at arrayet er ikke sortert. Dermed ligner 
koden ikke til den i oppgave2. Ytterste for-løkken går gjennom arrayet fra indeks 0 til siste indeks mens indre for-løkken går gjennom 
arrayet fra indeks 0 til (ikke med) indeksen der ytterste løkken befinner seg og leter etter like/ulike verdier. Her er det viktig å 
innføre en boolean for å unngå å telle ulike verdiene som man hadde allerede talt i forrige omganger av den ytre-løkken. Her starter
telleren på 0 og ikke 1 i motsetting av i oppgave2. Jeg brukte igjen debugging a for-løkkene for å forstå tellingen.

I oppgave 4
Vi har et array hvor oddetall skal sorteres stigende på venstre side av arrayet,
og partall skal sorteres stigende etter oddetallene.
Først sjekker vi om listen er tom eller har mindre enn 2 verdier, hvis ja returneres arrayet som det er.
Deretter sorterer vi arrayet stigende ved bruk av kvikksort.
For å sjekke om arrayet inneholder kun partall eller kun oddetall bruker vi
en for-løkke som løper gjennom hele arrayet.
Hvis listen inneholder en blanding av oddetall og partall, flytter vi alle oddetall til
venstre i listen i en for-løkke. Deretter sorteres partallene på nytt i intervallet [første partall, array.length-1).
Vi har laget egne metoder for kvikksortering, partisjonering og bytting. 

I oppgave 5 er det først definert en veriabel d med hvor mange plasser som skal rotere/flyttes. 
Og så er det definert en variabel n for listen sin lengde, for å gjøre det ryddigere i utregningen. 
Deretter er det laget en if-setning som sjekker at listen inneholder 2 eller flere tall, ellers har ikke metoden noen hensikt.
Så lages det en hjelpetabell b, som kopierer liste a fra plass n-d ( i dette tilfelle 1) til n som er siste objektet i listen.
Dette gjøres fordi dette talle vil "falle" utenfor listen når de andre objektene flyttes en plass frem.
Så opprettes det en for-løkke som går igjennom listen fra bakerste plass, og forskyver alle en plass(indeks) frem.
Når den har gått ojennom forløkken, kopieres verdien fra hjelpetabellen b tilbake inn på første (indeks 0) i  liste a.

I oppgave 6 ble det førts tatt utgangspunkt i nøyaktig samme kode som i oppgave 5, men hvor det ble lagt inn en 
if-setning som sjekker om int k, som metoden tar inn som parameter, og som bestemmer hvor mange plasser som skal roteres,
er negativ eller positiv, noe som avgjør hvilken vei verdiene i listen skal flyttes. For å se om metoden kunne bli mer effektiv, 
ble den så erstattet med en ny kode, som i steden snur hele listen, og så deler den i to, hvor den første delen er fra 
indeks 0 og til k, og den andre er fra k til n. Deretter snus begge disse listene også, og resultatet blir som om plassene 
har rotert k ganger. For å snu listene har det blitt opprettet en egen metode som heter public static void bytt.
Det har blitt prøvd flere forskjellige koder på denne oppgaven, som alle passerer testen, men ved debuging ser det ut som at den 
får feil på noen av testene som går på tid/effektivitet. Ettersom det ikke skrives ut noen feilmeldinger, og den går igjennom på testen,
har vi vurdert at koden oppnår målet for oppgaven.

I oppgave 7
Oppgave 7 er delt opp i oppgave a og b. I oppgave 7a skal metoden flett ta inn
to strenger. Disse skal flettes sammen slik at annenhvert tegn kommer i strenger som 
returneres. Dette har vi løst ved å bruke en for-løkke som går så lenge
det er tegn igjen i en av strengene. Ved hjelp av to if-setninger skrives annenhvert tegn
over i ut-strengen. I oppgave 7b har vi valgt å lage en uflettet streng av 
strengene som står i arrayet. Dette gjør vi ved konkatinering i en for-each-løkke.
Deretter bruker vi en ytre og en indre for-løkke for å hente frem neste tegn som konkatineres 
inn i strengen flettetString. Metoden returnerer den flettede strengen.

I oppgave 8 begynte jeg med å kommentere over metoden hva den er ment til å gjøre.
Så laget jeg arrayet 'indeks' som skulle returneres til slutt.
Deretter skrev jeg kode som fanget spesielle arrayer sendt inn i metoden.
De spesielle arrayene er den tomme arrayen {} og arrayer med en verdi.
Planen var å sortere 'a' ved å endre på 'indeks'-tabellen, derfor legger jeg inn verdiene 0 til a.length-1
slik at indeks = {0, 1, 2, ..., a.length-1}. Dette refererer til listen 'a'. Bruker samme ide som når vi sorterte 'a' fra minst til
størst ved å endre 'a', men isteden for å bytte på verdiene i 'a', bytter vi verdiene i 'indeks'.
Bruker boublesort slik at 'indeks'-tabellen til slutt refererer til den sorterte
versjonen av 'a' (som vi ikke endrer). Laget tester for metoden.

I oppgave 9 begynte jeg med å kommentere over metoden hva den er ment til å gjøre.
Så laget jeg en if-testen som fanget arrayer mindre enn lengde 3. 
Denne kaster en NoSuchElementException. Resten av koden er inspirert av Programkode 1.2.5 a) som oppgaven ba meg bli inspirert av.
Kopierte koden. La til en variabel 'tm'. Laget en metode som bytter om 'm', 'nm' og 'tm' slik at 'm' er indeksen
til det minste tall av de tre, 'nm' er det nest minste og 'tm' er det største av de tre.
Når vi har gjort dette, kan vi initialisere minVerdi, nestMinVerdi og tredjeMinVerdi.
Det neste vi gjør er å gå gjennom resten av tallene i 'a'. Ingenting skjer dersom arrayet bare har tre verdier.
Dette er fordi 3 ikke er mindre enn 3 (går aldri inn i for-loopen).
Dersom vi har flere enn tre tall i arrayet, sjekker vi først om det fjerde tallet er mindre enn tredje minste verdi.
Hvis tallet er mindre, gjør ingenting. Dersom tallet er større, sjekk om tallet er mindre enn nest minste verdi. Hvis
tallet ikke er mindre, tm = nyVerdi. Hvis tallet er mindre, sjekk om tallet er mindre enn minste verdi. Hvis tallet ikke 
er mindre, tm = nm og nm = nyVerdi. Hvis tallet er mindre, tm = nm, nm = m og m = nyVerdi. Deretter returnerer jeg et array
på formen { indeksMinsteVerdi, indeksNestMinsteVerdi, indeksTredjeMinsteVerdi } ({m, nm, tm}).

I oppgave 10 begynte jeg med å kommentere over metoden hva den er ment til å gjøre.
Så laget jeg en if test som fanger opp når 'a' er en tom string, for da vil vi returnere true uansett hva 'b' er.
Så skrev jeg inn 'return bokstav' i metoden bokstavNr. 'bokstav' er en char-verdi, men siden metoden returnerer int, gjør den automatisk bokstaven om til ASCII tall.
Deretter laget jeg et array 'antall' som skal hjelpe meg å telle antall av de forskjellige bokstavene i 'a' og 'b'.
For eksempel så er 'A' 65 i ACSII tall. Jeg ville starte arrayet på 0 og plassere antall 'A'-er der. Derfor legger jeg til 1 i
antall[bokstavNr-65] hvis jeg finner en 'A' i strengen 'b' i første loop. Når jeg har gjort dette for alle bokstavene i ordet 'b',
går vi gjennom bokstavene i strengen 'a'. Dersom vi finner for eksempel en 'A' på plass 0 i strengen 'a', sjekker vi om
antallet 'A'-er telt opp i tabellen 'antall' er 0. Hvis vi ikke telte noen 'A'-er i strengen 'b', så er ikke 'a' inneholdt i 'b'.
Hvis antall 'A'-er telt opp i tabellen 'antall' er større enn 0, så trekker vi fra antall[bokstavNr('A')-65] med 1 og går videre i loopen.

WARNINGS KOMMENTARER:

Oblig1.java:

I oppgave 1 (metoden som starter i linje 71) har vi brukt en metode "gjennomsnitt" som ikke er en del av selve koden og blir ikke brukt i koden. Derfor får vi en warning på det.

I oppgave 4 (linje 162). Intellij ønsker å bytte for-loopen vår med en enhanced for-loop (for-each). Vi synes det var mer oversiktlig å beholde den for-loopen vi lagde.

I oppgave 5 (linje 249). Intellij vil bytte for-loop med innebygd metode. Det ønsker vi ikke.

I oppgave 7a og 7b så vil intellij at vi skal bruke String.append() istedenfor +=. Vi skjønner koden bedre når det står +=.

Oblig1UnitTest.java:

I linje 51 og 229 bruker assertTrows der metoden vi tester returnerer noe. Intellij gir oss en warning på at resultatet av disse metodene er oversett. Vi ønsker bare å se på unntakene å kjøre disse vil gi. Derfor overser vi disse warning-ene.
