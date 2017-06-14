--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: src/main/resources/database/all.changelog-master.xml
--  Ran at: 5/21/17 11:44 AM
--  Against: root@localhost@jdbc:mysql://localhost:3306/teamgreen?serverTimezone=UTC&nullNamePatternMatchesAll=true&useSSL=false
--  Liquibase version: 3.5.3
--  *********************************************************************

--  Create Database Lock Table
CREATE TABLE DATABASECHANGELOGLOCK (ID INT NOT NULL, LOCKED BIT(1) NOT NULL, LOCKGRANTED datetime NULL, LOCKEDBY VARCHAR(255) NULL, CONSTRAINT PK_DATABASECHANGELOGLOCK PRIMARY KEY (ID));

--  Initialize Database Lock Table
DELETE FROM DATABASECHANGELOGLOCK;

INSERT INTO DATABASECHANGELOGLOCK (ID, LOCKED) VALUES (1, 0);

--  Lock Database
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = 'macbook.bfh.ch (147.87.41.46)', LOCKGRANTED = '2017-05-21 11:44:21.794' WHERE ID = 1 AND LOCKED = 0;

--  Create Database Change Log Table
CREATE TABLE DATABASECHANGELOG (ID VARCHAR(255) NOT NULL, AUTHOR VARCHAR(255) NOT NULL, FILENAME VARCHAR(255) NOT NULL, DATEEXECUTED datetime NOT NULL, ORDEREXECUTED INT NOT NULL, EXECTYPE VARCHAR(10) NOT NULL, MD5SUM VARCHAR(35) NULL, DESCRIPTION VARCHAR(255) NULL, COMMENTS VARCHAR(255) NULL, TAG VARCHAR(255) NULL, LIQUIBASE VARCHAR(20) NULL, CONTEXTS VARCHAR(255) NULL, LABELS VARCHAR(255) NULL, DEPLOYMENT_ID VARCHAR(10) NULL);

--  Changeset src/main/resources/database/schema.changelog-master.xml::1::vonac1
CREATE TABLE GenderType (id BIGINT AUTO_INCREMENT NOT NULL, description VARCHAR(50) NULL, CONSTRAINT PK_GENDERTYPE PRIMARY KEY (id));

CREATE TABLE Address (id BIGINT AUTO_INCREMENT NOT NULL, strasse VARCHAR(255) NULL, plz VARCHAR(6) NULL, city VARCHAR(255) NULL, country VARCHAR(50) NULL, CONSTRAINT PK_ADDRESS PRIMARY KEY (id));

CREATE TABLE Person (id BIGINT AUTO_INCREMENT NOT NULL, personType VARCHAR(50) NOT NULL, addressId BIGINT NULL, genderTypeId BIGINT NOT NULL, firstName VARCHAR(255) NULL, lastName VARCHAR(255) NULL, birthDate date NULL, phone VARCHAR(50) NULL, mobile VARCHAR(50) NULL, ahvNr VARCHAR(16) NULL, email VARCHAR(255) NULL, externalkey VARCHAR(255), CONSTRAINT PK_PERSON PRIMARY KEY (id), CONSTRAINT fk_person_gender FOREIGN KEY (genderTypeId) REFERENCES GenderType(id), CONSTRAINT fk_person_address FOREIGN KEY (addressId) REFERENCES Address(id));

CREATE TABLE Alarm (id BIGINT AUTO_INCREMENT NOT NULL, healthVisitorId BIGINT NOT NULL, patientId BIGINT NULL, coordinates VARCHAR(255) NOT NULL, timestamp timestamp NOT NULL, CONSTRAINT PK_ALARM PRIMARY KEY (id), CONSTRAINT fk_alarm_healthvisitor FOREIGN KEY (healthVisitorId) REFERENCES Person(id), CONSTRAINT fk_alarm_patient FOREIGN KEY (patientId) REFERENCES Person(id));

CREATE TABLE Appointment (id BIGINT AUTO_INCREMENT NOT NULL, healthVisitorId BIGINT NOT NULL, patientId BIGINT NULL, `from` timestamp NULL, `to` timestamp NULL, CONSTRAINT PK_APPOINTMENT PRIMARY KEY (id), CONSTRAINT fk_appointment_patient FOREIGN KEY (patientId) REFERENCES Person(id), CONSTRAINT fk_appointment_healthvisitor FOREIGN KEY (healthVisitorId) REFERENCES Person(id));

CREATE TABLE Journal (id BIGINT AUTO_INCREMENT NOT NULL, patientId BIGINT NULL, createdOn timestamp NOT NULL, CONSTRAINT PK_JOURNAL PRIMARY KEY (id), CONSTRAINT fk_journal_patient FOREIGN KEY (patientId) REFERENCES Person(id));

