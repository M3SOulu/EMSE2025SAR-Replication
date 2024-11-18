# Question Management System (QMS) Backend

This project handle all the backend processing for question management.
The functions include CRUD for questions, codes, choices(answers),question cateogries and configurations.
And we also provide get test(set of questions based on configurations) function.


## Project Struture

```text

./main/
├── java
│   └── baylor
│       └── csi
│           └── questionManagement
│               ├── Exception
│               │   ├── InstanceCreatingException.java
│               │   └── ResourceNotFoundException.java
│               ├── controller
│               │   ├── CategoryController.java
│               │   ├── CategoryInfoController.java
│               │   ├── ConfigurationController.java
│               │   ├── LanguageController.java
│               │   ├── QuestionController.java
│               │   └── TestController.java
│               ├── model
│               │   ├── Category.java
│               │   ├── Choice.java
│               │   ├── Code.java
│               │   ├── Configuration.java
│               │   ├── ConfigurationGroup.java
│               │   ├── Language.java
│               │   ├── Person.java
│               │   ├── Question.java
│               │   ├── dto
│               │   │   ├── CategoryInfoDto.java
│               │   │   ├── QuestionCountDto.java
│               │   │   ├── QuestionDto.java
│               │   │   ├── QuestionSingleCodeDto.java
│               │   │   └── UserRolesDto.java
│               │   └── supermodel
│               │       ├── AuditModel.java
│               │       ├── ICPCEntity.java
│               │       ├── IdEntityObject.java
│               │       └── UUIDHashedEntityObject.java
│               ├── repository
│               │   ├── CategoryRepository.java
│               │   ├── ChoiceRepository.java
│               │   ├── CodeRepository.java
│               │   ├── ConfigurationRepository.java
│               │   ├── LanguageRepository.java
│               │   ├── PersonRepository.java
│               │   └── QuestionRepository.java
│               ├── security
│               │   ├── SecurityAuditorAware.java
│               │   └── SecurityConfig.java
│               └── service
│                   └── QuestionService.java
└── resources
    └── application.properties
```
 Exception: define self-used exceptions
 
 controller : handle the restful api
 
 model: business model; dtos for restful api to get structured information
 
 repository: handle queries
 
 security: handle spring auditor and securityConfig handle keycloak
 
 service: provide methods and functions for controllers

## RESTFUL API

|   | For Examination MS                          |                |              |               |                                         |                    |
|---|---------------------------------------------|----------------|--------------|---------------|-----------------------------------------|--------------------|
|   | type                                        | path           | params       | params types  | body                                    | returns            |
| 1 | GET                                         | /test          | ?configId=42 | configId-long |                                         | Test               |
| 2 | CRUD                                        | /configuration |              |               |                                         | Configuration      |
| 3 | GET                                         | /categoryinfo  |              |               |                                         | CategoryInfoAllDto |
|   |                                             |                |              |               |                                         |                    |

|   | For QMS frontend                            |           |        |              |                                         |                 |
|---|---------------------------------------------|-----------|--------|--------------|-----------------------------------------|-----------------|
|   | type                                        | path      | params | params types | body                                    | returns         |
| 5 | CRUD                                        | /question |        |              | full question body with code and choice | question        |
| 6 | CRUD                                        | /language |        |              |                                         |                 |
| 8 | GET(find questions by category or/and name) | /question |        |              | {id:1,name:ddd}                         | List<questions> |
|   | CRUD                                        | /category |        |              |                                         |                 |


### Entities,Dtos	

```text

Language	           {"id":16, "name":"java"}								
									
Choice	               {"id":77, "body":"java is actually awesome", "correct":true}								
									
Code	               {"id":15, "languageId":16, "body":"public static void main(args ...)"}								
									
Question	           {"id":42, "title":"How to init springboot", "level":4, "category":[1, 2, 4], "body":"text...", "code":[...codes...], "choice":[...choices...]}								
									
Category	           {"id":1, "name":"Program Design", "description":"How to write nice code.", "questions":[ question ids ]}								
									
AnswerDto	           {"answers"=[{"qid":42, "correct":[choice ids]}, ...]}								
									
CategoryInfoDto	       {"categoryId":1, "name":"Program Design", "description":"How to wrice sexy code.", "questions":[{"level":1, "language":java, "count":25}, {"level":2, "language":javascript "count": 15}, ...]}								
									
CategoryInfoAllDto	   {"category":[...CategoryInfoDtos]}								
									
ConfigurationGroup	   {"category":1, "level":4, "language":java, "count":7}								
									
Configuration	       {"id":22, "name":"hard math test", "description":"test to evaluate if you are prepared to take comp theory", "groups":[ ... ConfigurationGroups]}								
									
Test	               {"configurationId":22, "languageId": 16, "questions":[ ... Questions ...]}		
```

### Prerequisites

Just Java(8 or 11 both works) and maven.

### Details

There are some difficulty when you deal with question CRUD.

Take creation as an example, you will get a complex RequestBody which contains 

attributes of question and also arrays of choices and codes.


An example:

```
{
    "id": 9,
    "title": "How to Init react js",
    "level": 2,
    "body": "Select an option, hfffffffffffffffffffffffffff",
    "choices": [
        {
            "id": 25,
            "body": "mvn thorntdfdfdfdrun",
            "correct": false
        },
        {
            
            "body": "mvn ttttttttttttttttt",
            "correct": false
        },
        {
            "id": 26,
            "body": "java -jar sfffffffbootapp.jar",
            "correct": true
        },
        {
            "id": 27,
            "body": "scp ./spring sprdaaaaa5ng:/home/cerny/run",
            "correct": false
        }
    ],
    "codes": [
        {
            "id": 7,
            "languageId":"1",
            "body": "private static void greed(){\n   System.print.out(\"hello\")\n};"
        },
        {
            "id": 8,
            "languageId":"3",
            "body": "() => {\nconsole.log(\"hello\")\n};"
        }
    ],
    "categories": [1,2]
}
```

You need to parse the structure correctly, and create each codes and choices correctly.

Then you also need to add the question to the right cateogry.

The logic is kind of difficulty.

What is more difficult, when it comes to updating(PUT), you also need to take care of each choice and code.

If it isn't in the database, you need to create it. If it is in the database you need to update them.

We have function like

#### private void createNewCodeFromJsonForQuestion(Question question, Map<String, Object> code)

#### private void updateCodeFromJsonForQuestion(Set<Code> codesInDB, Map<String, Object> code)

to support this.

The main logic in updating question fuction is:

You parse the question json you get and have a set of choices called choicesReceived.

And then you fetch the orginal choices from database called choicesFromDB.

First, you do a loop visit for choicesFromDB and check if each choice in choicesReceived.




