##ProjectOne - my first REST-full API.

### Установка
- Установите JDK 1.8 (если еще не установлено)
- Добавьте переменные окружения:

```sh
name: JAVA_HOME
Value: C:\Program Files\Java\jdk1.8.0_131
```

и добавьте в переменную path:
```;%JAVA_HOME%\bin```

Проверьте установку:

в консоли введите:

```sh
echo %JAVA_HOME%    должно вернуть C:\Program Files\Java\jdk1.8.0_131
java -version       должно вернуть версию java
```

- Установитье maven http://apache-mirror.rbc.ru/pub/apache/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz

Распакуйте архив в c:/maven, или в другую директорию.
Добавьте переменные окружения:

```sh
Name: M2_HOME
Value: c:/maven         или ваша директория
```

добавьте в path:

```sh
;%M2_HOME%\bin
```

Проверьте установку:
в консоли введите 

 ```sh 
 mvn --version      должны получить версию maven
 ```
 
- можно приступать к запуску:

откройте консоль в той директории, куда вы распаковали приложение и выполните комманду:

```sh 
mvn spring-boot:run
```

- приложение будет доступно по ссылке

```sh
http://localhost:8888
```

### Использование

##### Вывод справочников

для получения справочника кодов и наименований документов выполните POST запрос:
http://localhost:8888/api/docs
пример ответа:

```
[
  {
    “name”:“”,
    “code”:””
  },
  ...
]
```

для получения справочника кодов и наименований стран выполните POST запрос:
http://localhost:8888/api/countries

пример ответа:
```
[
  {
    “name”:“”,
    “code”:””
  },
  ...
]
```

Для получения списка организаций выполните POST запрос:
http://localhost:8888/api/organization/list

``` json
Тело запроса:
{
  “name”:””, //обязательный параметр
  “inn”:””,
  “isActive”:””
}
Тело ответа:
[
  {
    “id”:””,
    “name”:””,
    “isActive”:””
  },
  ...
]
...
```

Для получения организации по идентификатору выполниет GET запрос
http://localhost:8888/api/organization/id

``` json
Тело ответа:
{
  “id”:””,
  “name”:””,
  “fullName”:””,
  “inn”:””,
  “kpp”:””,
  “address”:””,
  “phone”,””,
  “isActive”:””
}
```

Для обновления записи об организации выполните POST запрос:
http://localhost:8888/api/organization/update

``` json
Тело запроса:
{
  “id”:””, //обязательный параметр
  “name”:””, //обязательный параметр
  “fullName”:””, //обязательный параметр
  “inn”:””, //обязательный параметр
  “kpp”:””,  //обязательный параметр
  “address”:””, //обязательный параметр
  “phone”,””,
  “isActive”:””
}
Тело ответа успешного ответа:
{
    “result”:”success”
}
```

Для сохранения организации в БД выполните POST запрос:
http://localhost:8888/api/organization/save

``` 
Тело запроса:
{
  “name”:””, //обязательный параметр
  “fullName”:””, //обязательный параметр
  “inn”:””, //обязательный параметр
  “kpp”:””, //обязательный параметр
  “address”:””, //обязательный параметр
  “phone”,””,
  “isActive”:”true”
}
Тело успешного ответа:
{
    “result”:”success”
}
```

Для получения списка оффисов выполните POST запрос:
http://localhost:8888/api/office/list

```
Тело запроса:
{
  “orgId”:””, //обязательный параметр
  “name”:””,
  “phone”:””,
  “isActive” 
}

Тело успешного ответа:
[
  {
    “id”:””,
    “name”:””,
    “isActive”:””
  },
  ...
]
```

Для получения офиса по идентификатору выполниет GET запрос
http://localhost:8888/api/office/id

```
Тело успешного ответа:
{
  “id”:””,
  “name”:””,
  “address”:””,
  “phone”,””,
  “isActive”:””
}
```

Для обновления записи об офисе выполните POST запрос:
http://localhost:8888/api/office/update

```
Тело запроса:
{
  “id”:””, //обязательный параметр
  “name”:””, //обязательный параметр
  “address”:””, //обязательный параметр
  “phone”,””,
  “isActive”:”” 
}

Тело успешного ответа:
{
    “result”:”success”
}
```

Для сохранения офиса в БД выполните POST запрос:
http://localhost:8888/api/office/save

```
Тело запроса:
{
  “orgId”:””, //обязательный параметр
  “name”:””,
  “address”:””,
  “phone”,””,
  “isActive”:””
}

Тело успешного ответа:
{
    “result”:”success”
}
```

Для получения списка пользвателей выполните POST запрос:
http://localhost:8888/api/user/list

```
Тело запроса:
{
  “officeId”:””, //обязательный параметр
  “firstName”:””,
  “lastName”:””,
  “middleName”:””,
  “position”,””,
  “docCode”:””,
  “citizenshipCode”:””
}
Тело успешного ответа:
{
  “id”:””,
  “firstName”:””,
  “secondName”:””,
  “middleName”:””,
  “position”:””
}
```

Для получения пользователя по идентификатору выполниет GET запрос
http://localhost:8888/api/user/id

```
Тело успешного ответа:
{
  “id”:””,
  “firstName”:””,
  “lastName”:””,
  “middleName”:””,
  “position”:””
  “phone”,””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipName”:””,
  “citizenshipCode”:””,
  “isIdentified”:””
}
```
Для обновления записи об пользователе выполните POST запрос:
http://localhost:8888/api/user/update

```
Тело запроса:
{
  “id”:””, //обязательный параметр
  “officeId”:””,
  “firstName”:””, //обязательный параметр
  “lastName”:””,
  “middleName”:””,
  “position”:”” //обязательный параметр
  “phone”,””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipCode”:””,
  “isIdentified”:””

Тело успешного ответа:
{
    “result”:”success”
}
```

Для сохранения ползователя в БД выполните POST запрос:
http://localhost:8888/api/user/save
```
Тело запроса:
{
  “officeId”:””, //обязательный параметр
  “firstName”:””, //обязательный параметр
  “secondName”:””,
  “middleName”:””,
  “position”:”” //обязательный параметр
  “phone”,””,
  “docCode”:””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipCode”:””,
  “isIdentified”:””
}
Тело успешного ответа:
{
    “result”:”success”
}
```




























