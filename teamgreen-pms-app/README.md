# Teamgreen PMS App

## Tech Stack
* Maven _v3_ [Doc](http://maven.apache.org/guides/)
* Vaadin _v8.0.5_ [Doc](https://vaadin.com/docs/)
* Spring Boot _v1.5.2.RELEASE_ [Doc](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/)
* Spring Data JPA _v1.11.1.RELEASE_ (Repositories) [Doc](http://projects.spring.io/spring-data-jpa/#quick-start)
* Liquibase _v3.5.3_ [Doc](http://www.liquibase.org/documentation/)
* MySQL _v5.7.17_ [Doc](https://dev.mysql.com/doc/refman/5.7/en/)
* HSQLDB _v2.3.4_ [Doc](http://hsqldb.org/web/hsqlDocsFrame.html) (for dev + test)

## Start Application
* Commandline: _mvn spring-boot:run_
* IDE: Run Class _ch.bfh.bti7081.s2017.green.AppStart

## Configuration

### Allgemeine Application Properties
Allgemeine Application Properties können über das File _teamgreen-pms-app/src/main/resources/application.properties_ gemacht werden.

### Switch zwischen HSQLDB und MySQL
File: _/teamgreen-pms-app/src/main/filters/filter-Local-application.properties_

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

