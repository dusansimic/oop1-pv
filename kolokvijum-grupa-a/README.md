<h2>Zadatak</h2>
Apstraktna klasa <code><a href="https://github.com/andrewtomas/oop1-pv/blob/kolokvijum-grupa-a/kolokvijum-grupa-a/src/Pivo.java">Pivo</a></code> ima atribute proizvođač, jačinu (u procentima), boju i tip.
Apstraktna klasa ima get-ere, set-ere, toString metod i apstraktni metod:
<code>abstract boolean jeIzlapelo()</code> - ​ vraća da li je pivo pitko.
<br>
<br>
<a href="https://github.com/andrewtomas/oop1-pv/blob/kolokvijum-grupa-a/kolokvijum-grupa-a/src/PsecnicnoPivo.java">Pšenično pivo</a>, kraft pivo i crveno pivo nasleđuju klasu Pivo. 
Pšenično pivo je žuto ili narandžasto (50% šanse), jačinu od 5-6%. Ovo pivo je pitko u 90% slučajeva.
<br>

<a href="https://github.com/andrewtomas/oop1-pv/blob/kolokvijum-grupa-a/kolokvijum-grupa-a/src/KraftPivo.java">Kraft pivo</a> može biti nasumične boje (odabrati proizvoljno), i jačinu od 6-11%. Ovo je
pivo je pitko od 70-90% slučajeva.
<br>
<a href="https://github.com/andrewtomas/oop1-pv/blob/kolokvijum-grupa-a/kolokvijum-grupa-a/src/CrvenoPivo.java">Crveno pivo</a> je pivo jačine 8% i pitko je u 50% slučajeva.

Za sva 3 piva, potrebno je definisati metod <code>jeIzlapelo()</code> 
na osnovu gorenavedenih informacija.

Interfejs <code><a href="https://github.com/andrewtomas/oop1-pv/blob/kolokvijum-grupa-a/kolokvijum-grupa-a/src/Sanker.java">Sanker</a></code> ima sledeći metod:
<code>void posluziPivo()</code>

Klasa <code><a href="https://github.com/andrewtomas/oop1-pv/blob/kolokvijum-grupa-a/kolokvijum-grupa-a/src/Kafana.java">Kafana</a></code> implementira interfejs ​ Sanker ​ i sadrži polje sa nizom piva koja se mogu
poslužiti. Piva se ucitavaju iz fajla “povoteka.txt”, a fajl je organizovan na sledeci nacin:
- U prvom redu se nalazi broj piva
- U svakom narednom redu se nalazi informacija o pojedinacnom pivu u formatu
“proizvodjac”;”tip”

Takođe sadrži ime i adresu kafane, kao i polje ukupnoPosluzenihPiva. Od metoda ima
<code>toString</code> metod koji vraća ime kafane i ukupnu količinu piva. Metod <code>posluziPivo</code> prolazi
kroz niz piva, poslužuje ih ukoliko su pitka, te poveća brojač <code>ukupnoPosluzenihPiva</code>. Pre
posluzivanja svih piva u kafani, potrebno ih je sortirati po jacini. Od najslabijeg ka
najjacem. Napraviti get metod za polje <code>ukupnoPosluzenihPiva</code>. Klasa Kafana sadrži
metod koji vraća prosečnu jačinu piva u kafani. U glavnoj klasi (<code><a href="https://github.com/andrewtomas/oop1-pv/blob/kolokvijum-grupa-a/kolokvijum-grupa-a/src/Main.java">Main</a></code>) potrebno je napraviti 
instancu klase Kafana i pozvati sve metode.
