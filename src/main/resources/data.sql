INSERT INTO Dockument (code, name) VALUES (03, 'Свидетельство о рождении');
INSERT INTO Dockument (code, name) VALUES (07, 'Военный билет');
INSERT INTO Dockument (code, name) VALUES (08, 'Временное удостоверение, выданное взамен военного билета');
INSERT INTO Dockument (code, name) VALUES (10, 'Паспорт иностранного гражданина');
INSERT INTO Dockument (code, name) VALUES (11, 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории РФ по существу');
INSERT INTO Dockument (code, name) VALUES (12, 'Вид на жительство в Российской Федерации');
INSERT INTO Dockument (code, name) VALUES (13, 'Удостоверение беженца');
INSERT INTO Dockument (code, name) VALUES (15, 'Разрешение на временное проживание в Российской Федерации');
INSERT INTO Dockument (code, name) VALUES (18, 'Свидетельство о предоставлении временного убежища на территории Российской Федерации');
INSERT INTO Dockument (code, name) VALUES (21, 'Паспорт гражданина Российской Федерации');
INSERT INTO Dockument (code, name) VALUES (23, 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');
INSERT INTO Dockument (code, name) VALUES (24, 'Удостоверение личности военнослужащего Российской Федерации');
INSERT INTO Dockument (code, name) VALUES (91, 'Иные документы');

INSERT INTO Country (code, name) VALUES (616,	'ПОЛЬША');
INSERT INTO Country (code, name) VALUES (643,	'РОССИЯ');
INSERT INTO Country (code, name) VALUES (804,	'УКРАИНА');
INSERT INTO Country (code, name) VALUES (792,	'ТУРЦИЯ');
INSERT INTO Country (code, name) VALUES (578,	'НОРВЕГИЯ');
INSERT INTO Country (code, name) VALUES (528,	'НИДЕРЛАНДЫ');
INSERT INTO Country (code, name) VALUES (484,	'МЕКСИКА');
INSERT INTO Country (code, name) VALUES (492,	'МОНАКО');
INSERT INTO Country (code, name) VALUES (496,	'МОНГОЛИЯ');
INSERT INTO Country (code, name) VALUES (434,	'ЛИВИЯ');
INSERT INTO Country (code, name) VALUES (438,	'ЛИХТЕНШТЕЙН');
INSERT INTO Country (code, name) VALUES (440,	'ЛИТВА');
INSERT INTO Country (code, name) VALUES (442,	'ЛЮКСЕМБУРГ');
INSERT INTO Country (code, name) VALUES (276,	'ГЕРМАНИЯ');

INSERT INTO Position (code, name) VALUES (1, 'Директор');
INSERT INTO Position (code, name) VALUES (2, 'Бухгалтер');
INSERT INTO Position (code, name) VALUES (3, 'Начальник отдела');
INSERT INTO Position (code, name) VALUES (4, 'Менеджер');
INSERT INTO Position (code, name) VALUES (5, 'Администратор');
INSERT INTO Position (code, name) VALUES (6, 'Специалист');
INSERT INTO Position (code, name) VALUES (7, 'Работник');


INSERT INTO Organization (name, fullName, inn, kpp, address, phone, isActive) VALUES ('Белл', 'ООО "Белл Интегратор"','1111111111','222222222','г. Москва, ул. Южнопортовая','84957778899','true');
INSERT INTO Organization (name, fullName, inn, kpp, address, phone, isActive) VALUES ('Крок', 'ООО "Крок"','3333333333','222232222','г. Москва, ул. Таганская','84953778899','true');

INSERT INTO Office (orgId) VALUES ('2');

INSERT INTO User (officeId, first_Name, position) VALUES (1, 'Sasha', 'Менеджер');