##ProjectOne - my first REST-full API.

### Installation
1. Install JDK 1.8
2. Add local variables
Name: ```JAVA_HOME```, Value:```C:\Program Files\Java\jdk1.8.0_131```
and add to path:```;%JAVA_HOME%\bin```
Check installation:in cmd ```echo %JAVA_HOME%```
You must get ```java -version```
3. Install maven http://apache-mirror.rbc.ru/pub/apache/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz
Extract archive to c:/maven, or other.
add local variables:Name:```M2_HOME```, Value:```c:/maven```
add to path:```;%M2_HOME%\bin```
Check installation: in cmd ```mvn --version```
3. Start the project:
    open console on project path, and run ```mvn spring-boot:run```
    project will be accessing in http://localhost:8888
4. Import to Intellij IDEA
File->Open
Change pom.xml in the root project path
Ok->Open as Project

###Using
You must use http GET method for getting entities for id, and use http POST method for other operations.

#####api/organization

Use ***api/organization/list*** for list organisations:
``` json
In:
{
  “name”:””, //required
  “inn”:””,
  “isActive”:””
}
Out:
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
#####api/organization/{id}
Use for get organisation by id
``` json
Out:
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

#####api/organization/update
Use for update your organisation
``` json
In:
{
  “id”:””, //required
  “name”:””, //required
  “fullName”:””, //required
  “inn”:””, //required
  “kpp”:””,  //required
  “address”:””, //required
  “phone”,””,
  “isActive”:””
}

Out:
{
    “result”:”success”
}
```
#####api/organization/save
Use for save organisation
``` In:
{
  “name”:””, //required
  “fullName”:””, //required
  “inn”:””, //required
  “kpp”:””, //required
  “address”:””, //required
  “phone”,””,
  “isActive”:”true”
}

Out:
{
    “result”:”success”
}
```

##### api/office/list
```
In:
{
  “orgId”:””, //required
  “name”:””,
  “phone”:””,
  “isActive” 
}

Out:
[
  {
    “id”:””,
    “name”:””,
    “isActive”:””
  },
  ...
]
```

#####api/office/{id}
```
Out:
{
  “id”:””,
  “name”:””,
  “address”:””,
  “phone”,””,
  “isActive”:””
}
```
#####api/office/update
```
In:
{
  “id”:””, //required
  “name”:””, //required
  “address”:””, //required
  “phone”,””,
  “isActive”:”” 
}

Out:
{
    “result”:”success”
}
```

#####api/office/save
```
In:
{
  “orgId”:””, //required
  “name”:””,
  “address”:””,
  “phone”,””,
  “isActive”:””
}

Out:
{
    “result”:”success”
}
```

#####api/user/list
```
In (фильтр):
{
  “officeId”:””, //required
  “firstName”:””,
  “lastName”:””,
  “middleName”:””,
  “position”,””,
  “docCode”:””,
  “citizenshipCode”:””
}
Out:
{
  “id”:””,
  “firstName”:””,
  “secondName”:””,
  “middleName”:””,
  “position”:””
}
```

#####api/user/{id}

```
Out:
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

#####api/user/update
```
In:
{
  “id”:””, //required
  “officeId”:””,
  “firstName”:””, //required
  “lastName”:””,
  “middleName”:””,
  “position”:”” //required
  “phone”,””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipCode”:””,
  “isIdentified”:””

Out:
{
    “result”:”success”
}
```

#####api/user/save
```
In:
{
  “officeId”:””, //required
  “firstName”:””, //required
  “secondName”:””,
  “middleName”:””,
  “position”:”” //required
  “phone”,””,
  “docCode”:””,
  “docName”:””,
  “docNumber”:””,
  “docDate”:””,
  “citizenshipCode”:””,
  “isIdentified”:””
}
Out:
{
    “result”:”success”
}
```
####Directories:
#####api/docs
```
[
  {
    “name”:“”,
    “code”:””
  },
  ...
]
```

####User document types
#####api/countries
```
[
  {
    “name”:“”,
    “code”:””
  },
  ...
]
```



























