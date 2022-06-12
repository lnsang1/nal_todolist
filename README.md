# Spring Boot "TODO LIST" Example Project
Restful API implemented using Spring Boot for a TODO list

## How to Run

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* Build the project by running `mvn clean package` inside todolist module
* Once successfully built, run the service by using the following command:
```
java -jar todolist/target/todolist-0.0.1-SNAPSHOT.war
```

## REST APIs Endpoints
### Create a Work
```
POST /api/v1/works
Accept: application/json
Content-Type: application/json

{
    "code": 200,
    "message": "OK",
    "body": {
        "id": 1,
        "name": "reading book",
        "status": "PLANNING",
        "startDate": "2022-06-12 16:48:00",
        "endDate": "2022-06-12 17:48:00"
    }
}

```

### Update a Work
```
PUT /api/v1/works/{Work id}
Accept: application/json
Content-Type: application/json

{
    "code": 200,
    "message": "OK",
    "body": {
        "id": 1,
        "name": "reading book",
        "status": "PLANNING",
        "startDate": "2022-06-12 16:48:00",
        "endDate": "2022-06-12 17:48:00"
    }
}

```

### Delete a Work
```
DELETE /api/v1/works/{Work id}
Accept: application/json
Content-Type: application/json

{
    "code": 200,
    "message": "OK",
    "body": true
}

```
### Fetch a Work
```
GET /api/v1/works?isSortAsc=<true or false>&page=<this is current page>&size=<this is size of the page>
Accept: application/json
Content-Type: application/json

{
    "code": 200,
    "message": "OK",
    "body": {
        "content": [
            {
                "id": 1,
                "name": "reading book",
                "status": "PLANNING",
                "startDate": "2022-06-12 16:48:00",
                "endDate": "2022-06-12 17:48:00"
            }
        ],
        "pageable": {
            "sort": {
                "sorted": false,
                "unsorted": true,
                "empty": true
            },
            "offset": 0,
            "pageSize": 4,
            "pageNumber": 0,
            "unpaged": false,
            "paged": true
        },
        "totalPages": 0,
        "totalElements": 0,
        "last": true,
        "size": 4,
        "number": 0,
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "first": true,
        "numberOfElements": 0,
        "empty": true
    }
}

```
