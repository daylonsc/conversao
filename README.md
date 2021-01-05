# API Conversion

## Description

API to convert currency

## What you need to run this project
- Internet
- Git
- Java 11+
- Maven 3.6.1+
- IDE (ex.: Eclipse, IntelliJ)

## Install with maven command

```bash
mvn clean install
```

### Run Code
Import the project in your ide. The url is localhost:8080

### Body to test a conversion
```bash
{
"currency_from" : "USD",
"currency_to": "BRL",
"value" : 20
}
```