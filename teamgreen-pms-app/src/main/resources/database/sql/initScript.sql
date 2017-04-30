-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: src/main/resources/database/all.changelog-master.xml
-- Ran at: 28/04/17 08:47
-- Against: SA@jdbc:hsqldb:mem:teamgreen
-- Liquibase version: 3.5.3
-- *********************************************************************

-- Create Database Lock Table
CREATE TABLE DATABASECHANGELOGLOCK (ID INT NOT NULL, LOCKED BOOLEAN NOT NULL, LOCKGRANTED TIMESTAMP, LOCKEDBY VARCHAR(255), CONSTRAINT PK_DATABASECHANGELOGLOCK PRIMARY KEY (ID));

-- Initialize Database Lock Table
DELETE FROM DATABASECHANGELOGLOCK;

INSERT INTO DATABASECHANGELOGLOCK (ID, LOCKED) VALUES (1, FALSE);

-- Lock Database
UPDATE DATABASECHANGELOGLOCK SET LOCKED = TRUE, LOCKEDBY = '192.168.154.129 (192.168.154.129)', LOCKGRANTED = '2017-04-28 08:47:30.590' WHERE ID = 1 AND LOCKED = FALSE;

-- Create Database Change Log Table
CREATE TABLE DATABASECHANGELOG (ID VARCHAR(255) NOT NULL, AUTHOR VARCHAR(255) NOT NULL, FILENAME VARCHAR(255) NOT NULL, DATEEXECUTED TIMESTAMP NOT NULL, ORDEREXECUTED INT NOT NULL, EXECTYPE VARCHAR(10) NOT NULL, MD5SUM VARCHAR(35), DESCRIPTION VARCHAR(255), COMMENTS VARCHAR(255), TAG VARCHAR(255), LIQUIBASE VARCHAR(20), CONTEXTS VARCHAR(255), LABELS VARCHAR(255), DEPLOYMENT_ID VARCHAR(10));

-- Changeset src/main/resources/database/schema.changelog-master.xml::1::vonac1
CREATE TABLE HealthVisitor (healthVisitorId BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, firstName VARCHAR(50), lastName VARCHAR(50), CONSTRAINT PK_HEALTHVISITOR PRIMARY KEY (healthVisitorId));

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1', 'vonac1', 'src/main/resources/database/schema.changelog-master.xml', NOW, 1, '7:a7a0e2614219edab83fbcb89ceb94f6b', 'createTable tableName=HealthVisitor', '', 'EXECUTED', NULL, NULL, '3.5.3', '3362052007');

-- Changeset src/main/resources/database/testdata.changelog-master.xml::testdata::vonac1
INSERT INTO HealthVisitor (healthVisitorId, firstName, lastName) VALUES ('1', 'Sabine', 'Pitex');

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('testdata', 'vonac1', 'src/main/resources/database/testdata.changelog-master.xml', NOW, 2, '7:3353bb4a991b0c6fffc78f4b3db817f8', 'insert tableName=HealthVisitor', '', 'EXECUTED', NULL, NULL, '3.5.3', '3362052007');

-- Release Database Lock
UPDATE DATABASECHANGELOGLOCK SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;
