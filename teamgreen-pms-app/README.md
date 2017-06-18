# Teamgreen PMS App

## Tech Stack
* **Maven** `v3` [Doc](http://maven.apache.org/guides/)
* **Vaadin** `v8.0.5` [Doc](https://vaadin.com/docs/)
* **Spring Boot** `v1.4.1.RELEASE` [Doc](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/)
* **Spring Data JPA** `v1.11.1.RELEASE` [Doc](http://projects.spring.io/spring-data-jpa/#quick-start)
* **Liquibase** `v3.5.3` [Doc](http://www.liquibase.org/documentation/)
* **MySQL** `v5.7.17` [Doc](https://dev.mysql.com/doc/refman/5.7/en/)
* **HSQLDB** `v2.3.4` [Doc](http://hsqldb.org/web/hsqlDocsFrame.html) (for dev + test)

## Installationsanleitung

### Installation Datenbank
Damit das PMS startet muss folgende MySQL Datenbank lokal aufgesetzt werden:

* Schema: `teamgreen`
* User: `root`
* Password: `Spring.17`

### Applikation builden
Damit alle Komponenten geladen werden muss auf root Ebene (äusserte Ebene des geklonten Git Projekts) einmal gebuildet werden.
Im Root Verzeichnis folgenden Befehl ausführen `mvn clean install`

### Applikation starten
* Im Verzeichnis `teamgreen-pms-app` den Befehl `mvn spring-boot:run` ausführen
* Unter `localhost:8080` Applikation aufrufen

Um die Applikation über die IDE laufen zu lasssen, muss ein entsprechender Maventask in der IDE erfasst und ausgeführt werden.

## Configuration

### Allgemeine Application Properties
Application Properties Files befinden sich unter `src/main/resources`.

Custom Configs können im Filter-File `src/main/filters/filter-Local-application.properties` definiert werden. Maven ersetzt diese Configs in allen Files unter `src/main/resources` (Filtering). Diese können über die Notation `${config.key}` angesprochen werden und werden in der Maven resources Phase ersetzt.

