# Drools Implementation using Spring Boot
This repository is implementation of Drools Rule engine with Spring Boot Application with a REST API to test the rules

# Introduction:
Drools is a Business Rule Management System (BRMS) solution. It provides a rule engine which processes facts and produces output as a result of rules and facts processing. Centralization of business logic makes it possible to introduce changes fast and cheap.

It also bridges the gap between the Business and Technical teams by providing a facility for writing the rules in a format which is easy to understand.

# Approach
1. Add maven dependecies for drools-core & kie-spring
2. Add module xml file inside resources/META-INF called kmodule.xml
3. Add drl file in resource/sample (folder path should be same as defined in kmodule.xml)

# API Description: 
- METHOD: POST
- URL: http://localhost:8080/Drools/v1/rules/calculateResult
- Body: This is a Sample Request with 2 Subjects and score

```json
{
    "marksheet": [
        {
            "subject": "MATHS",
            "marks": 80,
            "totalMarks": 100
        },
        {
            "subject": "SCIENCE",
            "marks": 80,
            "totalMarks": 100
        }
    ]
}
```

Wiki Link: https://www.drools.org/
