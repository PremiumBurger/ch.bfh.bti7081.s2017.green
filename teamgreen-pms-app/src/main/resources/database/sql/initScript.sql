--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: src/main/resources/database/all.changelog-master.xml
--  Ran at: 11/05/17 18:06
--  Against: root@localhost@jdbc:mysql://localhost:3306/teamgreen?serverTimezone=UTC&nullNamePatternMatchesAll=true&useSSL=false
--  Liquibase version: 3.5.3
--  *********************************************************************

--  Lock Database
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = '192.168.154.129 (192.168.154.129)', LOCKGRANTED = '2017-05-11 18:06:25.085' WHERE ID = 1 AND LOCKED = 0;

--  Changeset src/main/resources/database/schema.changelog-master.xml::1::vonac1
CREATE TABLE GenderType (id BIGINT AUTO_INCREMENT NOT NULL, description VARCHAR(50) NULL, CONSTRAINT PK_GENDERTYPE PRIMARY KEY (id));

CREATE TABLE Address (id BIGINT AUTO_INCREMENT NOT NULL, strasse VARCHAR(255) NULL, plz VARCHAR(6) NULL, city VARCHAR(255) NULL, country VARCHAR(50) NULL, CONSTRAINT PK_ADDRESS PRIMARY KEY (id));

CREATE TABLE Person (id BIGINT AUTO_INCREMENT NOT NULL, personType VARCHAR(50) NOT NULL, addressId BIGINT NULL, genderTypeId BIGINT NOT NULL, firstName VARCHAR(255) NULL, lastName VARCHAR(255) NULL, birthDate date NULL, phone VARCHAR(50) NULL, mobile VARCHAR(50) NULL, ahvNr VARCHAR(16) NULL, email VARCHAR(255) NULL, CONSTRAINT PK_PERSON PRIMARY KEY (id), CONSTRAINT fk_person_address FOREIGN KEY (addressId) REFERENCES Address(id), CONSTRAINT fk_person_gender FOREIGN KEY (genderTypeId) REFERENCES GenderType(id));

CREATE TABLE Alarm (id BIGINT AUTO_INCREMENT NOT NULL, healthVisitorId BIGINT NOT NULL, patientId BIGINT NULL, coordinates VARCHAR(255) NULL, timestamp timestamp NULL, CONSTRAINT PK_ALARM PRIMARY KEY (id), CONSTRAINT fk_alarm_patient FOREIGN KEY (patientId) REFERENCES Person(id), CONSTRAINT fk_alarm_healthvisitor FOREIGN KEY (healthVisitorId) REFERENCES Person(id));

CREATE TABLE Appointment (id BIGINT AUTO_INCREMENT NOT NULL, healthVisitorId BIGINT NOT NULL, patientId BIGINT NULL, intendedDateTime timestamp NULL, CONSTRAINT PK_APPOINTMENT PRIMARY KEY (id), CONSTRAINT fk_alarm_healthvisitor FOREIGN KEY (healthVisitorId) REFERENCES Person(id), CONSTRAINT fk_alarm_patient FOREIGN KEY (patientId) REFERENCES Person(id));

CREATE TABLE PatientHealthVisitor (patientId BIGINT NOT NULL, healthVisitorId BIGINT NOT NULL, CONSTRAINT PK_PATIENTHEALTHVISITOR PRIMARY KEY (patientId, healthVisitorId), CONSTRAINT fk_pat_heal_patient FOREIGN KEY (patientId) REFERENCES Person(id), CONSTRAINT fk_pat_heal_healthvisitor FOREIGN KEY (healthVisitorId) REFERENCES Person(id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1', 'vonac1', 'src/main/resources/database/schema.changelog-master.xml', NOW(), 1, '7:e12ff7b8106600e2fabd988e67ba4a5b', 'createTable tableName=GenderType; createTable tableName=Address; createTable tableName=Person; createTable tableName=Alarm; createTable tableName=Appointment; createTable tableName=PatientHealthVisitor', '', 'EXECUTED', NULL, NULL, '3.5.3', '4518786755');

--  Changeset src/main/resources/database/basedata.changelog-master.xml::basedata::vonac1
INSERT INTO GenderType (id, description) VALUES ('1', 'Male');

INSERT INTO GenderType (id, description) VALUES ('2', 'Female');

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('basedata', 'vonac1', 'src/main/resources/database/basedata.changelog-master.xml', NOW(), 2, '7:36dae9cb949d5cff4e7b6315d3bf7dae', 'insert tableName=GenderType; insert tableName=GenderType', '', 'EXECUTED', NULL, NULL, '3.5.3', '4518786755');

--  Changeset src/main/resources/database/testdata.changelog-master.xml::testdata::vonac1
INSERT INTO Address (id, strasse, plz, city, country) VALUES ('1', 'Wankdorffeldstrasse 5', '3000', 'Bern', 'CH');

INSERT INTO Address (id, strasse, plz, city, country) VALUES ('2', 'Ortsweg 3', '3600', 'Thun', 'CH');

INSERT INTO Address (id, strasse, plz, city, country) VALUES ('3', 'Postweg 17', '3110', 'Münsingen', 'CH');

INSERT INTO Person (id, personType, addressId, genderTypeId, firstName, lastName, birthDate, phone, mobile, ahvNr, email) VALUES ('1', 'healthvisitor', '1', '2', 'Sabine', 'Pitex', '2017-08-15', '077 777 77 77', '088 888 88 88', '756.2831.3945.39', 'sabi@yeah.ch');

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('testdata', 'vonac1', 'src/main/resources/database/testdata.changelog-master.xml', NOW(), 3, '7:d7e1dc33ecd35476ab74eace5331e765', 'insert tableName=Address; insert tableName=Address; insert tableName=Address; insert tableName=Person', '', 'EXECUTED', NULL, NULL, '3.5.3', '4518786755');

--  Release Database Lock
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

