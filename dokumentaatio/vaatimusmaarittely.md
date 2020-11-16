# Vaatimusmäärittely
## Sovelluksen tarkoitus
Tarkoituksena on luoda simppeli roolipeli jossa kolutaan yksinkertaista linnaa. Pelaaja tekee päätöksiä ja peli heittää erilaisia noppia ratkaistakseen lopputuloksia
## Perustoiminnallisuus
Peli luo alkuun pelaajalle hahmon heittämällä noppia. Hahmolla on viisi ominaisuutta joiden suurus on kolmen kuusisivuisen nopan yhteenlaskettu tulos. Lisäksi pelaaja saa lisätä yhden nopan johonkin ominaisuuteen. Peli tallentaa ja päivittää hahmon tietoja pelin edetessä.

Pelin maailma on jakautunut alueisiin kuten "linnan piha" tai "linnan salit". Alueille määritellään viereiset alueet joihin ne ovat yhteydessä. Pelaaja voi liikuttaa hahmoaan alueesta toiseen.

Liikkumisen sijaan pelaaja voi valita hahmon tutkivan aluetta jossa hahmo sijaitsee. Tutkittaessa hahmo voi joko löytää esineitä tai kohdata haasteita. Haasteen kohdatessa pelaaja saa vaihtoehtoja. Selvittääkseen voittiko hahmo haasteen peli heittää noppaa ja lisää tulokseen jonkin hahmon ominaisuuksista, ja vertaa tulosta tavoitenumeroon. Mikäli tulos on alle, hahmo häviää haasteen. Mikäli tulos on sama tai yli, hahmo voittaa haasteen.

Pelillä on jokaiselle alueelle lista asioista joista alueella saatetaan kohdata, kun hahmo etsii. Peli arpoo listalta joka kerta mitä tapahtuu

