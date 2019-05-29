INSERT INTO Document_type (code, name) VALUES (03, 'Свидетельство о рождении');
INSERT INTO Document_type (code, name) VALUES (07, 'Военный билет');
INSERT INTO Document_type (code, name) VALUES (08, 'Временное удостоверение, выданное взамен военного билета');
INSERT INTO Document_type (code, name) VALUES (10, 'Паспорт иностранного гражданина');
INSERT INTO Document_type (code, name) VALUES (11, 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории РФ по существу');
INSERT INTO Document_type (code, name) VALUES (12, 'Вид на жительство в Российской Федерации');
INSERT INTO Document_type (code, name) VALUES (13, 'Удостоверение беженца');
INSERT INTO Document_type (code, name) VALUES (15, 'Разрешение на временное проживание в Российской Федерации');
INSERT INTO Document_type (code, name) VALUES (18, 'Свидетельство о предоставлении временного убежища на территории Российской Федерации');
INSERT INTO Document_type (code, name) VALUES (21, 'Паспорт гражданина Российской Федерации');
INSERT INTO Document_type (code, name) VALUES (23, 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');
INSERT INTO Document_type (code, name) VALUES (24, 'Удостоверение личности военнослужащего Российской Федерации');
INSERT INTO Document_type (code, name) VALUES (91, 'Иные документы');

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

INSERT INTO Organisation (name, full_Name, inn, kpp, address, phone, is_Active) VALUES ('Белл', 'ООО "Белл Интегратор"',            '1111111111','222222222','г. Москва, ул. Южнопортовая','84957778899','true');
INSERT INTO Organisation (name, full_Name, inn, kpp, address, phone, is_Active) VALUES ('Крок', 'ООО "Крок"',                       '3333333333','222232222','г. Москва, ул. Таганская','84953778899','true');
INSERT INTO Organisation (name, full_Name, inn, kpp, address, phone, is_Active) VALUES ('HPE',  'ООО "Хюлед Паккард Энтерпрайз"',   '1111671111','222223322','г. Москва, ул. Южная','84959955635','true');
INSERT INTO Organisation (name, full_Name, inn, kpp, address, phone, is_Active) VALUES ('MS',   'ООО "Майкрософт РУС"',             '3333863333','222236822','г. Москва, ул. Каширская','84953222322','true');
INSERT INTO Organisation (name, full_Name, inn, kpp, address, phone, is_Active) VALUES ('Белл', 'ООО "Белл Интегратор Рус"',        '2111111111','222222222','г. Москва, ул. Южнопортовая','84957778899','false');

INSERT INTO Office (org_id, name, address, phone,is_Active ) VALUES (2, 'Kiev', 'Kiev, Maidan square, 1', 800012345611, true);
INSERT INTO Office (org_id, name, address, phone,is_Active ) VALUES (2, 'Москва', 'г. Москва, ул. Угрешская, д1. к.5', 84952223334, true);
INSERT INTO Office (org_id, name, address, phone,is_Active ) VALUES (1, 'Брест', 'респ. Беларусь, ул. Лукашенко, д.2', 84957774441, true);
INSERT INTO Office (org_id, name, address, phone,is_Active ) VALUES (1, 'Видное','МО г. Видное ул. Промышленная, д.34', 89457766222, true);



INSERT INTO User (office_id, first_Name, position) VALUES (1, 'Sasha', 'Менеджер');
INSERT INTO User (office_id, first_Name, position) VALUES (2, 'Pasha', 'Менеджер');
INSERT INTO User (office_id, first_Name, position) VALUES (1, 'Gogi', 'Программист');
INSERT INTO User (office_id, first_Name, position) VALUES (2, 'Senya', 'Бухгалтер');

