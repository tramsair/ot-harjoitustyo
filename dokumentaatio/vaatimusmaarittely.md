# Vaatimusmäärittely
## Sovelluksen tarkoitus
Tarkoituksena on luoda simppeli roolipeli jossa kolutaan yksinkertaista linnaa. Pelaaja tekee päätöksiä ja peli heittää erilaisia noppia ratkaistakseen lopputuloksia
## Perustoiminnallisuus
* Peli kykenee heittämään useanlaisia noppia #Valmis
* Peli luo alkuun pelaajalle hahmon heittämällä noppia. Hahmolla on viisi ominaisuutta joiden suurus on kolmen kuusisivuisen nopan yhteenlaskettu tulos.#Valmis Peli tallentaa ja päivittää hahmon tietoja pelin edetessä. Lisäksi hahmolla on kymmenen *kestopistettä*.
* Pelin maailma on jakautunut alueisiin kuten "linnan piha" tai "linnan salit". Alueille määritellään viereiset alueet joihin ne ovat yhteydessä. Pelaaja voi liikuttaa hahmoaan alueesta toiseen.#Ensimmäinen iteraatio valmis
* Peli kuvailee tapahtumia ja alueita pelaajalle tekstin välityksellä.#toiminnallisuus valmis
* Pelillä on jokaista aluetta kohden oma lista asioista joita pelaajan hahmo saattaa alueella kohda sinne siirtyessään. Nämä asiat ovat usein **haasteita**.#Ensimmäinen iteraatio valmis
* Hahmon kohdatessa haasteen peli antaa pelaajalle vaihtoehtoja joista pelaaja voi valita.
* Peli heittää noppaa hahmolle ja/tai haasteelle, ja lisää tulokseen asiaan kuuluvan ominaisuuden. Sitten peli vertaa joko tuloksia toisiinsa, tai johonkin vakioon. Tämän periaatteen perusteella peli määrittelee voittiko vai hävisikö hahmo haasteelle.#Toiminnallsiuus valmis
* Usein häviö johtaa siihen että hahmo menettää kestopisteen. Mikäli hahmon kestopisteet laskevat nollaan, häviää pelaaja pelin.


## Jatkokehitysideoita
* Hahmo voi löytää esineitä, jotka helpottavat tai mahdollistavat etenemisen pelissä. Esimerkkinä avaimet yms.
* Tietyillä alueilla voi tehdä erityistoimintoja liikkumisen ja tutkimisen lisäksi.
* Mahdollisuus tallentaa peli
* Alueet muuttuvat pysyvästi pelaajan tehdessä asioita niissä.
* Olio joka liikkuu alueeiden välillä/jahtaa pelaajan hahmoa
