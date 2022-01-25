# Calculator

SpringBoot app that works as a calculator.

## Endpoints
### addNumbers 
GET /calculator/add

Parameters (requestParams) firstNumber , secondNumber
Throws InvalidArgumentsException if bad arguments.

### subtractNumbers
GET /calculator/subtract

Parameters (requestParams) firstNumber , secondNumber
Throws InvalidArgumentsException if bad arguments.


## How to clone and build

```
git clone https://github.com/sergiold/pruebasanitas
mvn clean install
java -jar ./target/calculator-1.0.0-SNAPSHOT.jar
```

##versions
- Spring Boot 2.6.3
- Spring Boot Test


