# PPKWU_3

This REST API provides you with informations about string you passed, in CSV, JSON and XML format


CSV:

```
Request:

http://localhost:8081/response_format_controller/analyze_string/csv/fdasFDSAF764**)(())

Response:

lowerCase,upperCase,numbers,specialCharacters
4,5,3,7
```


JSON:
```
Request:

http://localhost:8081/response_format_controller/analyze_string/json/fdasFDSAF764**)(())

Response:

{
    "lowerCase": "4",
    "upperCase": "5",
    "numbers": "3",
    "specialCharacters": "7"
}
```

XML:
```
Request:
http://localhost:8081/response_format_controller/analyze_string/xml/fdasFDSAF764**)(())

Response:

<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<stringStats>
    <lowerCase>4</lowerCase>
    <upperCase>5</upperCase>
    <numbers>3</numbers>
    <specialCharacters>7</specialCharacters>
</stringStats>
```
