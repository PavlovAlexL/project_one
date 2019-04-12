CREATE TABLE IF NOT EXISTS Country (
  code                INTEGER NOT NULL PRIMARY KEY ,
  name                VARCHAR(50) NOT NULL
);
COMMENT ON TABLE Country IS 'Спарвочник стран';

CREATE TABLE IF NOT EXISTS Dockument (
  code                INTEGER NOT NULL PRIMARY KEY ,
  name                VARCHAR(100) NOT NULL
);
COMMENT ON TABLE Dockument IS 'Спарвочник документов';

CREATE TABLE IF NOT EXISTS Position (
  code                INTEGER NOT NULL PRIMARY KEY ,
  name                VARCHAR(100) NOT NULL
);
COMMENT ON TABLE Position IS 'Спарвочник должностей';







CREATE TABLE IF NOT EXISTS Organization (
  id          INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  version     INTEGER,

  name        VARCHAR(50) NOT NULL,
  fullName    VARCHAR(50) NOT NULL,
  inn         VARCHAR(10) NOT NULL,
  kpp         VARCHAR(9)  NOT NULL,
  address     VARCHAR(100) NOT NULL,
  phone       VARCHAR(11) ,
  isActive    VARCHAR(5) DEFAULT 'true'
);
COMMENT ON TABLE Organization IS 'Организация';


CREATE TABLE IF NOT EXISTS Office (
  id          INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  version     INTEGER,

  orgId       INTEGER NOT NULL REFERENCES Organization(id),
  name        VARCHAR(50),
  address     VARCHAR(100),
  phone       VARCHAR(11),
  isActive    VARCHAR(5) DEFAULT 'true'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS User (
  id                  INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  version             INTEGER,

  officeId            INTEGER NOT NULL REFERENCES Office(id),
  first_Name           VARCHAR(50) NOT NULL,
  second_Name          VARCHAR(50) ,
  middle_Name          VARCHAR(50) ,
  position             VARCHAR(50) NOT NULL REFERENCES Position(name),
  phone                VARCHAR(11) ,
  doc_Name             VARCHAR(50) ,
  doc_Number          INTEGER REFERENCES Dockument(code),
  doc_Date             DATE        ,
  citizenship_Name     VARCHAR(50) ,
  citizenship_Code    INTEGER      ,
  is_Identified        VARCHAR(5) DEFAULT 'true'
);
COMMENT ON TABLE User IS 'Сотрудник';
