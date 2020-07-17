# registration

## About the API

Cadastro de pessoas `/api/v1/register/person`.
Criei 2 pefis = dev: com o banco em memoria H2, test: banco mysql


## Features

* Create a Person: `POST/`
* Delete a Person (by id): `DELETE/1`
* Get report of all Person created: `GET/`
* Find a unique Person by id: `GET/1`
* Update a unique Person by id: `PATCH/1`


**Body:**

```json
{
        "id": 1,
        "fullName": "Ronaldo Macedo",
        "gender": "MALE",
        "email": "ronaldo@bol.com.br",
        "dateOfBirth": "1930-10-10",
        "placeOfBirth": "Rio de Janeiro",
        "nationality": "Brazilian",
        "cpf": "67456302065"
    }
```

### Tecnologias utilizadas

* **Java 8**
* **Spring Boot**
* **Maven**
* **JUnit**
* **REST-assured**
* **Swagger**
* **Model Mapper**
* **Mysql**
* **H2**
* **Docker**
* **Angular**




### Execução

docker-compose up

usuario:admin
password:123

### Run

By default, A API esta disponível no seguinte endereço [http://localhost:8088/api/v1/](http://localhost:8080/api/v1/)

### Documentação

* Swagger (development environment): http://localhost:8088/swagger-ui.html


