# Castle adventure -roolipeli
Pieni linnaseikkailu roolipeli.

Toistaiseksi toteutettu alustava nopanheitto toiminnallisuus, ja hahmon luonti, sekä hyvin alustava tekstikäyttöliittymä.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/tramsair/ot-harjoitustyo/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/tramsair/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/tramsair/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/tramsair/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Checkstyle

Checkstyle-testit thehdään komennolla 

```
 mvn jxr:jxr checkstyle:checkstyle
```
Virheilmoitukset saa selville avaamalla tiedosto _target/site/checkstyle.html_ selaimella

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```
Javadocin voi avata selaimella, se löytyy _target/site/apidocs/index.html_

###  Jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _CastleAdventureGame-1.0-SNAPSHOT.jar_
