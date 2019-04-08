CREATE TABLE IF NOT EXISTS Organization (
  id          INTEGER PRIMARY KEY,
  version     INTEGER NOT NULL,

  name        VARCHAR(50) NOT NULL,
  fullName    VARCHAR(50) NOT NULL,
  inn         VARCHAR(10) NOT NULL,
  kpp         VARCHAR(9)  NOT NULL,
  address     VARCHAR(50) NOT NULL,
  phone       VARCHAR(11) NOT NULL,
  isActive    INTEGER NOT NULL
);

COMMENT ON TABLE Organization IS 'Организация';


CREATE TABLE IF NOT EXISTS Office (
  id          INTEGER PRIMARY KEY,
  version     INTEGER NOT NULL,

  name        VARCHAR(50) NOT NULL,
  address     VARCHAR(50) NOT NULL,
  phone       INTEGER NOT NULL,
  isActive    INTEGER NOT NULL
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS User (
  id                  INTEGER PRIMARY KEY,
  version             INTEGER NOT NULL,

  first_Name           VARCHAR(50) NOT NULL,
  second_Name          VARCHAR(50) NOT NULL,
  middle_Name          VARCHAR(50) NOT NULL,
  position             VARCHAR(50) NOT NULL,
  phone                INTEGER     NOT NULL,
  doc_Name             VARCHAR(50) NOT NULL,
  doc_Number           INTEGER     NOT NULL,
  doc_Date             DATE        NOT NULL,
  citizenship_Name     VARCHAR(50) NOT NULL,
  citizenship_Code     INTEGER     NOT NULL,
  is_Identified        INTEGER     NOT NULL
);
COMMENT ON TABLE User IS 'Сотрудник';

CREATE TABLE IF NOT EXISTS Countries (
  code                INTEGER NOT NULL,
  name                VARCHAR(50) NOT NULL
);
COMMENT ON TABLE Countries IS 'Спарвочник стран';

CREATE TABLE IF NOT EXISTS Docks (
  code                INTEGER NOT NULL,
  name                VARCHAR(100) NOT NULL
);
COMMENT ON TABLE Docks IS 'Спарвочник документов';



