# Getting Started

### Reference Documentation
Change character set to utf-8
```sql
show variables like 'char%';

alter database gao_kao CHARACTER SET utf8;

SELECT default_character_set_name FROM information_schema.SCHEMATA S WHERE schema_name = "gao_kao";

ALTER TABLE gao_kao.yggk_school_info CONVERT TO CHARACTER SET utf8;

```


### [API Interface](http://localhost:8080/swagger-ui.html)