CREATE TABLE JournalEntry (id BIGINT AUTO_INCREMENT NOT NULL, journalEntryType BIGINT NOT NULL, journalId BIGINT NOT NULL, text VARCHAR(2000) NULL, isImportant BIT(1) NOT NULL, appointmentId BIGINT NULL, createdBy VARCHAR(200) NOT NULL, createdOn timestamp NOT NULL, modifiedOn timestamp NULL, CONSTRAINT PK_JOURNALENTRY PRIMARY KEY (id), CONSTRAINT fk_journalentry_appointment FOREIGN KEY (appointmentId) REFERENCES Appointment(id), CONSTRAINT fk_journalentry_journal FOREIGN KEY (journalId) REFERENCES Journal(id));

CREATE TABLE PatientHealthVisitor (patientId BIGINT NOT NULL, healthVisitorId BIGINT NOT NULL, CONSTRAINT PK_PATIENTHEALTHVISITOR PRIMARY KEY (patientId, healthVisitorId), CONSTRAINT fk_pat_heal_healthvisitor FOREIGN KEY (healthVisitorId) REFERENCES Person(id), CONSTRAINT fk_pat_heal_patient FOREIGN KEY (patientId) REFERENCES Person(id));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1', 'vonac1', 'src/main/resources/database/schema.changelog-master.xml', NOW(), 1, '7:c11cb75bbb0ee9f26c3e6b352cfd5030', 'createTable tableName=GenderType; createTable tableName=Address; createTable tableName=Person; createTable tableName=Alarm; createTable tableName=Appointment; createTable tableName=Journal; createTable tableName=JournalEntry; createTable tableName...', '', 'EXECUTED', NULL, NULL, '3.5.3', '5359862815');

--  Changeset src/main/resources/database/basedata.changelog-master.xml::basedata::vonac1
INSERT INTO GenderType (id, description) VALUES ('1', 'Male');

INSERT INTO GenderType (id, description) VALUES ('2', 'Female');

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('basedata', 'vonac1', 'src/main/resources/database/basedata.changelog-master.xml', NOW(), 2, '7:36dae9cb949d5cff4e7b6315d3bf7dae', 'insert tableName=GenderType; insert tableName=GenderType', '', 'EXECUTED', NULL, NULL, '3.5.3', '5359862815');

--  Changeset src/main/resources/database/testdata.changelog-master.xml::testdata::vonac1
INSERT INTO Address (id, strasse, plz, city, country) VALUES ('1', 'Wankdorffeldstrasse 5', '3000', 'Bern', 'CH');

INSERT INTO Address (id, strasse, plz, city, country) VALUES ('2', 'Ortsweg 3', '3600', 'Thun', 'CH');

INSERT INTO Address (id, strasse, plz, city, country) VALUES ('3', 'Postweg 17', '3110', 'Münsingen', 'CH');

INSERT INTO Person (id, personType, addressId, genderTypeId, firstName, lastName, birthDate, phone, mobile, ahvNr, email) VALUES ('1', 'healthvisitor', '1', '2', 'Sabine', 'Pitex', '2017-08-15', '077 777 77 77', '088 888 88 88', '756.2831.3945.39', 'sabi@yeah.ch');

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('testdata', 'vonac1', 'src/main/resources/database/testdata.changelog-master.xml', NOW(), 3, '7:d7e1dc33ecd35476ab74eace5331e765', 'insert tableName=Address; insert tableName=Address; insert tableName=Address; insert tableName=Person', '', 'EXECUTED', NULL, NULL, '3.5.3', '5359862815');

--  Changeset src/main/resources/database/testdata.changelog-master.xml::testdata_2::schms27
INSERT INTO Person (id, personType, addressId, genderTypeId, firstName, lastName, birthDate, phone, mobile, ahvNr, email) VALUES ('2', 'patient', '3', '1', 'Beat', 'Orderline', '1980-08-15', '077 555 55 25', '088 544 54 25', '756.2821.3225.39', 'beat@mail.ch');

INSERT INTO Appointment (id, healthVisitorId, patientId, `from`, `to`) VALUES ('1', '1', '2', '2017-10-30 08:00:00', '2017-10-30 10:00:00');

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('testdata_2', 'schms27', 'src/main/resources/database/testdata.changelog-master.xml', NOW(), 4, '7:399a1a922df621da375890b37b377726', 'insert tableName=Person; insert tableName=Appointment', '', 'EXECUTED', NULL, NULL, '3.5.3', '5359862815');

--  Release Database Lock
UPDATE DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

