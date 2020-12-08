# Käyttöohje

Lataa tiedosto [castleadventuregameV0.1.jar](https://github.com/tramsair/ot-harjoitustyo/releases/tag/viikko6)

Ohjelma ei tarvitse muita tiedostoja


## Ohjelman käynnistäminen

Ohjelma Käynnistyy komennolla 

```
java -jar castleadventuregameV0.1.jar
```

## Pelaaminen

Peli ohjeistaa aktiivisesti saatavilla olevat komennot.

Aluksi peli vie pelaajan päävalikkoon jossa on mahdollisuus heittää kuusisivuista noppaa, aloittaa uusi peli, tai sammuttaa ohjelma.

### Uusi peli

Uuden pelin valitessa peli kehottaa antamaan nimen uudelle hahmolle. Nimen saatuaan peli generoi hahmon automaattisesti. Hahmon ominaisuudet voi pelin aikana saada esille syötämällä komennon "c", kuten peli ohjeistaa. Tällöin tulee näytölle näkyviin hahmon nimi, ominaisuusarvot ja jäljellä olevat kestopisteet.

#### Haasteet
Peli rakentuu haasteiden ympärille. Hasteen kohdatessa antaa peli pelaajalle eteen ainakin kaksi vaihtoehtoa. Vaihtoehdosta riippuen peli valitsee yhden pelihahmon ominaisuusarvoista. Hasteilla on arvo, yleensä 20-30, ja voittaakseen haasteen, pitää pelaajahahmon ominaisuusarvon ja 20 sivuisen nopan silmäluvun summan ylittää haastearvo.

Haasteita voi kohdata tutkimalla aluetta jossa pelihahmo sijaitsee. Lisäksi kun pelihahmo siirtyy alueelta toiselle, on yksi kuudesta mahdollisuus että hän törmää matkalla haasteeseen.

#### Häviäminen
Epäonnistumisen tapahtuessa osa haasteista vähentää pelihahmolta yhden kestopisteen. Mikäli pelihahmon kestopisteet ovat missään vaiheessa nollassa, pelaaja häviää pelin, ja peli palauttaa pelaajan päävalikkoon.
