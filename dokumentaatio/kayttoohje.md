# Käyttöohje

Lataa tiedosto [CastleAdventureGame-1.0.jar](https://github.com/tramsair/ot-harjoitustyo/releases/tag/julkaisu)

Ohjelma ei tarvitse muita tiedostoja

Tallentaessaan Ohjelma luo tiedoston "saveGame.txt" kansioon jossa se toimii. tallentaessa se myös ylikirjoittaa tiedostoon.

## Ohjelman käynnistäminen

Ohjelma Käynnistyy komennolla 

```
java -jar CastleAdventureGame-1.0.jar
```

## Pelaaminen

Peli ohjeistaa aktiivisesti saatavilla olevat komennot.

Aluksi peli vie pelaajan päävalikkoon jossa on mahdollisuus heittää kuusisivuista noppaa, aloittaa uusi peli, tai sammuttaa ohjelma.

Pelin voi myös tallentaa ja ladata, mutta se on mahdollista vain käynnistety pelin sisältä. Sammutettua peliä voi siis jatkaa jos tallennustiedosto on tallessa, mutta ensin pitää aloittaa uusi peli, josta ladata vanha peli uudestaan.

### Uusi peli

Uuden pelin valitessa peli kehottaa antamaan nimen uudelle hahmolle. Nimen saatuaan peli generoi hahmon automaattisesti. Hahmon ominaisuudet voi pelin aikana saada esille syötämällä komennon "c", kuten peli ohjeistaa. Tällöin tulee näytölle näkyviin hahmon nimi, ominaisuusarvot ja jäljellä olevat kestopisteet.

#### Haasteet
Peli rakentuu haasteiden ympärille. Hasteen kohdatessa antaa peli pelaajalle eteen ainakin kaksi vaihtoehtoa. Vaihtoehdosta riippuen peli valitsee yhden pelihahmon ominaisuusarvoista. Hasteilla on arvo, yleensä 20-30, ja voittaakseen haasteen, pitää pelaajahahmon ominaisuusarvon ja 20 sivuisen nopan silmäluvun summan ylittää haastearvo.

Haasteita voi kohdata tutkimalla aluetta jossa pelihahmo sijaitsee. Lisäksi kun pelihahmo siirtyy alueelta toiselle, on yksi kuudesta mahdollisuus että hän törmää matkalla haasteeseen.

Tutkimalla alueita ja voittamalla haasteita joita tulee vastaan voi löytää avaimia ja salakäytäviä jotka avaavat uusia alueita sekä reittejä.

#### Häviäminen
Epäonnistumisen tapahtuessa osa haasteista vähentää pelihahmolta yhden kestopisteen. Mikäli pelihahmon kestopisteet ovat missään vaiheessa nollassa, pelaaja häviää pelin, ja peli palauttaa pelaajan päävalikkoon.

Kestopisteitä saa takaisin lepäämällä joko pelin alkualueella "meadow", tai linnan asuintiloissa "rooms". kuitenkin levätessä on 1/6 mahdollisuus törmätä satunnaiskohtaamiseen.

#### Voittaminen
Pelin loppu on kun pelaaja on onnistunut läytämään avaimen tornin oveen, ja astuu sisälle torniin.
