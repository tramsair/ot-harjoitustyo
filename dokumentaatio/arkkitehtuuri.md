#Arkkitehtuurikuvaus

###Rakenne

Peli jakautuu kolmeen osaan. Käyttöliittömään, "world" ja "työkalu" -luokkiin. "World" luokat mallintavat pelin maailmaa, ja sisältävät pääosan pelin informaatiosta. Työkalut sisältävät pelin satunnaisgeneraattoriluokan "Dice", kohtauksia mallintavan luokan "Encounter" ja pelaajahahmon "Hero".

![](/Pakkauskaavio.png)

##Käyttöliittymä

Pelin käyttöliittymä perustuu kahteen valikkoon, päävalikkoon ja pelivalikkoon. Varsinainen pelaaminen tapahtuu pelivalikossa, jonka päävalikko pelaajan käskystä käynnistää. Pelivalikon käynnistettäessä luo se automaattisesti aina uuden pelin.

Valikot pyörivät while-loopin avulla. Pelivalikko saa käytettävissä olevat komennot aina kyseiseltä pelialueluokalta jossa pelaajahahmo kulloinkin sijaitsee. Valikko lukee komentorivin syötettä, ja vertaa sitä tarjolla oleviin vaihtoehtoihin. Lisäksi, jos pelaajahahmo kohtaa haasten, käynnistää pelivalikko haaste-alivalikon, johon pelvalikko saa hyväksyttyä komentoa haasteelta(Encounter) joka on kyseessä ja aktiivinen.
