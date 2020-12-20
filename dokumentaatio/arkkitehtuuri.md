# Arkkitehtuurikuvaus

### Rakenne

Peli jakautuu kolmeen osaan. Käyttöliittömään, "World" ja "työkalu" -luokkiin. "World" luokat mallintavat pelin maailmaa, ja sisältävät pääosan pelin informaatiosta. Työkalut sisältävät pelin satunnaisgeneraattoriluokan "Dice", kohtauksia mallintavan luokan "Encounter" ja pelaajahahmon "Hero".

![](/Pakkauskaavio.png)

## Käyttöliittymä

Pelin käyttöliittymä perustuu kahteen valikkoon, päävalikkoon ja pelivalikkoon. Varsinainen pelaaminen tapahtuu pelivalikossa, jonka päävalikko pelaajan käskystä käynnistää. Pelivalikon käynnistettäessä luo se automaattisesti aina uuden pelin.

Valikot pyörivät while-loopin avulla. Pelivalikko saa käytettävissä olevat komennot aina kyseiseltä pelialueluokalta jossa pelaajahahmo kulloinkin sijaitsee. Valikko lukee komentorivin syötettä, ja vertaa sitä tarjolla oleviin vaihtoehtoihin. Lisäksi, jos pelaajahahmo kohtaa haasten, käynnistää pelivalikko haaste-alivalikon, johon pelvalikko saa hyväksyttyä komentoa haasteelta(Encounter) joka on kyseessä ja aktiivinen.

Ajallisten rajoitusten johdosta tallentaminen tapahtuu pelivalikon sisällä, mikä on valitettavaa.

## Area -luokat

Area -luokat world-pakkauksen sisällä sisältävät pääosan pelin informaatiosta ja logiikasta. Pelivalikko aktivoi aina kerrallaan yhden area-luokan, joka sisältää tiedon sen naapureista, toiminnoista jotka ovat saatavilla, alueen sisältämät haasteet, sekä myös avaa tai pitää suljettuna hahmon etenemiseen liittyvät vaihtoehdon, kuten lukitut ovet tai löydetyt salakäytävät.
