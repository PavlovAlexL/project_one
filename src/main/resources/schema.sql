CREATE TABLE IF NOT EXISTS Country (
  id                    INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  code                  VARCHAR(10) NOT NULL,
  name                  VARCHAR(50) NOT NULL
);
COMMENT ON TABLE Country IS 'Справочник - клаcсификатор стран';
COMMENT ON COLUMN Country.id IS 'id';
COMMENT ON COLUMN Country.name IS 'Наименование страны';
COMMENT ON COLUMN Country.code IS 'Код страны';

CREATE TABLE IF NOT EXISTS Document_type (
  id                    INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  code                  VARCHAR(10) NOT NULL,
  name                  VARCHAR(100) NOT NULL
);
COMMENT ON TABLE  Document_type IS 'Справочник - классификатор документов';
COMMENT ON COLUMN Document_type.id IS 'id';
COMMENT ON COLUMN Document_type.name IS 'Наименование документа';
COMMENT ON COLUMN Document_type.code IS 'Код документа';

CREATE TABLE IF NOT EXISTS User_document(
  id                   INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  version              INTEGER NOT NULL DEFAULT 1,
  doc_type_id          INTEGER NOT NULL REFERENCES Document_type(id),
  doc_number           VARCHAR(20) NOT NULL,
  doc_date             DATE NOT NULL
);
COMMENT ON TABLE User_document IS 'Таблица хранения реквизитов сотрудников';
COMMENT ON COLUMN User_document.id IS '';
COMMENT ON COLUMN User_document.version IS 'Служебное поле hibernate, должно быть NOT NULL';
COMMENT ON COLUMN User_document.doc_type_id IS 'Тип документа, связан с DocumentTypeEntity.id';
COMMENT ON COLUMN User_document.doc_number IS 'Номер документа';
COMMENT ON COLUMN User_document.doc_date IS 'Дата документа';
CREATE INDEX IX_User_document_doc_type_id ON User_document(doc_type_id);

CREATE TABLE IF NOT EXISTS Organisation (
  id          INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  version     INTEGER NOT NULL DEFAULT 1,
  name        VARCHAR(50) NOT NULL,
  full_name   VARCHAR(50) NOT NULL,
  inn         VARCHAR(10) NOT NULL,
  kpp         VARCHAR(9)  NOT NULL,
  address     VARCHAR(200) NOT NULL,
  phone       VARCHAR(20) ,
  is_Active   BOOLEAN
);
COMMENT ON TABLE  Organisation IS 'Организация';
COMMENT ON COLUMN Organisation.id IS 'id';
COMMENT ON COLUMN Organisation.version IS 'Служебное поле hibernate, должно быть NOT NULL';
COMMENT ON COLUMN Organisation.name IS 'Сокращенное наименование';
COMMENT ON COLUMN Organisation.full_name IS 'Полное наименование';
COMMENT ON COLUMN Organisation.inn IS 'ИНН организации';
COMMENT ON COLUMN Organisation.kpp IS 'КПП организации';
COMMENT ON COLUMN Organisation.address IS 'Адрес';
COMMENT ON COLUMN Organisation.phone IS 'Телефон';
COMMENT ON COLUMN Organisation.is_Active IS 'Статус';


CREATE TABLE IF NOT EXISTS Office (
  id          INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  version     INTEGER NOT NULL DEFAULT 1,
  org_id      INTEGER NOT NULL REFERENCES Organisation(id),
  name        VARCHAR(50),
  address     VARCHAR(200),
  phone       VARCHAR(20),
  is_Active    BOOLEAN
);
COMMENT ON TABLE Office IS 'Офис';
COMMENT ON COLUMN Office.id IS 'id';
COMMENT ON COLUMN Office.version IS 'Служебное поле hibernate, должно быть NOT NULL';
COMMENT ON COLUMN Office.org_id IS 'Идентификатор организации, связан с Organisation.id';
COMMENT ON COLUMN Office.name IS 'Название';
COMMENT ON COLUMN Office.address IS 'Адрес';
COMMENT ON COLUMN Office.phone IS 'Телефон';
COMMENT ON COLUMN Office.is_Active IS 'Статус';
CREATE INDEX IX_Office_org_id ON Office(org_id);


CREATE TABLE IF NOT EXISTS User (
  id                   INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  version              INTEGER NOT NULL DEFAULT 1,
  office_id            INTEGER NOT NULL REFERENCES Office(id),
  first_name           VARCHAR(50) NOT NULL,
  last_name          VARCHAR(50) ,
  middle_name          VARCHAR(50) ,
  position             VARCHAR(100) NOT NULL,
  phone                VARCHAR(20) ,
  document_id          INTEGER REFERENCES User_document(id),
  citizenship_id       INTEGER REFERENCES Country(id),
  is_identified        BOOLEAN
);
COMMENT ON TABLE User IS 'Сотрудник';
COMMENT ON COLUMN User.id IS 'id';
COMMENT ON COLUMN User.version IS 'Служебное поле hibernate, должно быть NOT NULL';
COMMENT ON COLUMN User.office_id IS 'Офис, связан с OfficeEntity.id';
COMMENT ON COLUMN User.first_name IS 'Имя';
COMMENT ON COLUMN User.last_name IS 'Фамилия';
COMMENT ON COLUMN User.middle_name IS 'Отчество';
COMMENT ON COLUMN User.position IS 'Должность';
COMMENT ON COLUMN User.phone IS 'Телефон';
COMMENT ON COLUMN User.citizenship_id IS 'Идентификатор гражданства, связан с CountryEntity.id';
COMMENT ON COLUMN User.is_identified IS 'Идентификация';
CREATE INDEX IX_User_office_id ON User(office_id);
CREATE INDEX IX_User_document_id ON User(document_id);
CREATE INDEX IX_User_citizenship_id ON User(citizenship_id);
