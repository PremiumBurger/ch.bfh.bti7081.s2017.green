# Teamgreen PMS App

## Tech Stack
* **Maven** `v3` [Doc](http://maven.apache.org/guides/)
* **Vaadin** `v8.0.5` [Doc](https://vaadin.com/docs/)
* **Spring Boot** `v1.5.2.RELEASE` [Doc](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/)
* **Spring Data JPA** `v1.11.1.RELEASE` [Doc](http://projects.spring.io/spring-data-jpa/#quick-start)
* **Liquibase** `v3.5.3` [Doc](http://www.liquibase.org/documentation/)
* **MySQL** `v5.7.17` [Doc](https://dev.mysql.com/doc/refman/5.7/en/)
* **HSQLDB** `v2.3.4` [Doc](http://hsqldb.org/web/hsqlDocsFrame.html) (for dev + test)

## Start Application
* **Commandline:** _mvn spring-boot:run_
* **IDE:** Run Class _ch.bfh.bti7081.s2017.green.AppStart_

## Configuration

### Allgemeine Application Properties
Application Properties Files befinden sich unter `src/main/resources`.

Custom Configs können im Filter-File `src/main/filters/filter-Local-application.properties` definiert werden. Maven ersetzt diese Configs in allen Files unter `src/main/resources` (Filtering). Diese können über die Notation `${config.key}` angesprochen werden und werden in der Maven resources Phase ersetzt.

### Switch zwischen HSQLDB und MySQL
File: `/teamgreen-pms-app/src/main/filters/filter-Local-application.properties`

Entsprechende Konfig ein- / auskommentieren. Wenn MySQL ausgewählt wird, muss ein MySQL Server und die entsprechende Datenbank auf den lokalen Rechner installiert sein.

HSQLDB Config:
```
jdbc.driver=org.hsqldb.jdbcDriver
jdbc.url=jdbc:hsqldb:mem:teamgreen
jdbc.username=sa
jdbc.password=
```

MySQL Config:
```
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/teamgreen?serverTimezone=UTC&nullNamePatternMatchesAll=true&useSSL=false
jdbc.username=root
jdbc.password=root
```

